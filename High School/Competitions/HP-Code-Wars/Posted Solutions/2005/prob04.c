// prob04.c
// HP Codewars 2005
// Roman Numerals
//

#include <stdio.h>

int main(int argc, char *argv[]) 
{
	int integer; 
	int x;
	int sum;
	do {
		printf("Enter an integer: ");
		scanf("%d",&integer);
		x = integer;
		while (integer > 0) {
			if (integer >= 100) {
				printf("C");
				integer -=100;
				continue;
			}		
			if (integer >= 90) {
				printf("XC");
				integer -=90;
				continue;
			}
			if (integer >= 50) {
				printf("L");
				integer -=50;
				continue;
			}
			if (integer >= 40) {
				printf("XL");
				integer -=40;
				continue;
			}
			if (integer >= 10) {
				printf("X");
				integer -=10;
				continue;
			}
			if (integer >= 9) {
				printf("IX");
				integer -=9;
				continue;
			}
			if (integer >= 5) {
				printf("V");
				integer -=5;
				continue;
			}
			if (integer >= 4) {
				printf("IV");
				integer -=4;
				continue;
			}
			if (integer >= 1) {
				printf("I");
				integer -=1;
				continue;
			}
		}
		printf("\n");
	} while (x != 0);
	return;
}
