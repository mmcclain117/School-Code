// Specification file for the MilTime class
#ifndef MILTIME_H
#define MILTIME_H
#include "Time.h"
#include <string>
using namespace std;

// Declaration of the MilTime class

class MilTime: public Time {
private:
	int milHours;
	int milSeconds;
	string BadHour =
			"Error: Invalid Number Of Hours Inputted! Should Be In The Range: 0-2359";
	string BadSeconds =
			"Error: Invalid Number Of Seconds Inputted! Should Be In The Range: 0-59.";
	string BadHourAndSeconds =
			"Error: Invalid Values Inputted! Minutes Should Be In The Range: 0-2359 And Seconds Should Be In The Range: 0-59.";
public:
	bool error = false;
	MilTime(int h, int s) :
			Time(0, 0, s) {
		milHours = h;
		milSeconds = s;

		try {
			ValidateNums();
		} catch (string errorcode) {
			cout << errorcode << endl;
			cout << "This Time Is Invalid." << endl;
			error = true;
		}

		convert();
	}
	void convert() {
		if (milHours > 1200)
			hour = milHours - 1200;
		else
			hour = milHours;

		hour /= 100;
		min = milHours % 100;
	}

	void setTime(int h, int s) {
		milHours = h;
		milSeconds = s;
		convert();
	}

	void ValidateNums() {
		if ((milHours < 0 || milHours > 2359)
				&& (milSeconds < 0 || milSeconds > 59)) {
			throw BadHourAndSeconds;
		}
		if (milHours < 0 || milHours > 2359) {
			throw BadHour;
		} else if (milSeconds < 0 || milSeconds > 59) {
			throw BadSeconds;
		}
	}

	int getHour() {
		return milHours;
	}

	int getStandHr() {
		return hour;
	}
};

#endif
