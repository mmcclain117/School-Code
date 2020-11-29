#include "bpp1476_Wheel_Tire_Combo.h"

Wheel_Tire_Combo::Wheel_Tire_Combo()
{
}

std::ostream& operator<<(std::ostream& ost, const Wheel_Tire_Combo& w_t_c)
{
	ost << "Type: " << w_t_c.type << ", Name: " << w_t_c.name << ", Part Number: " << w_t_c.part_number << ", Price: " << std::put_money(w_t_c.price) << ", Tire Type: " << w_t_c.tire_type << ", Tire Width: " << w_t_c.Tire::width << ", Ratio: " << w_t_c.ratio << ", Tire Diameter: " << w_t_c.Tire::diameter << ", Speed Rating: " << w_t_c.speed_rating << ", Load Range: " << w_t_c.load_range << ", Category: " << w_t_c.category << ", Color: " << w_t_c.color << ", Wheel Diameter: " << w_t_c.Wheel::diameter << ", Wheel Width: " << w_t_c.Wheel::width << ", Bolt Pattern: " << w_t_c.bolt_pattern;
	return ost;
}

std::string Wheel_Tire_Combo::to_string() const
{
	return "Type: " + Wheel::get_type() + ", Name: " + Wheel::get_name() + ", Part Number: " + std::to_string(Wheel::get_part_number()) + ", Price: " + std::to_string(Wheel::get_price()) + ", Tire Type: " + get_tire_type() + ", Tire Width: " + std::to_string(Tire::get_width()) + ", Ratio: " + std::to_string(get_ratio()) + ", Tire Diameter: " + std::to_string(Tire::get_diameter()) + ", Speed Rating: " + get_speed_rate() + ", Load Range: " + get_load() + ", Category: " + get_category() + ", Color: " + get_color() + ", Wheel Diameter: " + std::to_string(Wheel::get_diameter()) + ", Wheel Width: " + std::to_string(Wheel::get_width()) + ", Bolt Pattern: " + get_bolt();
}
