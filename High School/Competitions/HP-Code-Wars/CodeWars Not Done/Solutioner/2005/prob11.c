// prob11.c
// HP Codewars 2005
// 

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define true	(1==1)
#define false	(1==0)

#define SwapCards(A,B)	{ \
                           char tmp[3];\
                           strcpy(tmp, A);\
                           strcpy(A, B);\
                           strcpy(B, tmp);\
                        }

#define NumHands 4

#define InputFile	"prob11.in"

char CardLevels[13][2] = { {'2', 0}, {'3', 1}, {'4', 2}, {'5', 3}, {'6', 4}, {'7', 5},
                           {'8', 6}, {'9', 7}, {'T', 8}, {'J', 9}, {'Q',10}, {'K',11}, {'A',12} };
	
typedef char Card[3];
typedef Card Hand[6];		// Store 6 cards per hand as 2 char strings (don't forget NULLs)
typedef char Rank[9];       // Rank of the Hand HCC54321
                            //                  ^^ ^
                            //                  || |
                            //                  ||  - Remaining Cards in order from high to low
                            //                  | --- Cards which determine the Poker Hand
                            //                   ---- PokerHand	9 - Straight Flush 
                            //                                  8 - Four of a Kind
                            //                                  7 - Full House
                            //                                  6 - Flush
                            //                                  5 - Straight
                            //                                  4 - Three of a Kind
                            //                                  3 - Two Pairs
                            //                                  2 - Pair
                            //                                  1 - High Card

void RankHand(Hand hand, Rank rank);
int CheckStraightFlush(Hand hand, Rank rank);
int CheckFourOfAKind(Hand hand, Rank rank);
int CheckFullHouse(Hand hand, Rank rank);
int CheckFlush(Hand hand, Rank rank);
int CheckStraight(Hand hand, Rank rank);
int CheckThreeOfAKind(Hand hand, Rank rank);
int CheckTwoPairs(Hand hand, Rank rank);
int CheckPair(Hand hand, Rank rank);
void CheckHighCard(Hand hand, Rank rank);
void WriteHand(Hand hand, Rank rank, int diff, char Name[]);

int main(int argc, char argv[])
{
	int rank;
	int card;
	int player;
	Hand hands[NumHands];
	Card CommunityCard;
	int HighPlayer = 0;
	int HighHand = 0;

	FILE *fp = fopen(InputFile, "r");					// Open file
	if (!fp) {
		printf("ERROR: could not open input file\n");
		return EXIT_FAILURE;
	}

	// Read Individual Hands
	for (player = 0; player < Numplayer; player++)
		for (card = 0; card < 2; card++)
			fscanf(fp, "%2s", hands[card][player]);
	// Read Community Cards
	for (card = 0; card < 4; card++) {
		fscanf(fp, "%2s", CommunityCard);
		for (player = 0; player < Numplayer; player++)
			strcpy(hands[card+2][player],CommunityCard);
	}
	
	
	RankHand(hands[0], ranks[0]);					// Rank
	RankHand(hands[1], ranks[1]);
		for (diff=0; (diff<9); diff++) {
			if ((diff>=3)&&((ranks[0][diff]==0)||(ranks[1][diff]==0)))
				break;
			if (ranks[0][diff] != ranks[1][diff])
				break;
		}
		WriteHand(hands[0], ranks[0], diff, Name1);		// Write
		WriteHand(hands[1], ranks[1], diff, Name2);
		if (ranks[0][diff] > ranks[1][diff])			// Who Won?
			printf("%s wins.\n", Name1);
		else if (ranks[0][diff] < ranks[1][diff])
			printf("%s wins.\n", Name2);
		else
			printf("This hand is a tie.\n");
	}
	fclose(fp);
	return EXIT_SUCCESS;
}

void RankHand(Hand hand, Rank rank)
{
	int x,y;

	for(x=0; x<9; x++)		// Clear the rank string
			rank[x] = '\0';
	for(x=0; x<5; x++)		// Convert Card ranks to actual values so we can sort them
		for(y=0; y<13; y++)
			if (CardLevels[y][0] == hand[x][0])
				hand[x][0] = CardLevels[y][1];
	for(x=0; x<5; x++)		// Sort Hand
		for(y=x+1; y<5; y++)
			if (hand[x][0] < hand[y][0])
				SwapCards(hand[x], hand[y])
	if (CheckStraightFlush(hand, rank))
		return;
	if (CheckFourOfAKind(hand, rank))
		return;
	if (CheckFullHouse(hand, rank))
		return;
	if (CheckFlush(hand, rank))
		return;
	if (CheckStraight(hand, rank))
		return;
	if (CheckThreeOfAKind(hand, rank))
		return;
	if (CheckTwoPairs(hand, rank))
		return;
	if (CheckPair(hand, rank))
		return;
	CheckHighCard(hand, rank);
	return;
}

