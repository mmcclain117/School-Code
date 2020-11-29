/*
 * fact.cpp
 *
 *  Created on: Oct 25, 2017
 *      Author: Master
 */
#include <iostream>
using namespace std;

#include "Function.h"

long factorial(long a) {
	if (a > 1)
		return (a * factorial(a - 1));
	else
		return (1);
}

