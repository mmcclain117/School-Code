#include "bpp1476_Auto_Part.h"

class Engine : public Auto_Part
{
public:
	Engine();
	Engine(std::string t, std::string n, int pn, double p, int nc, std::string ft) : num_cylinders(nc), fuel_type(ft), Auto_Part(t,n,pn,p) {};
	int get_num_cylinders() const;
	std::string get_type() const;
	std::string get_name() const;
	int get_part_number() const;
	double get_price() const;
	std::string get_fuel_type() const;
	void set_type(std::string);
	void set_name(std::string);
	void set_part_number(int);
	void set_price(double);
	void set_num_cylinders(int);
	void set_fuel_type(std::string);
	friend std::ostream& operator<<(std::ostream&, const Engine&);
	std::string to_string() const;
private:
	int num_cylinders;	
	std::string fuel_type;
};
