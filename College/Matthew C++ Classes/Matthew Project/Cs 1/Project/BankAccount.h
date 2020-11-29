#ifndef BANKACCOUNT_H
#define BANKACCOUNT_H

class BankAccount {
protected:
	double balance;
	int numdeposits;
	int numwithdrawls;
	double irate;
	double servicecharge;
public:
	BankAccount(double bal, double rate) {
		balance = bal;
		irate = rate / 100;
		numdeposits = 0;
		numwithdrawls = 0;
		servicecharge = 0;
	}
	virtual void deposit(double amount) {
		balance += amount;
		++numdeposits;
	}
	virtual void withdraw(double amount) {
		balance -= amount;
		++numwithdrawls;
	}
	virtual void calcInt() {
		double mirate(irate / 12);
		double minterest(mirate * balance);
		balance += minterest;
	}
	virtual void monthlyProc() {
		balance -= servicecharge;
		calcInt();
		numwithdrawls = 0;
		numdeposits = 0;
		servicecharge = 0;
	}
	double getBalance() {
		return balance;
	}
};
#endif
