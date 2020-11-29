#include<string>
#include<iostream>
#include<fstream>
#include<vector>

using namespace std;

int compare(const void * a, const void * b) {
	return (*(int*)a - *(int*)b);
}


int main() {
	// int n = 281939942;
	//	int k = 3;
//	string k = "3";
	fstream s;
	s.open("C:\\Users\\maste\\source\\repos\\INS'Hack\\INS'Hack\\file.txt");
	vector<int> ar;
	int arr[579354];
	int N = 0; // Size of ARR
	int K = 0; // Number to delete
	int count = 0; // Counter
	int x = 0;
	s >> N;
	s >> K;
	s >> x;
	cout << "HERE" << endl;
	while (s >> x) {
		arr[count] = x;
		count++;
	}
	cout << "Made it here" << endl;
	int dup = 0; // Duplicate number of numbers
	qsort(arr, N, sizeof(int), compare);
	for (int i = 0; i < N; i++) {
		int tmp = ar.back();
		if (tmp == arr[i]) { // They are the same
			dup++;
		}
		else {
			ar.push_back(arr[i]);
		}
	}
	cout << "The size of array is " << ar.size() << endl;
	cout << "Number of duplicated " << dup << endl;
	cout << "N IS " << N << endl;
	cout << "K IS " << K << endl;
	//	for (int i = 0; i < n; i++) {
		//	string s =to_string( i) ;
			//if (s.find(k) != string::npos) {
			//	count++;
			//}
			//if (n == 10193994) {
			//	cout << "Made it to here 1" << endl;
		//	}
		//}
	//	cout << count << endl;

	system("PAUSE");
	return 0;
}