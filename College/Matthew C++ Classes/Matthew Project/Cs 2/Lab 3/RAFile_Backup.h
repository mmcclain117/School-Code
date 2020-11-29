#ifndef RA_FILE_H
#define RA_FILE_H

#include <fstream>

using namespace std;

#include "WCS_Pointer.h"
#include "WCS_UB_Array.h"

typedef unsigned long UINT;

class RAFile
{
private:
	struct RecInfo
	{
		streamoff		Offset;
		UINT			Length;
	};

	RAFile(const RAFile &);
	RAFile &	operator =	(const RAFile &);

	UINT							NumRecords;
	streamoff						EndOfDataRecords;
	WCS_UB_Array <RecInfo, UINT>	RecInfoArray;
	fstream							File;
public:
	enum	Exceptions { OK, FileOpenFailure, FileAlreadyOpen, FileNotOpen, RecordDoesNotExist };
	RAFile()
	{
		NumRecords = 0;
	}
	~RAFile()
	{
		//Close();//	write RecInfoArray following the Records in the file
	}
	Exceptions	Close()
	{
		//	do normal checking to make sure file is open
		//	write NumRecords back to file
		//	goto EndOfDataRecords and write RecInfoArray back to file starting at that point
		//	close the file
		if (!File.is_open())
			return FileNotOpen;
		else
		{
			cout << "Writing Database To File..." << endl;
			File.seekp(0);//Set file write pointer to beginning of file
			File.write((const char *)&NumRecords, sizeof(NumRecords));
			File.seekp(EndOfDataRecords);//Set file write pointer to end of file
			for (UINT i = 0; i < NumRecords; i++)//Writes contents of RecInfoArray to file
				File.write((char *)&RecInfoArray[i], sizeof(RecInfo));
			File.close();
			return OK;
		}
	}
	Exceptions	Get(UINT Index, string & Data)
	{
		if (File.is_open())
			if (Index < NumRecords)
			{
				cout << "Retrieving Data..." << endl;
				if (RecInfoArray[Index].Length > 0)
				{
					char *	pChar;

					pChar = new char[RecInfoArray[Index].Length + 1];	// the data in each record does not include the end-of-string mark, only the acutal characters
					File.seekg(RecInfoArray[Index].Offset);
					File.read(pChar, RecInfoArray[Index].Length);
					pChar[RecInfoArray[Index].Length] = '\0';		// add end-of-string mark to the end of the characters
					Data = pChar;
					delete[] pChar;
				}
				else
					Data = "No Data In This Record.";
				return OK;
			}
			else
			{
				Data = "Record Does Not Exist.";
				return RecordDoesNotExist;
			}
		else
			return FileNotOpen;
	}
	Exceptions	Insert(UINT Index, const string & Data)
	{
		UINT i;

		if (!File.is_open())
			return FileNotOpen;
		else
		{
			if (Index >= NumRecords)
			{
				return Replace(Index, Data);
			}
			else
			{
				//There is a bug in this function that causes the record at Index and Index + 1 to be replaced with Data.
				//for (i = NumRecords; i >= Index + 1; i--)//For some reason the program freezes if Index is 0. This indicates an infinite loop.
					//RecInfoArray [i] = RecInfoArray [i - 1];//Fixed the problem by doing some mathematical manipulation.
				for (i = NumRecords - 1; i >= Index; i--)
					RecInfoArray [i + 1] = RecInfoArray [i];
				if (Data.length() > RecInfoArray[Index].Length)	// is there enough space where the record is now
				{
					NumRecords++;
					return AddRecord(Index, Data);	// no, need to add it somewhere else
				}
				else
				{	// yes, just overwrite the record
					File.seekp(RecInfoArray[Index].Offset);
					File.write((const char *)Data.c_str(), Data.length());
					RecInfoArray[Index].Length = Data.length();
					NumRecords++;
					return OK;
				}
			}
		}

		//	do normal checking about file open, etc
		//	if user wants to insert a new index past NumRecords
		//			call Replace
		//		else
		//			generally, we are going to write a loop where
		//			for (i = NumRecords - 1; i >= Index; i--)
		//				RecInfoArray [i + 1] = RecInfoArray [i];
		//			write the Data to the file
		//			put the offset and length of the data just written into RecInfoArray [Index]
		//			make sure to update NumRecords
	}
	Exceptions	AddRecord(UINT Index, const string & Data)
	{
		File.seekp(EndOfDataRecords);
		RecInfoArray[Index].Offset = EndOfDataRecords;
		RecInfoArray[Index].Length = Data.length();
		File.write((const char *)Data.c_str(), Data.length());
		EndOfDataRecords = File.tellp();
		return OK;
	}
	Exceptions	Open(const string & FileName)
	{
		if (File.is_open())
			return FileAlreadyOpen;
		else
		{
			File.open((const char *)FileName.c_str(), ios_base::in | ios_base::out | ios_base::binary);
			if (!File.is_open())	// did the open fail?
			{					// yes
				File.clear();		// clear error flags
				File.open((const char *)FileName.c_str(), ios_base::out | ios_base::binary);	// this will cause the file to be created
				if (!File.is_open())	//  did the open fail?
				{
					File.clear();
					return FileOpenFailure;		// yes, return error code
				}
				else
				{
					NumRecords = 0;
					File.write((const char *)&NumRecords, sizeof(NumRecords));
					File.close();
					File.open((const char *)FileName.c_str(), ios_base::in | ios_base::out | ios_base::binary);
					if (!File.is_open())
					{
						File.clear();
						return FileOpenFailure;
					}
					else;
				}
			}
			else;
		}
		File.seekg(0);		// make sure we are at the beginning of the file
		File.read((char *)&NumRecords, sizeof(NumRecords));
		if (NumRecords > 0)
		{
			File.seekg(-((long)(NumRecords * sizeof(RecInfo))), ios_base::end);
			EndOfDataRecords = File.tellg();
			for (UINT i = 0; i < NumRecords; i++)
				File.read((char *)&RecInfoArray[i], sizeof(RecInfo));
		}
		else
			EndOfDataRecords = File.tellg();
		return OK;
	}
	Exceptions	Replace(UINT Index, const string & Data)
	{
		UINT i;

		if (File.is_open())
			if (Index >= NumRecords)
			{		// need to add empty records to the data base to fill it out to the needed size
				for (i = NumRecords; i < Index; i++)
				{
					RecInfoArray[i].Offset = 0;
					RecInfoArray[i].Length = 0;
				}
				NumRecords = Index + 1;
				return AddRecord(Index, Data);
			}
			else
			{		// replace a record
				if (Data.length() > RecInfoArray[Index].Length)	// is there enough space where the record is now
					return AddRecord(Index, Data);	// no, need to add it somewhere else
				else
				{	// yes, just overwrite the record
					File.seekp(RecInfoArray[Index].Offset);
					File.write((const char *)Data.c_str(), Data.length());
					RecInfoArray[Index].Length = Data.length();
					return OK;
				}
			}
		else
			return FileNotOpen;
	}
	bool IsOpen() const
	{
		return File.is_open();
	}
	int Size()
	{
		return NumRecords;
	}
};
#endif