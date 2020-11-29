#include<iostream>
#include<queue>

using namespace std;
int main() {

	int a[] = { 42,68,35,1,70,25,79,59,63,65,6,46,82,28,62,92,96,43,28,37,92,5,3,54,93 };
	int n = 25;
	int sum = a[0];
	queue<int> q1; // For number
	q1.push(a[0]);
	int t = 0; // Temp number
	for (int i = 1; i < n; i++) {
		int si = q1.size();
		for (int j = 0; j < si; j++) {
			int tmp = q1.front();
			q1.pop();
//			if (tmp != 0) {
				q1.push(tmp & a[i]);
	//		}
			q1.push(tmp^a[i]);
		}
		cout <<i << " "  << q1.size() << endl;
	}
	int max = 0;
	for (int i = 0; i < q1.size(); i++) {
		int y = q1.front();
		q1.pop();
		if (y > max) {
			max = y;
			cout << max << endl;
		}
	}
	cout << max << endl;
	system("PAUSE");
	return 0;
}