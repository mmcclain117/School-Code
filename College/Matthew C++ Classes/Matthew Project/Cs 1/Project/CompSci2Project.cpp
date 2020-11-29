//@Author: Matthew Wethington
#include <iostream>
#include "BankAccount.h"
#include "SavingsAccount.h"
#include "CheckingAccount.h"
#include <fstream>
#include <string>
#include <iomanip>
using namespace std;

void main() {
	double bal;
	double rate;
	double amt;
	int num;
	ofstream write;
	ifstream read;
	write.open("Log.txt");
	write << "Statistics For This Month:" << endl;

	cout << "Create A Savings Account:" << endl;
	cout << "Balance (In $):" << endl;
	cin >> bal;
	cout << "Interest Rate (Annual Percentage):" << endl;
	cin >> rate;
	SavingsAccount account1(bal, rate);
	write << "For Savings Account:" << endl;
	write << "Initial Balance: $";
	write << bal << endl;

	cout << "Number Of Deposits To Be Made To The Savings Account:" << endl;
	cin >> num;
	write << "Deposits Made: ";
	write << num << endl;

	cout << "Amount For Those Deposits (In $):" << endl;
	cin >> amt;
	for (int i = 0; i < num; i++) {
		account1.deposit(amt);
	}
	cout << "Number Of Withdrawls To Be Made To The Savings Account:" << endl;
	cin >> num;
	write << "Withdrawls Made: ";
	write << num << endl;

	cout << "Amount For Those Withdrawls (In $):" << endl;
	cin >> amt;
	for (int i = 0; i < num; i++) {
		account1.withdraw(amt);
	}
	account1.monthlyProc();
	write << "Service Charges For This Month: $";
	write << account1.getServiceCharge() << endl;
	write << "Ending Balance: $";
	write << account1.getBalance() << endl;

	cout << "Now Create A Checking Account:" << endl;
	cout << "Balance (In $):" << endl;
	cin >> bal;
	cout << "Interest Rate (Annual Percentage):" << endl;
	cin >> rate;
	CheckingAccount account2(bal, rate);
	write << "For Checking Account:" << endl;
	write << "Initial Balance: $";
	write << bal << endl;

	cout << "Number Of Deposits To Be Made To The Checking Account:" << endl;
	cin >> num;
	write << "Deposits Made: ";
	write << num << endl;

	cout << "Amount For Those Deposits (In $):" << endl;
	cin >> amt;
	for (int i = 0; i < num; i++) {
		account2.deposit(amt);
	}
	cout << "Number Of Withdrawls To Be Made To The Checking Account:" << endl;
	cin >> num;
	write << "Withdrawls Made: ";
	write << num << endl;

	cout << "Amount For Those Withdrawls (In $):" << endl;
	cin >> amt;
	for (int i = 0; i < num; i++) {
		account2.withdraw(amt);
	}
	account2.monthlyProc();
	write << "Service Charges For This Month: $";
	write << account2.getServiceCharge() << endl;
	write << "Ending Balance: $";
	write << account2.getBalance() << endl;

	write.close();
	read.open("Log.txt");
	cout << endl;
	while (!read.eof()) {
		string display;
		getline(read, display);
		cout << display << endl;
	}
	read.close();
}
