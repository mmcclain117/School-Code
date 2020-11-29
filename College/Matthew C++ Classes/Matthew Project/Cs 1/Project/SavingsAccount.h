#ifndef SAVINGSACCOUNT_H
#define SAVINGSACCOUNT_H
#include "BankAccount.h"
#include <iostream>
using namespace std;

class SavingsAccount : public BankAccount
{
private:
	bool status;
	double saveservcharge;
public:
	SavingsAccount(double bal, double rate) : BankAccount(bal, rate)
	{
		if (bal >= 25)
			status = 1;
		else
			status = 0;
		saveservcharge = 0;
	}
	void withdraw(double amount)
	{
		if (status == 0)
		{
			cout << "This Account Is Inactive. No Withdrawls Can Be Made Until The Balance Is Raised Above $25. Deposit Some Money." << endl;
		}
		else
			BankAccount::withdraw(amount);
		if (balance < 25)
			status = 0;
	}
	void deposit(double amount)
	{
		if (status == 0)
		{
			if ((amount + balance) > 25)
				status = 1;
		}
		BankAccount::deposit(amount);
	}
	void monthlyProc()
	{
		if (numwithdrawls > 4)
		{
			servicecharge = (double)numwithdrawls - 4.0;
			saveservcharge = servicecharge;
		}
		BankAccount::monthlyProc();
		if (balance < 25)
			status = 0;
	}
	double getServiceCharge()
	{
		return saveservcharge;
	}
};
#endif