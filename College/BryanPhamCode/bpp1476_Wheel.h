#include "bpp1476_Auto_Part.h"

class Wheel : public virtual Auto_Part
{
public:
	Wheel();
	Wheel(std::string t,std::string n,int pn,double p,std::string cat,std::string c,int dia,int w, std::string bp) : category(cat), color(c), diameter(dia), width(w), bolt_pattern(bp), Auto_Part(t,n,pn,p) {};
	std::string get_type() const;
	std::string get_name() const;
	int get_part_number() const;
	double get_price() const;
	std::string get_category() const;
	std::string get_color() const;
	int get_diameter() const;
	int get_width() const;
	std::string get_bolt() const;
	void set_type(std::string);
	void set_name(std::string);
	void set_part_number(int);
	void set_price(double);
	void set_category(std::string);
	void set_color(std::string);
	void set_diameter(int);
	void set_width(int);
	void set_bolt(std::string);
	friend std::ostream& operator<<(std::ostream&, const Wheel&);
	std::string to_string() const;
protected:
	std::string category;
	std::string color;
	int diameter;
	int width;
	std::string bolt_pattern;
};
