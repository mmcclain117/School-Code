#include <iostream>
#include <fstream>
#include <cstdlib>
#include <cstring>
#include <cctype>
using namespace std;

#include "trie.h"
/* Turns the string into uppercase */
char* strUp(char *s) {
	char *ss;
	for (ss = s; *s = toupper(*s); s++);
	return ss;
}

/* Same as Strcpy Command */
char *strCp(char *dest, const char *src) {
	unsigned i;
	for (i = 0; src[i] != '\0'; ++i)
		dest[i] = src[i];

	//Ensure trailing null byte is copied
	dest[i] = '\0';

	return dest;
}

int main(int argc, char* argv[]) {
	char fileName[25];
	char s[80];
	char ch;
	int i;
	int lineNum = 1;
	ifstream dictionary("dictionary");
	if (dictionary.fail()) {
		cerr << "Cannot open 'dictionary'\n";
		exit(-1);
	}
	dictionary >> s;
	Trie trie(strUp(s));   // initialize root;
	while (dictionary >> s) { // initialize trie;
		trie.insert(strUp(s));
	}
		trie.printTrie();
	if (argc != 2) {
		cout << "Enter a file name: ";
		cin >> fileName;
	}
	else {
		strCp(fileName, argv[1]);
	}
	ifstream textFile(fileName);
	if (textFile.fail()) {
		cout << "Cannot open " << fileName << endl;
		exit(-1);
	}
	cout << "Misspelled words:\n";
	textFile.get(ch);
	while (!textFile.eof()) {
		while (true)
			if (!textFile.eof() && !isalpha(ch)) { // skip non-letters
				if (ch == '\n')
					lineNum++;
				textFile.get(ch);
			}
			else break;
		if (textFile.eof()) // spaces at the end of textFile;
			break;
		for (i = 0; !textFile.eof() && isalpha(ch); i++) {
			s[i] = toupper(ch);
			textFile.get(ch);
		}
		s[i] = '\0';
		if (!trie.wordFound(s))
			cout << s << " on line " << lineNum << endl;
	}
	dictionary.close();
	textFile.close();
	system("PAUSE");
	return 0;
}
