#include "bpp1476_Wheel.h"
#include "bpp1476_Tire.h"

class Wheel_Tire_Combo : public Wheel, public Tire
{
public:
	Wheel_Tire_Combo();
	Wheel_Tire_Combo(std::string t, std::string n, int pn, double p, std::string tt, int w, int r, int dia, std::string sr, std::string lr, std::string cat, std::string c, int w_dia, int w_w, std::string bp) : Tire(t,n,pn,p,tt,w,r,dia,sr,lr), Wheel(t,n,pn,p,cat,c,w_dia,w_w,bp), Auto_Part(t,n,pn,p) {};
	friend std::ostream& operator<<(std::ostream&, const Wheel_Tire_Combo&);
	std::string to_string() const;
};
