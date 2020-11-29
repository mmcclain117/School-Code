CXXFLAGS = -std=c++17

all: executable

executable: bpp1476_main.o bpp1476_Auto_Part.o bpp1476_Wheel.o bpp1476_Tire.o bpp1476_Windshield_Wiper.o bpp1476_Battery.o bpp1476_Wheel_Tire_Combo.o bpp1476_Engine.o bpp1476_Frame.o bpp1476_Inventory.o
	$(CXX) $(CXXFLAGS) bpp1476_main.o bpp1476_Wheel.o bpp1476_Tire.o bpp1476_Windshield_Wiper.o bpp1476_Battery.o bpp1476_Auto_Part.o bpp1476_Wheel_Tire_Combo.o bpp1476_Engine.o bpp1476_Frame.o bpp1476_Inventory.o
	./a.out
bpp1476_main.o: bpp1476_Auto_Part.h bpp1476_Wheel.h bpp1476_main.cpp bpp1476_Windshield_Wiper.h bpp1476_Battery.h bpp1476_Battery.h bpp1476_Wheel_Tire_Combo.h bpp1476_Engine.h bpp1476_Frame.h bpp1476_Inventory.h
	$(CXX) $(CXXFLAGS) -c bpp1476_main.cpp
bpp1476_Wheel.o: bpp1476_Wheel.h bpp1476_Wheel.cpp bpp1476_Auto_Part.h
	$(CXX) $(CXXFLAGS) -c bpp1476_Wheel.cpp
bpp1476_Tire.o: bpp1476_Tire.h bpp1476_Tire.cpp bpp1476_Auto_Part.h
	$(CXX) $(CXXFLAGS) -c bpp1476_Tire.cpp
bpp1476_Wheel_Tire_Combo.o: bpp1476_Wheel_Tire_Combo.h bpp1476_Wheel_Tire_Combo.cpp bpp1476_Auto_Part.h
	$(CXX) $(CXXFLAGS) -c bpp1476_Wheel_Tire_Combo.cpp
bpp1476_Battery.o: bpp1476_Battery.h bpp1476_Battery.cpp bpp1476_Auto_Part.h
	$(CXX) $(CXXFLAGS) -c bpp1476_Battery.cpp
bpp1476_Engine.o: bpp1476_Engine.h bpp1476_Engine.cpp bpp1476_Auto_Part.h
	$(CXX) $(CXXFLAGS) -c bpp1476_Engine.cpp
bpp1476_Frame.o: bpp1476_Frame.h bpp1476_Frame.cpp bpp1476_Auto_Part.h
	$(CXX) $(CXXFLAGS) -c bpp1476_Frame.cpp
bpp1476_Inventory.o: bpp1476_Inventory.h bpp1476_Inventory.cpp bpp1476_Auto_Part.h
	$(CXX) $(CXXFLAGS) -c bpp1476_Inventory.cpp
bpp1476_Windshield_Wiper.o: bpp1476_Windshield_Wiper.h bpp1476_Windshield_Wiper.cpp bpp1476_Auto_Part.h
	$(CXX) $(CXXFLAGS) -c bpp1476_Windshield_Wiper.cpp
bpp1476_Auto_Part.o: bpp1476_Auto_Part.h bpp1476_Auto_Part.cpp
	$(CXX) $(CXXFLAGS) -c bpp1476_Auto_Part.cpp
clean:
	rm -f *.o a.out
