// prob10.c
// HP Codewars 2005
// Pacman
//

#include <stdio.h>

// Boolean
#define TRUE	(1==1)
#define FALSE	(1==0)

// Controls
#define UP		'U'
#define DOWN 	'D'
#define LEFT	'L'
#define RIGHT	'R'

// Characters on the Grid
#define PACMAN		'P'
#define GHOST		'@'
#define WALL		'#'
#define PORTAL_L	'['
#define PORTAL_R	']'
#define CRUMB		'.'
#define TARGET		'*'
#define CHERRIES	'%'
#define WATERMELON	'O'
#define SPACE		' '
#define CARRIAGE_RETURN		0xD
#define NEWLINE				0xA

#define Grid_File		"grid.in"
#define Movements_File	"prob10.in"
#define Grid_Size_X		20
#define Grid_Size_Y		20

void DEBUG_PrintScreen(char Screen[Grid_Size_Y][Grid_Size_X+1], int Curr_Score)
{
	int Y,X;
	for (Y=0; Y<Grid_Size_Y; Y++) {
		printf("\n");
		for (X=0; X<Grid_Size_X; X++) {
			printf("%c",Screen[Y][X]);
		}
	}
	printf("\n");
	printf("     Score %03d      \n",Curr_Score);
}

int main(int argc, char *argv[]) 
{
	char Screen[Grid_Size_Y][Grid_Size_X+1] = {0};
	int Curr_Score = 0;
	int Curr_X = 0;
	int Curr_Y = 0;
	int Move_X = 0;
	int Move_Y = 0;
	char Curr_Move = 0;
	char GameOver = FALSE;
	FILE *fp;
	int X, Y;
	
	// Read Grid
	fp = fopen(Grid_File,"r");
	if (!fp)
		exit(1);
	for (Y=0; Y<Grid_Size_Y; Y++) {
		for (X=0; X<Grid_Size_X; X++) {
			Screen[Y][X] = fgetc(fp);
			// Look for Pacman's starting location
			if (Screen[Y][X] == PACMAN) {
				Curr_X = X;
				Curr_Y = Y;
			}
		}
		if (fgetc(fp) != CARRIAGE_RETURN)
			printf("Error Reading Grid File, (%d,%d)", X,Y);
		if (fgetc(fp) != NEWLINE)
			printf("Error Reading Grid File, (%d,%d)", X,Y);
	}
	fclose(fp);
	fp = NULL;

	DEBUG_PrintScreen(Screen, Curr_Score);

	// Open movements file
	fp = fopen(Movements_File,"r");
	if (!fp)
		exit(1);

	// Read and process the movements file
	while (!feof(fp) && !GameOver) {
		Curr_Move = SPACE;
		Curr_Move = fgetc(fp);
		if (Curr_Move == SPACE)
			continue;
		// DEBUG - Print Move
		printf("*** Move-%c ***\n",Curr_Move);
		// Erase current position
		Screen[Curr_Y][Curr_X] = SPACE;
		// Figure next position
		switch (Curr_Move) {
			case LEFT:	Move_X = Curr_X - 1;
						Move_Y = Curr_Y;
						break;
			case RIGHT:	Move_X = Curr_X + 1;
						Move_Y = Curr_Y;
						break;
			case UP:	Move_X = Curr_X;
						Move_Y = Curr_Y - 1;
						break;
			case DOWN:	Move_X = Curr_X;
						Move_Y = Curr_Y + 1;
						break;
		}
		// See if it's legal
		if ((Move_X < 0) || (Move_X >= Grid_Size_X) ||
		    (Move_Y < 0) || (Move_Y >= Grid_Size_Y) ||
			(Screen[Move_Y][Move_X] == WALL)) {
			// Ignore Move if it's not "legal"
			continue;
		}
		// Process Portals by makeing move wrap to opposite side
		if (Screen[Move_Y][Move_X] == PORTAL_L) {
			Move_X = Grid_Size_X - 2;
		}
		else if (Screen[Move_Y][Move_X] == PORTAL_R) {
			Move_X = 1;
		}
		// Process Final location and scoring
		switch (Screen[Move_Y][Move_X]) {
			case GHOST:
						// DEBUG
						printf("Encountered a Ghost at %02d,%02d, GAME OVER\n",Move_X, Move_Y);
						GameOver = TRUE;
						continue;
			// Scoring cascades through other cases
			// so the number look a little funky
			case WATERMELON:	Curr_Score += 25;	// +25 move below = 50
			case CHERRIES:		Curr_Score += 15;	// +10 more below = 25
			case TARGET:		Curr_Score += 9;	// + 1 more below = 10
			case CRUMB:			Curr_Score += 1;
			case SPACE:			Curr_Score += 0;	// Only score locations once
								// Move to new location
								Curr_X = Move_X;
								Curr_Y = Move_Y;
								Screen[Curr_Y][Curr_X] = PACMAN;
		}
		DEBUG_PrintScreen(Screen, Curr_Score);
	}
	fclose(fp);
	printf("\n\n%d pts.\n", Curr_Score);
	return 0;
}
