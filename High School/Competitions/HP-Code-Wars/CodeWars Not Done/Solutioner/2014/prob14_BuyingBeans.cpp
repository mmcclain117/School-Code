

//#define DEBUG 1 // For debug print statements

#include <string>
#include <iostream>

using namespace std;
	
int weights[4];
int weightCount;

int findMaxGrams(void)
{
	int maxSearchValue;
	int i[4];  // Array of indeces
	int newGuess[4];  // Array of smaller values as weights are subtracted
	int currentGuess;
	int thisGuessIsDivisible;

	// For 2 weights, the maximum number of grams can be generated with
	//    the formula below.  For more than 2 weights, the max will be
	//    equal or less.

	maxSearchValue = (weights[0]-1) * (weights[1]-1) - 1;
	if (weightCount == 2)
		return maxSearchValue;

	for (currentGuess = maxSearchValue; currentGuess>0; currentGuess--)
	{
		thisGuessIsDivisible = 0;
		// Nested loops each subtract multiples of the weights
		for(i[0]=0; !thisGuessIsDivisible && ( (newGuess[0]=currentGuess-i[0]*weights[0])>0); i[0]++)
		{
			for(i[1]=0; !thisGuessIsDivisible && ( (newGuess[1]=newGuess[0]-i[1]*weights[1])>0); i[1]++)
			{
				for(i[2]=0; !thisGuessIsDivisible && ( (newGuess[2]=newGuess[1]-i[2]*weights[2])>0); i[2]++)
				{
					for(i[3]=0; !thisGuessIsDivisible && ( (newGuess[3]=newGuess[2]-i[3]*weights[3])>0); i[3]++)
					{
						if ( (newGuess[3] % weights[0] == 0) ||
							 (newGuess[3] % weights[1] == 0) ||
							 (newGuess[3] % weights[2] == 0) ||
							 (newGuess[3] % weights[3] == 0) )
							 thisGuessIsDivisible = 1;
					} 
				}
			}
		}
		if (!thisGuessIsDivisible)  // All possible combinations were checked and still not divisible
			return currentGuess;
	}
	return 0;
}

int main( int argc, char* argv[] )
{
	int i, maxGrams;

	// Prompt
	cout << endl << "Input the number of weights, then the individual values in grams. 0 to end." << endl;
	cin >> weightCount;
	while (weightCount>=2 && weightCount<=4)
	{
		memset(weights, 10000, sizeof(weights)); // Initialize to LARGE values to shorten search

		for (i=0; i<weightCount; i++)
			cin >> weights[i];

		maxGrams = findMaxGrams();

		cout << maxGrams << endl;

//		cout << endl << "Input the number of weights, then the individual values in grams. 0 to end." << endl;
		cin >> weightCount;
//		weightCount = 0;  // to end the loop
	}

	cout << endl;
}