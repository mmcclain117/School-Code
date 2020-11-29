// usingnamespaces.cpp

#include "namespaces.h"
#include <iostream>

using namespace mycode;

int main()
{
  foo();  // implies mycode::foo();
  system("pause");
  return 0;
}
