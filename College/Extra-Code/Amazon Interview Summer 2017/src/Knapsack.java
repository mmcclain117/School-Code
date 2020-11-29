/* A Naive recursive implementation of 0-1 Knapsack problem */
class Knapsack {

	// A utility function that returns maximum of two integers
	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	// Returns the maximum value that can be put in a knapsack of capacity W
	static int knapSack(int W, int wt[], int numPallets) {
		if (numPallets == 0 || W == 0)
			return 0;
		// Over capacity
		if (wt[numPallets - 1] > W)
			return knapSack(W, wt, numPallets - 1);
		else
			return max(wt[numPallets - 1] + knapSack(W - wt[numPallets - 1], wt, numPallets - 1), knapSack(W, wt,  numPallets - 1));
	}

	// Driver program to test above function
	public static void main(String args[]) {
		int val[] = new int[] { 60, 100, 120 , 20, 110};
		int wt[] = new int[] { 10, 20, 29, 10};
		int W = 50;
		int n = wt.length;
		System.out.println(knapSack(W, wt, n));
	}
}