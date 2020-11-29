#ifndef CHECKINGACCOUNT_H
#define CHECKINGACCOUNT_H
#include "BankAccount.h"

class CheckingAccount : public BankAccount
{
private:
	double checkingservcharge;
public:
	CheckingAccount(double bal, double rate) : BankAccount(bal, rate)
	{

	}
	void withdraw(double amount)
	{
		if (balance - amount < 0)
			servicecharge += 15;
		else
		BankAccount::withdraw(amount);
	}
	void monthlyProc()
	{
		servicecharge = 5 + ((double)numwithdrawls * .1);
		checkingservcharge = servicecharge;
		BankAccount::monthlyProc();
	}
	double getServiceCharge()
	{
		return checkingservcharge;
	}
};
#endif