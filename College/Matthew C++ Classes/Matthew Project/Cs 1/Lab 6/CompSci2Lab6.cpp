//@Author: Matthew Wethington
#include <iostream>
#include <fstream>
#include "EncryptionDictionary.h"
using namespace std;

void main()
{
	string response;
	cout << "Enter A File To Encrypt: " << endl;
	getline(cin, response);
	EncryptionDictionary dictionary;
	dictionary.Encrypt(response);
	cout << "Result Of Encryption Can Be Viewed In EncryptedResult.txt Which Has Been Created In The Same Folder The Program Was Run From." << endl;
	dictionary.Decrypt("EncryptedResult.txt");
	cout << "Result Of Decryption Of EncryptedResult.txt Can Be Viewed In DecryptedResult.txt Which Has Been Created In The Same Folder The Program Was Run From." << endl;
}