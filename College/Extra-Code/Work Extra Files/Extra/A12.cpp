#include <iostream>
#include <fstream>
#include<string>
using namespace std;

int countChars(const char* s) {
	int len = 0;
	int ind = 0;
	while (s[ind] != '\0') {
		len++;
		ind++;
	}
	return len;
}

void reverseString(const char* s) {
	int len = 0;
	int ind = 0;
	while (s[ind] != '\0') {
		len++;
		ind++;
	}
	for (int i = len - 1; i >= 0; i--) {
		cout << s[i];
	}
	cout << endl;
}
int countWords(const char* s) {
	int cnt = 0;
	int ind = 0;
	while (s[ind] != '\0') {
		if (s[ind] == ' ') cnt++;
		ind++;
	}
	return cnt + 1;
}
int getSum(const char* s) {
	int ind = 0;
	int sum = 0;
	while (s[ind] != '\0') {
		sum += s[ind] - '0';
		ind++;
	}
	return sum;
}

int main() {
	// Main # 1 Code
	string s;
	cin >> s;
	//read a line
	getline(cin, s);
	//output the length but convert to c-string first
	cout << "Length: " << countChars(s.c_str()) << endl;

	// Main # 2 code
	string s;
	//read a line
	getline(cin, s);
	cout << "Input: " << s << endl;
	//convert to c-string
	//and call the function
	cout << "Output: ";
	reverseString(s.c_str());

	// Main # 3 code
	string s;
	//read a line
	getline(cin, s);
	cout << "Input: " << s << endl;
	//convert to c-string
	//and call the function
	cout << "Number of words: " << countWords(s.c_str()) << endl;

	// Main # 4 code
	string s;
	//read a line
	getline(cin, s);
	cout << "Input: " << s << endl;
	//convert to c-string
	//and call the function
	cout << "Sum: " << getSum(s.c_str()) << endl;
	return 0;
}
