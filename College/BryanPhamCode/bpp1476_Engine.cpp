#include "bpp1476_Engine.h"

Engine::Engine()
{
	num_cylinders = 0;
	fuel_type = "null";
}

std::string Engine::get_type() const
{
	return type;
}

std::string Engine::get_name() const
{
	return name;
}

int Engine::get_part_number() const
{
	return part_number;
}

double Engine::get_price() const
{
	return price;
}

int Engine::get_num_cylinders() const
{
	return num_cylinders;
}

std::string Engine::get_fuel_type() const
{
	return fuel_type;
}

void Engine::set_fuel_type(std::string ft)
{
	fuel_type = ft;
}

void Engine::set_num_cylinders(int nc)
{
	num_cylinders = nc;
}

std::ostream& operator<<(std::ostream& ost, const Engine& engine)
{
	ost << "Type: " << engine.type << ", Name: " << engine.name << ", Part Number: " << engine.part_number << ", Price: " << std::put_money(engine.price) << ", Number of Cylinders: " << engine.num_cylinders << ", Fuel Type: " << engine.fuel_type;
	return ost;
}

std::string Engine::to_string() const
{
	return "Type: " + get_type() + ", Name: " + get_name() + ", Part Number: " + std::to_string(get_part_number()) + ", Price: " + std::to_string(get_price()) + ", Number of Cylinders: " + std::to_string(get_num_cylinders()) + ", Fuel Type: " + get_fuel_type();
}
