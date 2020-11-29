// prob05.c
// HP Codewars 2005
// Text messaging
//

#include <string.h>
#include <stdio.h>

void Read(FILE *fp, int *Key, int *Times)
{
	int NextKey;
	*Key = getc(fp);	// read the next key
	*Times = 0;			// initialize the counter for 
						// how many times it was pressed
	if (*Key == EOF)
		return;
	do {
		*Times += 1;	// Start counting
		NextKey = getc(fp);	// get next key
	} while (*Key == NextKey);	// did we change keys?
	if (NextKey != ' ')	// do we need the next key?
		ungetc(NextKey, fp);	// then put it back for later
	return;
}

int main (int argc, char *argv[])
{
	int Key;
	int Times;
	char *ArrayPtr;
	int ArrayLength;
	// What are our key sequences?
	char keys[12][5] = {"@.?1", "ABC2", "DEF3", "GHI4", "JKL5", "MNO6", "PQRS7", "TUV8", "WXYZ9","","0"," "};
	FILE *fp;
	
	fp = fopen(argv[1], "r");	// Open the file
	while (!feof(fp)) {		// Until the file ends, keep reading and processing
		Read (fp, &Key, &Times);	// Read a Key sequence
		switch (Key) {		// process the key sequence
			case '1':		// basic numbers are easy
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':	ArrayPtr = keys[(Key - '1')];	// which string?
						ArrayLength = strlen(ArrayPtr);	// how long is it?
						if (Times > ArrayLength)
							Times = Times % ArrayLength;	// Remove wrap-arounds
						printf("%c",ArrayPtr[Times-1]);	// print the character
						break;
			case '*':	printf("\n");	// Send key was pressed
						break;
			case '0':	printf("0");	// Zero Key
						break;
			case '#':	printf(" ");	// Space key
						break;
			case ' ':	//ignore
			default :	//ignore
						break;
		}
	}
	fclose(fp);
	return;
}
