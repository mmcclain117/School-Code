#include "bpp1476_Auto_Part.h"

class Tire : public virtual Auto_Part
{
public:
	Tire();
	Tire(std::string t,std::string n,int pn,double p,std::string tt,int w,int r,int dia, std::string sr,std::string lr) : tire_type(tt), width(w), ratio(r), diameter(dia), speed_rating(sr), load_range(lr), Auto_Part(t,n,pn,p) {};
	std::string get_type() const;
	std::string get_name() const;
	int get_part_number() const;
	double get_price() const;
	std::string get_tire_type() const;
	int get_width() const;
	int get_ratio() const;
	int get_diameter() const;
	std::string get_speed_rate() const;
	std::string get_load() const;
	void set_type(std::string);
	void set_name(std::string);
	void set_part_number(int);
	void set_price(double);
	void set_tire_type(std::string);
	void set_width(int);
	void set_ratio(int);
	void set_diameter(int);
	void set_speed_rate(std::string);
	void set_load(std::string);
	friend std::ostream& operator<<(std::ostream&, const Tire&);
	std::string to_string() const;
protected:
	std::string tire_type;
	int width;
	int ratio;
	int diameter;
	std::string speed_rating;
	std::string load_range;
};
