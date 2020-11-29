#include "bpp1476_Wheel.h"

Wheel::Wheel()
{
	//Auto_Part();
	category = "null";
	color = "null";
	diameter = 0;
	width = 0;
	bolt_pattern = "null";
}

std::string Wheel::get_type() const
{
	return type;
}

std::string Wheel::get_name() const
{
	return name;
}

int Wheel::get_part_number() const
{
	return part_number;
}

double Wheel::get_price() const
{
	return price;
}

std::string Wheel::get_category() const
{
	return category;
}

std::string Wheel::get_color() const
{
	return color;
}

int Wheel::get_diameter() const
{
	return diameter;
}

int Wheel::get_width() const
{
	return width;
}

std::string Wheel::get_bolt() const
{
	return bolt_pattern;
}

void Wheel::set_type(std::string t)
{
	type = t;
}

void Wheel::set_name(std::string n)
{
	name = n;
}

void Wheel::set_part_number(int pn)
{
	part_number = pn;
}

void Wheel::set_price(double p)
{
	price = p;
}

void Wheel::set_category(std::string cat)
{
	category = cat;
}

void Wheel::set_color(std::string c)
{
	color = c;
}

void Wheel::set_diameter(int dia)
{
	diameter = dia;
}

void Wheel::set_width(int w)
{
	width = w;
}

void Wheel::set_bolt(std::string bp)
{
	bolt_pattern = bp;
}

std::ostream& operator<<(std::ostream& ost, const Wheel& wheel)
{
	ost << "Type: " << wheel.type << ", Name: " << wheel.name << ", Part Number: " << wheel.part_number << ", Price: " << std::put_money(wheel.price) << ", Category: " << wheel.category << ", Color: " << wheel.color << ", Diameter: " << wheel.diameter << ", Width: " << wheel.width << ", Bolt Pattern: " << wheel.bolt_pattern;
	return ost;
}

std::string Wheel::to_string() const
{
	return "Type: " + get_type() + ", Name: " + get_name() + ", Part Number: " + std::to_string(get_part_number()) + ", Price: " + std::to_string(get_price()) + ", Category: " + get_category() + ", Color: " + get_color() + ", Diameter: " + std::to_string(get_diameter()) + ", Width: " + std::to_string(get_width()) + ", Bolt Pattern: " + get_bolt();
}
