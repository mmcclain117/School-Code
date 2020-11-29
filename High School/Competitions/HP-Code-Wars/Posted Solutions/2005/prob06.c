// prob06.c
// HP Codewars 2005
// L-Systems Part1
//

#include <stdio.h>
#include <string.h>

#define MaxSubStrs	3
#define MaxStrLen	102400

int main(int argc, char *argv[])
{
	FILE *fp;
	char Input[MaxStrLen] = {0};
	int substrs = 0;	// Looping variable for substitution strings
	int n = 0;			// Number of substitution iterations
	int passes = 0;
	int NumStrs = 0;	// Number of substitution strings
	char *src = NULL;	// Source Pointer
	char *dest = NULL;	// Destination Pointer
	char *tmp = NULL;	// Temp Pointer for trading
	char Ans_Arrays[2][MaxStrLen] = {0};
	char Characters[MaxSubStrs] = {0};
	char Strings[MaxSubStrs][MaxStrLen] = {0};
	char *destwlkr;
	char *srcwlkr;

	// Setup pointers
	srcwlkr = src = Ans_Arrays[0];
	destwlkr = dest = Ans_Arrays[1];

	// Read input
	fp = fopen(argv[1],"r");
	while (!feof(fp) && (NumStrs < MaxSubStrs)) {
		if (fgets(Input, MaxStrLen, fp) == NULL)		// read line
			continue;
		Input[strlen(Input)-2] = '\0';					// remove newline
		switch (Input[0]) {								// determine the input
			case 'n':	n = atoi(&Input[2]);			// n=??
						break;
			case 'w':	strcpy(src, &Input[2]);			// w=??
						break;
			default:	Characters[NumStrs] = Input[0];	// Substitution string
						strcpy(Strings[NumStrs], &Input[2]);
						NumStrs ++;
						break;
		}
	}
	printf("Number of passes: n=%d\n", n);
	printf("Initial String: w = %s\n", src);
	printf("Substitution Strings:\n");
	for (substrs =0; substrs < NumStrs; substrs++)
		printf("                       %c = %s\n",Characters[substrs], Strings[substrs]);
	printf("\n");

	// Do Substitutions
	for (passes = 0; passes < n; passes++) {		// n passes
		printf("Pass %d = %s\n", passes, srcwlkr);
		while (*srcwlkr != '\0') {	// walk source string until terminator
			// test against substitution strings
			for (substrs=0; substrs < NumStrs; substrs++) {
				if (*srcwlkr == Characters[substrs]) {
					// if character matches then replace it with
					// substitution string
					strcpy(destwlkr,Strings[substrs]);
					// move pointer in destination to end of string
					destwlkr += strlen(Strings[substrs]);
					*destwlkr = '\0';		// terminate destination string
					substrs = NumStrs+1;
				}
			}
			// if no character matches were found, then
			if (substrs == NumStrs) {
				*destwlkr = *srcwlkr;		// copy over non-substituted char
				*(destwlkr +1 ) = '\0';		// terminate destination string
				destwlkr++;
			}	
			srcwlkr++;						// move to next character
		}
		// swap source and destination for next pass
		tmp = src;
		srcwlkr = src = dest;
		destwlkr = dest = tmp;
	}
	printf("\n");
	printf("Results = %s\n",src);
}
