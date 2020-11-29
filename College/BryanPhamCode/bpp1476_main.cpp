#include "bpp1476_Wheel_Tire_Combo.h"
#include "bpp1476_Battery.h"
#include "bpp1476_Windshield_Wiper.h"
#include "bpp1476_Inventory.h"
#include "bpp1476_Frame.h"
#include "bpp1476_Engine.h"

int main()
{
	Inventory* inventory;
	//inventory->add_part(new Battery("Battery","Duralast",1010,100.10,123,456,789,1000));
	
	
	//std::cout << inventory;
	
	Auto_Part* battery = new Battery{"Battery","Duralast",1010,100.10,123,456,789,1000};	
	std::cout << "created" << std::endl;	
	inventory->add_part(battery);
	std::cout << "added" << std::endl;
	
	/*
	delete battery;
	std::cout << "deleted" << std::endl;*/
	//Auto_Part* wiper = new Windshield_Wiper{"Wiper", "ClearWipe",1212,123.12,3,"round"};
	/*Auto_Part* tire = new Tire{"Tire", "HotWheels",1313,159.12,"Large",10,2,30,"Fast","Medium"};
	Auto_Part* wheel = new Wheel{"Wheel", "FastTrack", 1414, 174.99, "Wheelerman", "Black",32,15,"Hexagon"};
	Auto_Part* w_t_c = new Wheel_Tire_Combo{"Wheel&Tire", "WomboCombo", 9999, 99.99, "Circle", 46, 3, 35, "Fast", "Heavy", "SuperCat", "Green", 40,13, "Octagon"};
	Auto_Part* frame = new Frame{"Frame", "CoolFrame", 5555,555.55, "Sedan"};
	Auto_Part* engine = new Engine{"Engine", "BMWM51", 444, 444.44, 8, "V8"};*/
	
	/*inventory->add_part(wiper);
	inventory->add_part(tire);
	inventory->add_part(wheel);
	inventory->add_part(w_t_c);
	inventory->add_part(frame);
	inventory->add_part(engine);*/



















	/*Battery battery{"Battery","Duralast",1010,100.10,123,456,789,1000};
	Windshield_Wiper wiper{"Wiper", "ClearWipe",1212,123.12,3,"round"};
	Tire tire{"Tire", "HotWheels",1313,159.12,"Large",10,2,30,"Fast","Medium"};
	Wheel wheel{"Wheel", "FastTrack", 1414, 174.99, "Wheelerman", "Black",32,15,"Hexagon"};
	Wheel_Tire_Combo w_t_c{"Wheel&Tire", "WomboCombo", 9999, 99.99, "Circle", 46, 3, 35, "Fast", "Heavy", "SuperCat", "Green", 40,13, "Octagon"};
	std::cout << battery.to_string() << std::endl;
	std::cout << wiper.to_string() << std::endl;
	std::cout << tire.to_string() << std::endl;
	std::cout << wheel.to_string() << std::endl;
	std::cout << w_t_c.to_string() << std::endl;
	*/

	return 0;
}
