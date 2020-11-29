#include "bpp1476_Tire.h"

Tire::Tire()
{
	//Auto_Part();
	tire_type = "null";
	width = 0;
	ratio = 0;
	diameter = 0;
	speed_rating = "null";
	load_range = "null";
}

std::string Tire::get_type() const
{
	return type;
}

std::string Tire::get_name() const
{
	return name;
}

int Tire::get_part_number() const
{
	return part_number;
}

double Tire::get_price() const
{
	return price;
}

std::string Tire::get_tire_type() const
{
	return tire_type;
}

int Tire::get_width() const
{
	return width;
}

int Tire::get_ratio() const
{
	return ratio;
}

int Tire::get_diameter() const
{
	return diameter;
}

std::string Tire::get_speed_rate() const
{
	return speed_rating;
}

std::string Tire::get_load() const
{
	return load_range;
}

void Tire::set_type(std::string t)
{
	type = t;
}

void Tire::set_name(std::string n)
{
	name = n;
}

void Tire::set_part_number(int pn)
{
	part_number = pn;
}

void Tire::set_price(double p)
{
	price = p;
}

void Tire::set_tire_type(std::string tt)
{
	tire_type = tt;
}

void Tire::set_width(int w)
{
	width = w;
}

void Tire::set_ratio(int r)
{
	ratio = r;
}

void Tire::set_diameter(int dia)
{
	diameter = dia;
}

void Tire::set_speed_rate(std::string sr)
{
	speed_rating = sr;
}

void Tire::set_load(std::string lr)
{
	load_range = lr;
}

std::ostream& operator<<(std::ostream& ost, const Tire& tire)
{
	ost << "Type: " << tire.type << ", Name: " << tire.name << ", Part Number: " << tire.part_number << ", Price: " << std::put_money(tire.price) << ", Tire Type: " << tire.tire_type << ", Width: " << tire.width << ", Ratio: " << tire.ratio << ", Diameter: " << tire.diameter << ", Speed Rating: " << tire.speed_rating << ", Load Range: " << tire.load_range;
	return ost;
}

std::string Tire::to_string() const
{
	return "Type: " + get_type() + ", Name: " + get_name() + ", Part Number: " + std::to_string(get_part_number()) + ", Price: " + std::to_string(get_price()) + ", Tire Type: " + get_tire_type() + ", Width: " + std::to_string(get_width()) + ", Ratio: " + std::to_string(get_ratio()) + ", Diameter: " + std::to_string(get_diameter()) + ", Speed Rating: " + get_speed_rate() + ", Load Range: " + get_load();
}
