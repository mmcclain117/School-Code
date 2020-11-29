#include "bpp1476_Frame.h"

Frame::Frame()
{
	frame_type = "null";
}

std::string Frame::get_type() const
{
	return type;
}

std::string Frame::get_name() const
{
	return name;
}

int Frame::get_part_number() const
{
	return part_number;
}

double Frame::get_price() const
{
	return price;
}

std::string Frame::get_frame_type() const
{
	return frame_type;
}

void Frame::set_frame_type(std::string ft)
{
	frame_type = ft;
}

std::ostream& operator<<(std::ostream& ost, const Frame& frame)
{
	ost << "Type: " << frame.type << ", Name: " << frame.name << ", Part Number: " << frame.part_number << ", Price: " << std::put_money(frame.price) << ", Frame Type: " << frame.frame_type;
	return ost;
}

std::string Frame::to_string() const
{
	return "Type: " + get_type() + ", Name: " + get_name() + ", Part Number: " + std::to_string(get_part_number()) + ", Price: " + std::to_string(get_price()) + ", Frame Type: " + get_frame_type();
}
