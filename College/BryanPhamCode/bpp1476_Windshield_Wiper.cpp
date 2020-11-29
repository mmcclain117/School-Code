#include "bpp1476_Windshield_Wiper.h"

Windshield_Wiper::Windshield_Wiper()
{
	//Auto_Part();
	length = 0;
	frame_type = "null";
}

std::string Windshield_Wiper::get_type() const
{
	return type;
}

std::string Windshield_Wiper::get_name() const
{
	return name;
}

int Windshield_Wiper::get_part_number() const
{
	return part_number;
}

double Windshield_Wiper::get_price() const
{
	return price;
}

int Windshield_Wiper::get_length() const
{
	return length;
}

std::string Windshield_Wiper::get_frame_type() const
{
	return frame_type;
}

void Windshield_Wiper::set_type(std::string t)
{
	type = t;
}

void Windshield_Wiper::set_name(std::string n)
{
	name = n;
}

void Windshield_Wiper::set_part_number(int pn)
{
	part_number = pn;
}

void Windshield_Wiper::set_price(double p)
{
	price = p;
}

void Windshield_Wiper::set_length(int l) 
{
	length = l;
}

void Windshield_Wiper::set_frame_type(std::string ft)
{
	frame_type = ft;
}

std::ostream& operator<<(std::ostream& ost, const Windshield_Wiper& wiper)
{
	ost << "Type: " << wiper.type << ", Name: " << wiper.name << ", Part Number: " << wiper.part_number << ", Price: " << std::put_money(wiper.price) << ", Length: " << wiper.length << ", Frame Type: " << wiper.frame_type;
	return ost;
}

std::string Windshield_Wiper::to_string() const
{
	return "Type: " + get_type() + ", Name: " + get_name() + ", Part Number: " + std::to_string(get_part_number()) + ", Price: " + std::to_string(get_price()) + ", Length: " + std::to_string(get_length()) + ", Frame Type: " + get_frame_type();
}
