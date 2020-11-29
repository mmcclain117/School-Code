#include "bpp1476_Inventory.h"

void Inventory::add_part(Auto_Part* part)
{
	if(inventory.count(part) == 0)
		inventory.insert(std::pair<Auto_Part*, int>(part, 1));
	else
		inventory.at(part) += 1;
}


void Inventory::add_parts(Auto_Part* part, int num)
{
	if(inventory.count(part) == 0)
		inventory.insert(std::pair<Auto_Part*, int>(part, num));
	else
		inventory.at(part) += num;
}

int Inventory::get_num_parts(Auto_Part* part)
{
	return inventory.at(part);
}

void Inventory::remove_part(Auto_Part* part)
{
	if(inventory.count(part) == 0)
		return;
	inventory.at(part) -= 1;
	if(inventory.at(part) <= 0)
		inventory.erase(part);
}

void Inventory::remove_parts(Auto_Part* part, int num)
{
	if(inventory.count(part) == 0)
		return;
	inventory.at(part) -= num;
	if(inventory.at(part) <= 0)
		inventory.erase(part);
}

std::ostream& operator<<(std::ostream& ost, const Inventory* inv)
{
	for(auto x : inv->inventory)
	{
		ost << x.first << " - " << x.second << std::endl;
	}
}
