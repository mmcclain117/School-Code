// prob08.c
// HP Codwars 2005
// Elevator
//

#include <stdio.h>

#define UP	1
#define IDLE	0
#define DOWN	-1

#define TRAVEL_TIME	5
#define MAX_FLOORS	20

#define inputfile	"prob08.in"

int main(int argc, char *argv[]) 
{
	int curr_floor = 1;
	int high_dest = 0;
	int low_dest = MAX_FLOORS+1;
	int time = 0;
	int floors = 0;
	int direction = IDLE;
	int request = 0;
	int Requests[MAX_FLOORS+1] = {0};
	int ServiceTimes[MAX_FLOORS+1] = {0};
	int MaxTime = 0;
	int MaxFloor = 0;
	FILE *fp = NULL;
	fp = fopen(inputfile,"r");
	while (!feof(fp) 
		|| (high_dest >= curr_floor) 
		|| (low_dest <= curr_floor)) {
		// Administrate Request
		if (!feof(fp)) {
			request = 0;
			fscanf(fp, "%d", &request);	// read request
			// Determine if it requires a change in travel plans
			// in the up direction
			if ((request > curr_floor) 
				&& (request > high_dest))
				high_dest = request;
			// in the down direction
			if ((request > 0) 
				&& (request < curr_floor) 
				&& (request < low_dest))
				low_dest = request;
			// if we haven't gotten a previous call for this floor
			if ((request > 0) && (Requests[request] == 0)) {
				// Mark the call
				Requests[request] = 1;
				// And the time it arrived
				ServiceTimes[request] = time;
				printf("Request logged on floor %d at %d\n",request, time);
			}
		}
		else
			request = 0;
		// Do we have a request for this floor?
		if (Requests[curr_floor] == 1) {
			// Calculate time to service request
			// and see if it's the longest time so far
			printf("Serviced Floor %d at %d, was called at %d, Time to service is %d seconds.\n",curr_floor, time, ServiceTimes[curr_floor],(time-ServiceTimes[curr_floor]));
			if (MaxTime < (time - ServiceTimes[curr_floor])) {
				MaxTime = (time - ServiceTimes[curr_floor]);
				MaxFloor = curr_floor;
			}
			ServiceTimes[curr_floor] = 0;
			Requests[curr_floor] = 0;
		}
		// Stop if we have reached a travel extreme
		if (curr_floor == high_dest) {	// have we reached the top
			high_dest = 0;
			direction = IDLE;
		}
		if (curr_floor == low_dest) {	// have we reached the bottom
			low_dest = MAX_FLOORS+1;
			direction = IDLE;
		}
		// Determine direction if we are idle
		if (direction == IDLE) {
			if (high_dest > curr_floor)
				direction= UP;
			if (low_dest < curr_floor)
				direction = DOWN;
		}
		// Move elevator
		curr_floor += direction;
		if (direction  != IDLE)
			floors += 1;
		time += TRAVEL_TIME;
		printf("---Time = %03d, Low = %02d, Current = %02d, High = %02d\n", time, low_dest, curr_floor, high_dest);
	}
	fclose(fp);
	// Print final results
	printf("%d\n%d\n", floors, MaxTime);
	return 0;
}
