#include "bpp1476_Auto_Part.h"

Auto_Part::Auto_Part()
{
	type = "null";
	name = "null";
	part_number = 0;
	price = 0.0;
}

std::string Auto_Part::get_type() const
{
	return type;
}

std::string Auto_Part::get_name() const
{
	return name;
}

int Auto_Part::get_part_number() const
{
	return part_number;
}

double Auto_Part::get_price() const
{
	return price;
}

void Auto_Part::set_type(std::string t)
{
	type = t;
}

void Auto_Part::set_name(std::string n)
{
	name = n;
}

void Auto_Part::set_part_number(int pn)
{
	part_number = pn;
}

void Auto_Part::set_price(double p)
{
	price = p;
}

std::ostream& operator<<(std::ostream& ost, const Auto_Part& part)
{
	ost << "Type: " << part.type << ", Name: " << part.name << ", Part Number: " << part.part_number << ", Price: " << std::put_money(part.price);
	return ost;
}

bool Auto_Part::operator<(const Auto_Part& rhs) const
{
	if(this->part_number < rhs.part_number)
		return true;
	return false;
}

std::string Auto_Part::to_string() const
{
	return "Type: " + get_type() + ", Name: " + get_name() + ", Part Number: " + std::to_string(get_part_number()) + ", Price: " + std::to_string(get_price());
}
