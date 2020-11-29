// Program Project 2//
#include <iostream>
#include <iomanip>
#include <string>
#include <cstring> 
using namespace std;

void GetInput(int& status, int& spouse, int& spouseBlind, int& blind, int& old, int& spouseOld);
void standardDeductionChart(int& status, int& spouse, int& spouseBlind, int& blind, int& old, int& spouseOld, double& deduction);

void CalculatingTax();
void displayFields();
void DisplayTaxReturn();

int main()
{

	double wages;
	double ordinaryDividents;
	double taxableAmount1;
	double totalIncome;
	int age;
	double adjustments;
	int blindness;
	int filing;
	int SpouseStatus;
	int spouseBlindness;
	int spouseAge;
	double adjustGross;
	double standardDeduction;
	double taxableIncome;
	double taxableInterest;
	double qualifedDividents;
	double capitalGain;

	string status;

	GetInput(filing, SpouseStatus, spouseBlindness, blindness, age, spouseAge);
	standardDeductionChart(filing, SpouseStatus, spouseBlindness, blindness, age, spouseAge, standardDeduction);

	return 0;
}

void GetInput(int& status, int& spouse, int& spouseBlind, int& blind, int& old, int& spouseOld)
{
	cout << "What is your status? Single or Married? Enter 1 for Single or 2 Married " << endl;
	status = 1;
	//	cin >> status;
	cout << "Are you over 65?: Enter 3 Yes or 4 No :" << endl;
	old = 3;
	//	cin >> old;
	cout << "Are You blind? Enter 5 Yes or 6 No" << endl;
	blind = 5;
	//	cin >> blind;
	cout << "Do you have a spouse? Enter 7 Yes or 8 No: " << endl;
	spouse = 8;
	//	cin >> spouse;

	if (spouse != 8)
	{
		cout << "is your spouse over 65? Enter 9 Yes or 10 No: " << "is your spouse blind? Enter 11 Yes or 12 No: " << endl;
		cin >> spouseOld >> spouseBlind;
	}
	else {
		cout << "You are not married " << endl;
	}
}

void standardDeductionChart(int& status, int& spouse, int& spouseBlind, int& blind, int& old, int& spouseOld, double& deduction) {
	if (status == 1) {
		deduction = 12000;

	}
	else if (status == 1 && old == 3 || blind == 5)
	{
		deduction = 12000 + 1600;
	}
	else if (status == 1 && old == 3 && blind == 5)
	{
		deduction = 12000 + 1600 + 1600;
	}
	else if (status == 2)
	{
		deduction = 24000;
	}
	else if (status == 2 && old == 3 && spouseOld == 9)
	{
		deduction = 24000 + 2600;
	}
	else if (status == 2 && old == 3 && spouseOld == 9 && spouseBlind == 11)
	{
		deduction = 24000 + 1300 + 1300;
	}
	else if (status == 2 && old == 3 && blind == 5 && spouseOld == 9 && spouseBlind == 11)
	{
		deduction = 24000 + 2600 + 2600;
	}
	else
	{
		cout << "You have Enterd an Invaild Option!" << endl;
	}

	cout << "Deduction = " << deduction << endl;

}