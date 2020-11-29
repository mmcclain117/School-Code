/*
 * Author: Jacob Ward
 * SearchableVector
 * SortableVector
 * Inhertiance Modification
 * Specialized Templates
 */

#include <iostream>
#include <vector>
using namespace std;

template<class T>
class SimpleVector {
private:
	T * aptr; // Point to array
	int arraySize; // Array Size
	void memError();
	void subError();

public:
	// Default constructor
	SimpleVector() {
		aptr = 0;
		arraySize = 0;
	}
	SimpleVector(int);
	SimpleVector(const SimpleVector &);
	~SimpleVector();
	int size() const {
		return arraySize;
	}
	T getElementAt(int position);
	T &operator[](const int &);

};

template<class T>
SimpleVector<T>::SimpleVector(int s) {
	arraySize = s;
	// Allocate memory for the array.
//	try {
		aptr = new T[s];
//	} catch (bad_alloc e) {
//		memError();
//	}
	// Initialize the array.
	for (int count = 0; count < arraySize; count++) {
		*(aptr + count) = 0;
	}
}

/* Copy Constructor from SimpleVector Class */
template<class T>
SimpleVector<T>::SimpleVector(const SimpleVector &obj) {
	// Copy the array size.
	arraySize = obj.arraySize;
	// Allocate memory for the array.
	aptr = new T[arraySize];
	if (aptr == 0)
		memError();
	// Copy the elements of obj's array.
	for (int count = 0; count < arraySize; count++) {
		*(aptr + count) = *(obj.aptr + count);
	}
}
// Destructor for SimpleVector
template<class T>
SimpleVector<T>::~SimpleVector() {
	if (arraySize > 0) {
		delete[] aptr;
	}
}

template<class T>
void SimpleVector<T>::memError() {
	cout << "Error: Can't allocate memory.\n";
	exit(EXIT_FAILURE);
}

template<class T>
void SimpleVector<T>::subError() {
	cout << "Error: Out of range.\n";
	exit(EXIT_FAILURE);
}

template<class T>
T SimpleVector<T>::getElementAt(int sub) {
	if (sub < 0 || sub >= arraySize) {
		subError();
	}
	return aptr[sub];
}

template<class T>
T &SimpleVector<T>::operator[](const int &sub) {
	if (sub < 0 || sub >= arraySize) {
		subError();
	}
	return aptr[sub];
}

/* Searchable Vector */
template<class T>
class SearchableVector: public SimpleVector<T> {
public:
	SearchableVector() :
			SimpleVector<T>() {
	}
	SearchableVector(int size) :
			SimpleVector<T>(size) {
	}
	SearchableVector(const SearchableVector &);
	int findItem(const T);

//	void sort();
};

/* Copy Constructor */
template<class T>
SearchableVector<T>::SearchableVector(const SearchableVector &obj) :
		SimpleVector<T>(obj.size()) {
	for (int count = 0; count < this->size(); count++) {
		this->operator[](count) = obj[count];
	}
}

/* Linear Search */
/*
 template <class T>
 int SearchableVector<T>::findItem(const T item) {
 for (int count = 0; count <= this->size(); count++) {
 if (this->getElementAt(count) == item) {
 return count;
 }
 }
 return -1;
 }
 */
/* Binary Search */

template<class T>
int SearchableVector<T>::findItem(const T item) {
	int first = 0;
	int last = this->size() - 1;
	int middle;
	int index = -1;
	bool found = false;
	while (!found && first <= last) {
		middle = (first + last) / 2;
//		if (this->getElementAt(middle) == value) {
		if (this->getElementAt(middle) == item) { // If found the item
			found = true;
			index = middle;
		}
//		}
		else if (this->getElementAt(middle) > item) { // If value is in lower half
			last = middle - 1;
		} else { // If value is in upper half
			first = middle + 1;
		}
	}
	return index;
}

/*
 template <class T>
 void SearchableVector<T>::sort() {
 int minIndex, minValue;
 for (int startIndex = 0; startIndex < (this->arraySize - 1); startIndex++) {
 minIndex = startIndex;
 minValue = this->aptr[startIndex];
 for (int curIndex = startIndex + 1; curIndex < size; curIndex++) { // Internal Iterator
 if (this->aptr[curIndex] < minValue) { // If smaller value
 minValue = this->aptr[curIndex];
 minIndex = curIndex;
 }
 }
 this->aptr[minIndex] = this->aptr[startIndex];
 this->aptr[startIndex] = minValue;
 }
 }
 */

/* Binary Search */
int BinarySearch(int array[], int size, int value) {
	int first = 0;
	int last = size - 1;
	int middle;
	int index = -1;
	bool found = false;
	while (!found && first <= last) {
		middle = (first + last) / 2;
		if (array[middle] == value) {
			found = true;
			index = middle;
		} else if (array[middle] > value) { // If value is in lower half
			last = middle - 1;
		} else { // If value is in upper half
			first = middle + 1;
		}
	}
	return index;
}

/* Sorts as selecting lowest one and switching. Runtime: O(n^2) */
void SelectionSort(int array[], int size) {
	int minIndex, minValue;
	for (int startIndex = 0; startIndex < (size - 1); startIndex++) {
		minIndex = startIndex;
		minValue = array[startIndex];
		for (int curIndex = startIndex + 1; curIndex < size; curIndex++) { // Internal Iterator
			if (array[curIndex] < minValue) { // If smaller value
				minValue = array[curIndex];
				minIndex = curIndex;
			}
		}
		array[minIndex] = array[startIndex];
		array[startIndex] = minValue;
	}
}

int vec() {
	vector<int> v;
	SimpleVector<int> s(10);
	SearchableVector<int> r(10);
	for (int i = 9; i > 0; i--) {
		s[i] = i;
		r[i] = i;
	}
	cout << r.findItem(4) << endl;
	for (int i = 0; i < 10; i++) {
		cout << r[i] << endl;
	}

	system("pause");
	return 0;
}
