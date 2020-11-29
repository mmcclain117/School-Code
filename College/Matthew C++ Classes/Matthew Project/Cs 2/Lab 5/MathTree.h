#ifndef MATH_TREE_H
#define MATH_TREE_H

#include <iostream>
#include "WCS_Pointer.h"
using namespace std;

class MathTree
	{
	private:
		struct Node: public RefCount
			{
			WCS_Pointer <Node>		pLeft;
			WCS_Pointer <Node>		pRight;
			WCS_Pointer <Node>		pParent;
			bool					LeftSideDone;
			int						type;
			int						value;
			int						precedence;
			int						varval;

			Node(const int & I){};
			};

		WCS_Pointer <Node> &	GetLeftMostOperator(const WCS_Pointer <Node> & pStart)
		{
			WCS_Pointer <Node> Ptr(pStart);

			if (!(*pRoot).pLeft)
			{
				return pRoot;
			}
			else
			{
				while ((*Ptr).pLeft)
				{
					(*Ptr).LeftSideDone = false;
					Ptr = (*Ptr).pLeft;
				}
				return (*Ptr).pParent;		// if tree only has a constant or variable, we will return NULL
			}
		}
		MathTree(const MathTree &);
		MathTree & operator = (const MathTree &);

		WCS_Pointer <Node>		pRoot;
		WCS_Pointer <Node>		pLastOperator;
	public:
		MathTree()
		{

		}
		~MathTree()
		{
			Delete();
		}
		void Delete()
		{
			cout << "Deleting Tree." << endl;
			WCS_Pointer <Node>		pTemp;
			if ((*pRoot).pLeft || (*pRoot).pRight)//If the tree is more than just a root
			{
				while ((*pLastOperator).pParent)
				{
					pTemp = (*pLastOperator).pParent;
					(*pLastOperator).pRight.SetToNull();
					(*pLastOperator).pLeft.SetToNull();
					(*pLastOperator).pParent.SetToNull();
					pLastOperator.SetToNull();
					pLastOperator = pTemp;
					pTemp.SetToNull();
				}
			}
			else if (pRoot)//If the tree is only a root by itself
			{
				(*pRoot).pRight.SetToNull();
				(*pRoot).pLeft.SetToNull();
				(*pRoot).pParent.SetToNull();
				pRoot.SetToNull();
			}
			else
				cout << "There Is Nothing To Delete." << endl;
		}
		int	Evaluate()
		{
			if (pRoot)
			{
				WCS_Pointer <Node>		Ptr(GetLeftMostOperator(pRoot));	// Ptr could end up as NULL if tree is only a constant or variable
				while (Ptr)
					if (!(*Ptr).LeftSideDone)
					{
						(*Ptr).value = (*(*Ptr).pLeft).value;
						(*Ptr).LeftSideDone = true;
						Ptr = GetLeftMostOperator((*Ptr).pRight);
					}
					else
					{
						switch ((*Ptr).type)
						{
						case 0://Operator +
							(*Ptr).value = (*Ptr).value + (*(*Ptr).pRight).value;
							break;
						case 1://Operator -
							(*Ptr).value = (*Ptr).value - (*(*Ptr).pRight).value;
							break;
						case 2://Operator *
							(*Ptr).value = (*Ptr).value * (*(*Ptr).pRight).value;
							break;
						case 3://Operator /
							(*Ptr).value = (*Ptr).value / (*(*Ptr).pRight).value;
							break;
						default:
							cout << "Internal error 101" << endl;
							exit(0);
						}
						Ptr = (*Ptr).pParent;
					}
				return (*pRoot).value;
			}
			else
				return 0;
		}
		void InsertBinaryOperator(const int T, const int P)
		{
			WCS_Pointer <Node>	pNewOperator(new Node(T));
			(*pNewOperator).type = T;
			(*pNewOperator).precedence = P;
			(*pNewOperator).value = 0;

			while (pLastOperator && ((*pLastOperator).precedence >= (*pNewOperator).precedence))
				pLastOperator = (*pLastOperator).pParent;
			if (!pRoot)
				pRoot = pNewOperator;
			else if (!pLastOperator)		// we backed all the way out of the tree
			{
				(*pNewOperator).pLeft = pRoot;
				(*pRoot).pParent = pNewOperator;
				pRoot = pNewOperator;
			}
			else
			{		// we are adding a new operator into the middle of the tree
				(*pNewOperator).pLeft = (*pLastOperator).pRight;
				(*pNewOperator).pParent = pLastOperator;
				(*(*pLastOperator).pRight).pParent = pNewOperator;
				(*pLastOperator).pRight = pNewOperator;
			}
			pLastOperator = pNewOperator;
			cout << "Inserted Operator " << (*pNewOperator).type << " With Precedence Level " << (*pNewOperator).precedence << endl;
		}
		void InsertOperand(const int I)
		{
			WCS_Pointer <Node>	pTemp(new Node(I));
			(*pTemp).type = -1;//-1 for constants and variables. 0-3 for operators
			(*pTemp).value = I;

			if (!pRoot)
				pRoot = pTemp;
			else
			{
				(*pLastOperator).pRight = pTemp;
				(*pTemp).pParent = pLastOperator;
			}
			cout << "Value Of Inserted Operand: " << (*pTemp).value << endl;
		}
		void InsertVariableOperand(const int V)
		{
			WCS_Pointer <Node>	pTemp(new Node(V));
			(*pTemp).type = -1;//-1 for consants and variables. 0-3 for operators
			(*pTemp).varval = V;

			if (!pRoot)
				pRoot = pTemp;
			else
			{
				(*pLastOperator).pRight = pTemp;
				(*pTemp).pParent = pLastOperator;
			}
			cout << "Inserted Variable " << V << endl;
		}
		void ModifyVariableOperand(const int V, const int I)
		{
			bool foundvar = 0;
			WCS_Pointer <Node>		Ptr;
			Ptr = pLastOperator;
			if ((*pRoot).type == -1 && (*pRoot).varval == V)
			{
				(*pRoot).value = I;
				cout << "Set Variable " << V << " To Value " << I << endl;
			}
			else
			{
				while (Ptr)
				{
					if ((*(*Ptr).pRight).varval == V)
					{
						Ptr = (*Ptr).pRight;
						(*Ptr).value = I;
						cout << "Set Variable " << V << " To Value " << I << endl;
						foundvar = 1;
						break;
					}
					else
					{
						Ptr = (*Ptr).pParent;
					}
				}
			}
			if (foundvar == 0)
				cout << "Specified Variable Not Found." << endl;
		}
	};

#endif
