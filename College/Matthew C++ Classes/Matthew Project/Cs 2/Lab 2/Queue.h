#ifndef QUEUE_H
#define QUEUE_H

#include <iostream>
#include "UBArray.h"
using namespace std;

class queue
{
private:
	UBArray <string, int> stack;
	int index;//Keep track of where we are in the stack
	int headindex;
	string GetHeadData()
	{
		return stack.GetFirst();
	}
public:
	queue()
	{
		index = 0;
		headindex = 0;
	}
	~queue()
	{

	}
	void Queue(string s)
	{
		stack[index] = s;//This \does the same as incrementing size first, then doing stack[size-1] = s.
		index++;//This way is more efficient as is requires less operations to conduct.
	}
	void DeQueue()
	{
		if (stack.Size() == 0)
		{
			cout << "No Elements In The Queue. Operation Failed." << endl;
		}
		else
		{
			cout << "String From Front Of The Queue: " << GetHeadData() << endl;
			stack.Remove(headindex);
			headindex++;
		}
	}
};
#endif
