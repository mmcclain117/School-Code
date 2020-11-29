// Specification file for the Time class
#ifndef TIME_H
#define TIME_H

class Time {
protected:
	int hour;
	int min;
	int sec;
public:
	Time(int h, int m, int s) {
		hour = h;
		min = m;
		sec = s;
	}

	int getHour() {
		return hour;
	}

	int getMin() {
		return min;
	}

	int getSec() {
		return sec;
	}
};

#endif
