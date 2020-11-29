#ifndef AUTO_PART_H
#define AUTO_PART_H
#include <string>
#include <iomanip>
#include <iostream>

class Auto_Part
{
public:
	Auto_Part();
	Auto_Part(std::string t, std::string n, int pn, double p): type(t), name(n), part_number(pn), price(p) {};
	std::string get_type() const;
	std::string get_name() const;
	int get_part_number() const;
	double get_price() const;
	void set_type(std::string);
	void set_name(std::string);
	void set_part_number(int);
	void set_price(double);
	friend std::ostream& operator<<(std::ostream&, const Auto_Part&);
	bool operator<(const Auto_Part&) const;
	virtual std::string to_string() const = 0;
protected:
	std::string type;
	std::string name;
	int part_number;
	double price;
};

#endif
