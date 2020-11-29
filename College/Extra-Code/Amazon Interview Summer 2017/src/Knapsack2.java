import java.util.ArrayList;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class FindMaxWeights {
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public ArrayList<Double> findOptimalWeights(double maxCapacity, int numPallets, double[] wtPallets) {
		int len = wtPallets.length;
		double grid[][] = new double[len][len];
		/* Adds together pairs of Weights */
		/* Got this idea one day from a multiplication table */
		for (int r = 0; r < len; r++) {
			for (int c = 0; c < len; c++) {
				grid[r][c] = wtPallets[r] + wtPallets[c];
			}
		}
		/* Clears using 2 of same object */
		for (int q = 0; q < len; q++) {
			grid[q][q] = 0;
		}
		/*
		 * Finds the optimum minimum value for pallets
		 */
		ArrayList<Double> ar = new ArrayList<>();
		double min = 0;
		for (int r = 0; r < len; r++) {
			for (int c = 0; c < len; c++) {
				if (grid[r][c] > min && grid[r][c] <= maxCapacity) {
					min = grid[r][c];
					ar.clear();
					ar.add(wtPallets[r]);
					ar.add(wtPallets[c]);
				}
			}
		}
		return ar;
	}
	// METHOD SIGNATURE ENDS
}