int CheckStraightFlush(Hand hand, Rank rank)
{
	int x;
	for(x=1; x<5; x++) {
		if ((hand[x][1] != hand[0][1]) || 	// Is this card the same suit as the first card
			(hand[x][0]+x != hand[0][0]))	// are the cards sequential
				break;		// If not then stop checking the rest of the hand
	}
	if (x == 5)	// If we made it through the whole hand without a problem
	{
		rank[0] = 9;			// Hand is a Straight Flush
		rank[1] = hand[0][0];	// Get High Card
		return true;
	}
	return false;
}

int CheckFourOfAKind(Hand hand, Rank rank)
{
	if ((hand[0][0] == hand[1][0]) &&
		(hand[0][0] == hand[2][0]) &&
		(hand[0][0] == hand[3][0])) {
			rank[0] = 8;			// Hand is 4 of a Kind
			rank[1] = hand[0][0];	// We have 4 of this card
			rank[3] = hand[4][0];	// What is the other card
			return true;
	}
	if ((hand[1][0] == hand[2][0]) &&
		(hand[1][0] == hand[3][0]) &&
		(hand[1][0] == hand[4][0])) {
			rank[0] = 8;			// Hand is 4 of a Kind
			rank[1] = hand[1][0];	// We have 4 of this card
			rank[3] = hand[0][0];	// What is the other card
			return true;
	}
	return false;
}

int CheckFullHouse(Hand hand, Rank rank)
{
	if ((hand[0][0] == hand[1][0]) &&
		(hand[0][0] == hand[2][0]) &&
		(hand[3][0] == hand[4][0])) {
			rank[0] = 7;			// Hand is Full House
			rank[1] = hand[0][0];	// We have 3 of this card
			rank[2] = hand[3][0];	// We have 2 of this card
			return true;
	}
	if ((hand[0][0] == hand[1][0]) &&
		(hand[2][0] == hand[3][0]) &&
		(hand[2][0] == hand[4][0])) {
			rank[0] = 7;			// Hand is Full House
			rank[1] = hand[2][0];	// We have 3 of this card
			rank[2] = hand[0][0];	// We have 2 of this card
			return true;
	}
	return false;
}

int CheckFlush(Hand hand, Rank rank)
{
	int x;
	for(x=1; x<5; x++) {
		if (hand[x][1] != hand[0][1])	// Is this card the same suit as the first card
			break;		// If not then stop checking the rest of the hand
	}
	if (x == 5)	// If we made it through the whole hand without a problem
	{
		rank[0] = 6;			// Hand is a Flush
		rank[1] = hand[0][0];		// Get High Card
		for(x=1;x<5;x++)
			rank[3+x] = hand[x][0];	// Get Cards in hand
		return true;
	}
	return false;
}

int CheckStraight(Hand hand, Rank rank)
{
	int x;
	for(x=1; x<5; x++) {
		if (hand[x][0]+x != hand[0][0])			// Are the cards sequential
			break;		// If not then stop checking the rest of the hand
	}
	if (x == 5)	// If we made it through the whole hand without a problem
	{
		rank[0] = 5;			// Hand is a Straight
		rank[1] = hand[0][0];	// Get High Card
		return true;
	}
	return false;
}

int CheckThreeOfAKind(Hand hand, Rank rank)
{
	if ((hand[0][0] == hand[1][0]) &&
		(hand[0][0] == hand[2][0])) {
			rank[0] = 4;			// Hand is 3 of a Kind
			rank[1] = hand[0][0];	// We have 3 of this card
			rank[3] = hand[3][0];	// What are the other cards
			rank[4] = hand[4][0];
			return true;
	}
	if ((hand[1][0] == hand[2][0]) &&
		(hand[1][0] == hand[3][0])) {
			rank[0] = 4;			// Hand is 3 of a Kind
			rank[1] = hand[1][0];	// We have 3 of this card
			rank[3] = hand[0][0];	// What are the other cards
			rank[4] = hand[4][0];
			return true;
	}
	if ((hand[2][0] == hand[3][0]) &&
		(hand[2][0] == hand[4][0])) {
			rank[0] = 4;			// Hand is 3 of a Kind
			rank[1] = hand[2][0];	// We have 3 of this card
			rank[3] = hand[0][0];	// What are the other cards
			rank[4] = hand[1][0];
			return true;
	}
	return false;
}

