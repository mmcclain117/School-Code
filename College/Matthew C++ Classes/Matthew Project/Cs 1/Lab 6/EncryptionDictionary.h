#ifndef ENCRYPTIONDICTIONARY_H
#define ENCRYPTIONDICTIONARY_H
#include <iostream>
#include <fstream>
#include <string>
using namespace std;
//This Class Holds The Definitions For Each Character In My Encryption Technique.
//This Class Has The Ability To Both Encrypt And Decrypt Files Using The Character Library Defined In Itself.

class EncryptionDictionary
{
private:
	ifstream read;
	ofstream write;
public:
	EncryptionDictionary()
	{}
	void Encrypt(string filename)
	{
		read.open(filename);
		write.open("EncryptedResult.txt");
		int iterations(0);
		while (!read.eof())
		{
			string temp;
			getline(read, temp);
			int chars(temp.size());
			if (iterations > 0)//This Helps Fix A Bug Where An Extra Blank Line Would Be Added At The End Of The Encrypted File
			{
				write << endl;
			}
			for (int i = 0; i < chars; i++)
			{
				char encrypt(temp[i]);
				switch (encrypt)
				{
				case ' ': write << "MEAP";
					break;
				case '.': write << "special1";
					break;
				case '!': write << "special2";
					break;
				case '?': write << "special3";
					break;
				case 'a': write << "0";
					break;
				case 'b': write << "1";
					break;
				case 'c': write << "2";
					break;
				case 'd': write << "3";
					break;
				case 'e': write << "4";
					break;
				case 'f': write << "5";
					break;
				case 'g': write << "6";
					break;
				case 'h': write << "7";
					break;
				case 'i': write << "8";
					break;
				case 'j': write << "9";
					break;
				case 'k': write << "10";
					break;
				case 'l': write << "11";
					break;
				case 'm': write << "12";
					break;
				case 'n': write << "13";
					break;
				case 'o': write << "14";
					break;
				case 'p': write << "15";
					break;
				case 'q': write << "16";
					break;
				case 'r': write << "17";
					break;
				case 's': write << "18";
					break;
				case 't': write << "19";
					break;
				case 'u': write << "20";
					break;
				case 'v': write << "21";
					break;
				case 'w': write << "22";
					break;
				case 'x': write << "23";
					break;
				case 'y': write << "24";
					break;
				case 'z': write << "25";
					break;
				case 'A': write << "26";
					break;
				case 'B': write << "27";
					break;
				case 'C': write << "28";
					break;
				case 'D': write << "29";
					break;
				case 'E': write << "30";
					break;
				case 'F': write << "31";
					break;
				case 'G': write << "32";
					break;
				case 'H': write << "33";
					break;
				case 'I': write << "34";
					break;
				case 'J': write << "35";
					break;
				case 'K': write << "36";
					break;
				case 'L': write << "37";
					break;
				case 'M': write << "38";
					break;
				case 'N': write << "39";
					break;
				case 'O': write << "40";
					break;
				case 'P': write << "41";
					break;
				case 'Q': write << "42";
					break;
				case 'R': write << "43";
					break;
				case 'S': write << "44";
					break;
				case 'T': write << "45";
					break;
				case 'U': write << "46";
					break;
				case 'V': write << "47";
					break;
				case 'W': write << "48";
					break;
				case 'X': write << "49";
					break;
				case 'Y': write << "50";
					break;
				case 'Z': write << "51";
					break;
				default: write << "An Unsupported Character Or Blank Line Was Read, Skipping..." << endl;
				}
				write << endl;
			}
			iterations++;
			write << "BLARR!";//Denotes A New Line
		}
		read.close();
		write.close();
	}
	void Decrypt(string filename)
	{
		read.open(filename);
		write.open("DecryptedResult.txt");
		while (!read.eof())
		{
			string temp;
			getline(read, temp);
			if (temp == "MEAP")//Decryption Has To Be Done In An If-Else If Manner Because Switch Statements Do Not Accept Non-Integral Values Such As Strings And Const Char Pointers As Parameters
			{
				write << ' ';
			}
			else if (temp == "BLARR!")
			{
				write << endl;
			}
			else if (temp == "special1")
			{
				write << '.';
			}
			else if (temp == "special2")
			{
				write << '!';
			}
			else if (temp == "special3")
			{
				write << '?';
			}
			else if (temp == "0")
			{
				write << 'a';
			}
			else if (temp == "1")
			{
				write << 'b';
			}
			else if (temp == "2")
			{
				write << 'c';
			}
			else if (temp == "3")
			{
				write << 'd';
			}
			else if (temp == "4")
			{
				write << 'e';
			}
			else if (temp == "5")
			{
				write << 'f';
			}
			else if (temp == "6")
			{
				write << 'g';
			}
			else if (temp == "7")
			{
				write << 'h';
			}
			else if (temp == "8")
			{
				write << 'i';
			}
			else if (temp == "9")
			{
				write << 'j';
			}
			else if (temp == "10")
			{
				write << 'k';
			}
			else if (temp == "11")
			{
				write << 'l';
			}
			else if (temp == "12")
			{
				write << 'm';
			}
			else if (temp == "13")
			{
				write << 'n';
			}
			else if (temp == "14")
			{
				write << 'o';
			}
			else if (temp == "15")
			{
				write << 'p';
			}
			else if (temp == "16")
			{
				write << 'q';
			}
			else if (temp == "17")
			{
				write << 'r';
			}
			else if (temp == "18")
			{
				write << 's';
			}
			else if (temp == "19")
			{
				write << 't';
			}
			else if (temp == "20")
			{
				write << 'u';
			}
			else if (temp == "21")
			{
				write << 'v';
			}
			else if (temp == "22")
			{
				write << 'w';
			}
			else if (temp == "23")
			{
				write << 'x';
			}
			else if (temp == "24")
			{
				write << 'y';
			}
			else if (temp == "25")
			{
				write << 'z';
			}
			else if (temp == "26")
			{
				write << 'A';
			}
			else if (temp == "27")
			{
				write << 'B';
			}
			else if (temp == "28")
			{
				write << 'C';
			}
			else if (temp == "29")
			{
				write << 'D';
			}
			else if (temp == "30")
			{
				write << 'E';
			}
			else if (temp == "31")
			{
				write << 'F';
			}
			else if (temp == "32")
			{
				write << 'G';
			}
			else if (temp == "33")
			{
				write << 'H';
			}
			else if (temp == "34")
			{
				write << 'I';
			}
			else if (temp == "35")
			{
				write << 'J';
			}
			else if (temp == "36")
			{
				write << 'K';
			}
			else if (temp == "37")
			{
				write << 'L';
			}
			else if (temp == "38")
			{
				write << 'M';
			}
			else if (temp == "39")
			{
				write << 'N';
			}
			else if (temp == "40")
			{
				write << 'O';
			}
			else if (temp == "41")
			{
				write << 'P';
			}
			else if (temp == "42")
			{
				write << 'Q';
			}
			else if (temp == "43")
			{
				write << 'R';
			}
			else if (temp == "44")
			{
				write << 'S';
			}
			else if (temp == "45")
			{
				write << 'T';
			}
			else if (temp == "46")
			{
				write << 'U';
			}
			else if (temp == "47")
			{
				write << 'V';
			}
			else if (temp == "48")
			{
				write << 'W';
			}
			else if (temp == "49")
			{
				write << 'X';
			}
			else if (temp == "50")
			{
				write << 'Y';
			}
			else if (temp == "51")
			{
				write << 'Z';
			}
			else
			{
				write << "An Unsupported Character Or Blank Line Was Read, Skipping..." << endl;
			}
		}
		read.close();
		write.close();
	}
};
#endif