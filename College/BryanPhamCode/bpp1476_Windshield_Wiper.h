#include "bpp1476_Auto_Part.h"

class Windshield_Wiper : public Auto_Part
{
public:
	Windshield_Wiper();
	Windshield_Wiper(std::string t,std::string n,int pn,double p,int l,std::string ft) : length(l), frame_type(ft), Auto_Part(t,n,pn,p) {};
	std::string get_type() const;
	std::string get_name() const;
	int get_part_number() const;
	double get_price() const;
	int get_length() const;
	std::string get_frame_type() const;
	void set_type(std::string);
	void set_name(std::string);
	void set_part_number(int);
	void set_price(double);
	void set_length(int);
	void set_frame_type(std::string);
	friend std::ostream& operator<<(std::ostream&, const Windshield_Wiper&);
	std::string to_string() const;
private:
	int length;
	std::string frame_type;
};
