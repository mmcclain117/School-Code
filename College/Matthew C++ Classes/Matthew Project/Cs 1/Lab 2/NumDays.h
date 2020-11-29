#ifndef NUMDAYS_H
#define NUMDAYS_H
class NumDays {
private:
	int workhours;
	double workdays;
public:
	NumDays() {
		workhours = 0;
		workdays = 0;
	}
	NumDays(int wh) {
		workhours = wh;
		workdays = (double) wh / 8;
	}
	void setHours(int wh) {
		workhours = wh;
	}
	void setDays(double wd) {
		workdays = wd;
	}
	double getHours() {
		return workhours;
	}
	double getDays() {
		return workdays;
	}
	int operator+(const NumDays& nd) {
		NumDays temp;
		temp.workhours = this->workhours + nd.workhours;
		return temp.workhours;
	}
	int operator-(const NumDays& nd) {
		NumDays temp;
		temp.workhours = this->workhours - nd.workhours;
		return temp.workhours;
	}
	NumDays operator++() {
		NumDays temp;
		temp.workhours = ++this->workhours;
		temp.workdays = (double) this->workhours / 8;
		return temp;
	}
	NumDays operator++(int) {
		NumDays temp;
		temp.workhours = ++this->workhours;
		temp.workdays = (double) this->workhours / 8;
		return temp;
	}
	NumDays operator--() {
		NumDays temp;
		temp.workhours = --this->workhours;
		temp.workdays = (double) this->workhours / 8;
		return temp;
	}
	NumDays operator--(int) {
		NumDays temp;
		temp.workhours = --this->workhours;
		temp.workdays = (double) this->workhours / 8;
		return temp;
	}
};
#endif
