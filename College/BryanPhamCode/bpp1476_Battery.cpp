#include "bpp1476_Battery.h"

Battery::Battery()
{
	//Auto_Part();
	cranking_amps = 0;
	cold_cranking_amps = 0;
	voltage = 0;
	reserve_capacity_minutes = 0;
}

std::string Battery::get_type() const
{
	return type;
}

std::string Battery::get_name() const
{
	return name;
}

int Battery::get_part_number() const
{
	return part_number;
}

double Battery::get_price() const
{
	return price;
}

int Battery::get_ca() const
{
	return cranking_amps;
}

int Battery::get_coldca() const
{
	return cold_cranking_amps;
}

int Battery::get_volt() const
{
	return voltage;
}

int Battery::get_rescapmin() const
{
	return reserve_capacity_minutes;
}

void Battery::set_type(std::string t)
{
	type = t;
}

void Battery::set_name(std::string n)
{
	name = n;
}

void Battery::set_part_number(int pn)
{
	part_number = pn;
}

void Battery::set_price(double p)
{
	price = p;
}

void Battery::set_ca(int ca)
{
	cranking_amps = ca;
}

void Battery::set_coldca(int cca)
{
	cold_cranking_amps = cca;
}

void Battery::set_volt(int v)
{
	voltage = v;
}

void Battery::set_rescapmin(int rcm)
{
	reserve_capacity_minutes = rcm;
}

std::ostream& operator<<(std::ostream& ost, const Battery& battery)
{
	ost << "Type: " << battery.type << ", Name: " << battery.name << ", Part Number: " << battery.part_number << ", Price: " << std::put_money(battery.price) << ", Cranking Amps: " << battery.cranking_amps << ", Cold Cranking Amps: " << battery.cold_cranking_amps << ", Voltage: " << battery.voltage << ", Reserve Capacity Minutes: " << battery.reserve_capacity_minutes;
	return ost;
}

std::string Battery::to_string() const
{
	return "Type: " + get_type() + ", Name: " + get_name() + ", Part Number: " + std::to_string(get_part_number()) + ", Price: " + std::to_string(get_price()) + ", Cranking Amps: " + std::to_string(get_ca()) + ", Cold Cranking Amps: " + std::to_string(get_coldca()) + ", Voltage: " + std::to_string(get_volt()) + ", Reserve Capacity Minutes: " + std::to_string(get_rescapmin());
}
