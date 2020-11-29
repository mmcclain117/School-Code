#include<iostream>

using namespace std;
int main() {
	bool a[65000];
	/* Making it all prime */
	for (int i = 0; i < 65000; i++) {
		a[i] = true;
		cout << i << endl;
	}
	/* Removing the next ones */
	for (int i = 2; i < 65000; i++) {
		int con = i + i;
			while (con < 65000) {
				a[con] = false;
				con += i;
		}
		cout << i << endl;
	}
	int size = 0;
	cout << "The prime numbers are: ";
	for (int i = 0; i < 65000; i++) {
		if (a[i]) {
			size++;
			cout << i << " ";
		}
	}
	cout << endl;
	cout << "Making " << size << " Number of primes" << endl;
	__asm {

	}

	system("PAUSE");
	return 0;
}