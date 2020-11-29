#include "bpp1476_Auto_Part.h"

class Frame : public Auto_Part
{
public:
	Frame();
	Frame(std::string t, std::string n, int pn, double p, std::string ft) : frame_type(ft), Auto_Part(t,n,pn,p) {};
	int get_num_cylinders() const;
	std::string get_type() const;
	std::string get_name() const;
	int get_part_number() const;
	double get_price() const;
	std::string get_frame_type() const;
	void set_type(std::string);
	void set_name(std::string);
	void set_part_number(int);
	void set_price(double);
	void set_frame_type(std::string);
	friend std::ostream& operator<<(std::ostream&, const Frame&);
	std::string to_string() const;
private:
	std::string frame_type;
};
