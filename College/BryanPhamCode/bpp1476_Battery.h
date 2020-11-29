#include "bpp1476_Auto_Part.h"

class Battery : public Auto_Part
{
public:
	Battery();
	Battery(std::string t,std::string n,int pn,double p,int ca,int cca,int v,int rcm) : cranking_amps(ca), cold_cranking_amps(cca), voltage(v), reserve_capacity_minutes(rcm), Auto_Part(t,n,pn,p) {};
	std::string get_type() const;
	std::string get_name() const;
	int get_part_number() const;
	double get_price() const;
	int get_ca() const;
	int get_coldca() const;
	int get_volt() const;
	int get_rescapmin() const;
	void set_type(std::string);
	void set_name(std::string);
	void set_part_number(int);
	void set_price(double);
	void set_ca(int);
	void set_coldca(int);
	void set_volt(int);
	void set_rescapmin(int);
	friend std::ostream& operator<<(std::ostream&, const Battery&);
	std::string to_string() const;
private:
	int cranking_amps;
	int cold_cranking_amps;
	int voltage;
	int reserve_capacity_minutes;
};