int CheckTwoPairs(Hand hand, Rank rank)
{
	if ((hand[0][0] == hand[1][0]) &&
		(hand[2][0] == hand[3][0])) {
			rank[0] = 3;			// Hand is 2 Pair
			rank[1] = hand[0][0];	// First Pair
			rank[2] = hand[2][0];	// Second Pair
			rank[3] = hand[4][0];	// What is the other cards
			return true;
	}
	if ((hand[0][0] == hand[1][0]) &&
		(hand[3][0] == hand[4][0])) {
			rank[0] = 3;			// Hand is 2 Pair
			rank[1] = hand[0][0];	// First Pair
			rank[2] = hand[3][0];	// Second Pair
			rank[3] = hand[2][0];	// What is the other cards
			return true;
	}
	if ((hand[1][0] == hand[2][0]) &&
		(hand[3][0] == hand[4][0])) {
			rank[0] = 3;			// Hand is 2 Pair
			rank[1] = hand[1][0];	// First Pair
			rank[2] = hand[3][0];	// Second Pair
			rank[3] = hand[0][0];	// What is the other cards
			return true;
	}
	return false;
}

int CheckPair(Hand hand, Rank rank)
{
	if (hand[0][0] == hand[1][0]) {
		rank[0] = 2;			// Hand is a Pair
		rank[1] = hand[0][0];	// We have a Pair of this card
		rank[3] = hand[2][0];	// What is the other cards
		rank[4] = hand[3][0];
		rank[5] = hand[4][0];
		return true;
	}
	if (hand[1][0] == hand[2][0]) {
		rank[0] = 2;			// Hand is a Pair
		rank[1] = hand[1][0];	// We have a Pair of this card
		rank[3] = hand[0][0];	// What is the other cards
		rank[4] = hand[3][0];
		rank[5] = hand[4][0];
		return true;
	}
	if (hand[2][0] == hand[3][0]) {
		rank[0] = 2;			// Hand is a Pair
		rank[1] = hand[2][0];	// We have a Pair of this card
		rank[3] = hand[0][0];	// What is the other cards
		rank[4] = hand[1][0];
		rank[5] = hand[4][0];
		return true;
	}
	if (hand[3][0] == hand[4][0]) {
		rank[0] = 2;			// Hand is a Pair
		rank[1] = hand[3][0];	// We have a Pair of this card
		rank[3] = hand[0][0];	// What is the other cards
		rank[4] = hand[1][0];
		rank[5] = hand[2][0];
		return true;
	}
	return false;
}
void CheckHighCard(Hand hand, Rank rank)
{
	rank[0] = 1;			// Hand is a HighCard
	rank[1] = hand[0][0];	// What cards are in the hand
	rank[3] = hand[1][0];
	rank[4] = hand[2][0];
	rank[5] = hand[3][0];
	rank[6] = hand[4][0];
	return;
}

void WriteHand(Hand hand, Rank rank, int diff, char Name[])
{
	int card;
	printf("%s: " , Name);
	switch(rank[0]) {
		case 9:  // Straight Flush
			printf("Straight Flush {%c High}",CardLevels[rank[1]][0]);
			break;
		case 8:  // Four of a Kind
			printf("Four of a Kind {%cs}",CardLevels[rank[1]][0]);
			break;
		case 7:  // Full House
			printf("Full House {%cs full of %cs}", CardLevels[rank[1]][0], CardLevels[rank[2]][0]);
			break;
		case 6:  // Flush
			printf("Flush {%c High}", CardLevels[rank[1]][0]);
			break;
		case 5:  // Straight
			printf("Straight {%c High}", CardLevels[rank[1]][0]);
			break;
		case 4:  // Three of a Kind
			printf("Three of a Kind {%cs}", CardLevels[rank[1]][0]);
			break;
		case 3:  // Two Pairs
			printf("Two Pair {%cs and %cs}", CardLevels[rank[1]][0], CardLevels[rank[2]][0]);
			break;
		case 2:  // Pair
			printf("Pair {%cs}", CardLevels[rank[1]][0]);
			break;
		case 1:  // High Card
			printf("High Card {%c}", CardLevels[rank[1]][0]);
			break;
	}
	if (diff >= 3) {
		printf("{");
		for (card = 3; card <= diff; card ++) {
			printf("%c", CardLevels[rank[card]][0]);
			if (card < diff)
				printf("-");
		}
		printf("}");
	}
	printf("\n");
}

