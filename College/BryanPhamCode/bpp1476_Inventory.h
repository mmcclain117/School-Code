#include "bpp1476_Auto_Part.h"
#include <map>

class Inventory : public Auto_Part
{
public:
	Inventory() {};
	void add_part(Auto_Part*);
	void add_parts(Auto_Part*, int);
	int get_num_parts(Auto_Part*);
	void remove_part(Auto_Part*);
	void remove_parts(Auto_Part*, int);
	friend std::ostream& operator<<(std::ostream&, const Inventory*);

private:
	std::map<Auto_Part*, int> inventory;
};
