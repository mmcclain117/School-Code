#ifndef UBARRAY_H
#define UBARRAY_H

#include "WCS_Pointer.h"
using namespace std;

// Notes:
// Whatever type that is used for the index in the class below MUST support the comparison operators ==, !=, <, <=, >, >=
// I wrote this program in the style I did because my preference is to do everything inside the class. I'm not opposed to
// using the scope resolution operator, but I prefer to use it sparingly, because if I use it everywhere, I confuse myself.
// Also, doing everything in the class is client friendly as the client only has to call functions, which will do everything for them.
// Since the typename and class keywords do the exact same thing for templates, I use typename since it makes more sense to me in this context.
template<typename DATA, typename INDEX>
class UBArray {
private:
	int currentindex;
	int size;
	struct Node: public RefCount {
		INDEX Index;
		DATA Data;
		WCS_Pointer<Node> pNext;
		WCS_Pointer<Node> pPrev;

		Node(const INDEX &i) :
				Index(i) {
		}
		;
	};

	UBArray<DATA, INDEX> & operator =(const UBArray<DATA, INDEX> &); //Assignment operator
	WCS_Pointer<Node> pHead;
	WCS_Pointer<Node> pTail;
	WCS_Pointer<Node> pCurrent;
public:
	enum Exceptions {
		ArrayEmpty, NoNextElement, NoPrevElement, InvalidIndex
	};
	UBArray<DATA, INDEX>() {
		size = 0;
		currentindex = -1;
	}
	UBArray(const UBArray<DATA, INDEX> &) {
		size = 0;
		currentindex = -1;
	}
	~UBArray<DATA, INDEX>() {
		if (!pHead)
			size = 0;
		else {
			pHead = (*pHead).pNext;
			while (pHead) {
				(*pHead).pPrev.SetToNull();
				pHead = (*pHead).pNext;
			}
			pHead.SetToNull();
			pTail.SetToNull();
			pCurrent.SetToNull(); //Just in case it remains, make sure it's destroyed
		}
	}
	DATA GetFirst() {
		try {
			if (size == 0)
				throw ArrayEmpty;
			else {
				currentindex = 0; //Will set index pointer back to the head when this method is called
				pCurrent = pHead;
				return (*pHead).Data;
			}
		} catch (Exceptions e) {
			switch (e) {
			case ArrayEmpty:
				cout << "There Are No Elements In The Array. Error Code ";
				return 0; //Without this the program does weird things and crashes
			}
		}
	}
	DATA GetLast() {
		try {
			if (size == 0)
				throw ArrayEmpty;
			else {
				pCurrent = pTail;
				currentindex = size - 1; //Set index pointer to last index
				return (*pTail).Data;
			}
		} catch (Exceptions e) {
			switch (e) {
			case ArrayEmpty:
				cout << "There Are No Elements In The Array. Error Code ";
				return 0; //Without this the program does weird things and crashes
			}
		}
	}
	DATA GetNext() //Will execute from starting point if GetFirst wasn't called yet
	{
		try {
			if (!pHead)
				throw ArrayEmpty;
			else {
				currentindex++;
				//cout << currentindex << endl; <- Just for checking everything is working properly
				if (currentindex > size - 1) {
					throw NoNextElement;
				} else if (currentindex == 0) {
					pCurrent = pHead;
					return (*pCurrent).Data;
				} else {
					pCurrent = (*pCurrent).pNext;
					return (*pCurrent).Data;
				}
			}
		} catch (Exceptions e) {
			switch (e) {
			case ArrayEmpty:
				cout << "There Are No Elements In The Array. Error Code ";
				return 0; //Without this the program does weird things and crashes
			case NoNextElement:
				cout
						<< "There Is Not Another Element In The Array. Error Code ";
				currentindex--;
				return 1; //Without this the program does weird things and crashes
			}
		}
	}
	DATA GetPrev() //Will cause an error if called after GetFirst is called
	{
		try {
			if (!pHead)
				throw ArrayEmpty;
			else {
				currentindex--;
				//cout << currentindex << endl; <- Just for checking everything is working properly
				if (currentindex < 0) {
					throw NoPrevElement;
				} else if (currentindex == 0) {
					pCurrent = pHead;
					return (*pCurrent).Data;
				} else {
					pCurrent = (*pCurrent).pPrev;
					return (*pCurrent).Data;
				}
			}
		} catch (Exceptions e) {
			switch (e) {
			case ArrayEmpty:
				cout << "There Are No Elements In The Array. Error Code ";
				return 0; //Without this the program does weird things and crashes
			case NoPrevElement:
				cout
						<< "There Is Not A Previous Element In The Array. Error Code ";
				currentindex++;
				return 2; //Without this the program does weird things and crashes
			}
		}
	}
	DATA Remove(const INDEX &i) {
		WCS_Pointer<Node> pTemp;
		WCS_Pointer<Node> pTemp2;
		WCS_Pointer<Node> pTemp3;
		try {
			if (!pHead)
				throw ArrayEmpty;
			else if (i > (*pTail).Index)
				throw InvalidIndex;
			else if (i < (*pHead).Index)
				throw InvalidIndex;
			else if (size == 1) {
				size--;
				(*pHead).pNext.SetToNull();
				pHead.SetToNull();
				(*pTail).pPrev.SetToNull();
				pTail.SetToNull();
			} else {
				size--;
				if (i == (*pHead).Index) {
					pTemp = pHead;
					pTemp2 = (*pHead).pNext;
					(*pTemp2).pPrev.SetToNull();
					pHead = pTemp2;
					pTemp.SetToNull();
				} else if (i == (*pTail).Index) {
					pTemp = pTail;
					pTemp2 = (*pTail).pPrev;
					(*pTemp2).pNext.SetToNull();
					pTail = pTemp2;
					pTemp.SetToNull();
				} else {
					for (pTemp = (*pHead).pNext; i > (*pTemp).Index; pTemp =
							(*pTemp).pNext)
						;
					if (i == (*pTemp).Index) {
						pTemp2 = pTemp;
						pTemp3 = pTemp;
						pTemp2 = (*pTemp).pNext;
						pTemp3 = (*pTemp).pPrev;
						pTemp.SetToNull();
						(*pTemp3).pNext = pTemp2;
						(*pTemp2).pPrev = pTemp3;
					}
				}
			}
		} catch (Exceptions e) {
			switch (e) {
			case ArrayEmpty:
				cout << "There Are No Elements In The Array. Error Code ";
				return 0; //Without this the program does weird things and crashes
			case InvalidIndex:
				cout << "No Such Element Exists. Error Code ";
				return 3; //Without this the program does weird things and crashes
			}
		}
	}
	int Size() {
		return size;
	}
	DATA & At(const INDEX &i) {
		return operator[](i);
	}
	const DATA & At(const INDEX &i) const {
	return const operator[] (i);
}
DATA & operator[](const INDEX &i) {
	WCS_Pointer<Node> pTemp;
	WCS_Pointer<Node> pTemp2;

	if (!pHead) {			// this processes if the list was empty
		pHead = WCS_Pointer<Node>(new Node(i));
		pTail = pHead;
		size++;
		return (*pHead).Data;
	} else if (i == (*pHead).Index)	// processes if the index sought was the first index
		return (*pHead).Data;
	else if (i < (*pHead).Index) {// processes if the index sought is in front of the first index
		pTemp = WCS_Pointer<Node>(new Node(i));
		(*pTemp).pNext = pHead;
		(*pHead).pPrev = pTemp;
		pHead = pTemp;
		size++;
		return (*pHead).Data;
	} else if (i == (*pTail).Index)
		return (*pTail).Data;
	else if (i > (*pTail).Index) {
		pTemp = WCS_Pointer<Node>(new Node(i));
		(*pTemp).pPrev = pTail;
		(*pTail).pNext = pTemp;
		pTail = pTemp;
		size++;
		return (*pTail).Data;
	} else {
		for (pTemp = (*pHead).pNext; i > (*pTemp).Index; pTemp = (*pTemp).pNext)
			;
		if (i == (*pTemp).Index)
			return (*pTemp).Data;
		else {
			pTemp2 = WCS_Pointer<Node>(new Node(i));
			(*pTemp2).pNext = pTemp;
			(*pTemp2).pPrev = (*pTemp).pPrev;
			(*pTemp).pPrev = pTemp2;
			(*(*pTemp2).pPrev).pNext = pTemp2;
			size++;
			return (*pTemp2).Data;
		}
	}
}
const DATA & operator[](const INDEX &i) const {
	WCS_Pointer<Node> pTemp;
	try {
		if (!pHead)
			throw ArrayEmpty;
		else if (i > (*pTail).Index)
			throw InvalidIndex;
		else if (i < (*pHead).Index)
			throw InvalidIndex;
		else if (i == (*pHead).Index)// processes if the index sought was the first index
			return (*pHead).Data;
		else {
			for (pTemp = (*pHead).pNext; i > (*pTemp).Index;
					pTemp = (*pTemp).pNext)
				;
			if (i == (*pTemp).Index)
				return (*pTemp).Data;
			else if (i < (*pTemp).Index)
				throw InvalidIndex;
		}
	} catch (Exceptions e) {
		switch (e) {
		case ArrayEmpty:
			cout << "There Are No Elements In The Array. Error Code ";
			return 0;	//Without this the program does weird things and crashes
		case InvalidIndex:
			cout << "No Such Element Exists. Error Code ";
			return 3;	//Without this the program does weird things and crashes
		}
	}
}
};
#endif
