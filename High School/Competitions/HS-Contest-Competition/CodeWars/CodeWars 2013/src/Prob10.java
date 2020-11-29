
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Master Ward
 */
public class Prob10 {

    public static void main(String[] args) throws Exception {
//        Problem: A Weighty Problem
//        Points: 5
        Scanner scan = new Scanner(new File("prob10.txt"));
        String a = scan.nextLine();
        while (!"0 0 0 0 0 0 0 0 0 0".equals(a)) {
            String b[] = a.split("\\s");
//            double a1 = Double.parseDouble(b[0]);
            int db[] = intify(b); // Values of scale weight in
            int weights[] = new int[5]; // Weights of 5 kids
            Arrays.sort(db);
            int sum = 0; // Total Amount
//            System.out.println(Arrays.toString(db));
            for (int i = 0; i < db.length; i++) {
                sum += db[i];
            }
            sum /= 4;
            /* Assign weights based on sum */
            weights[2] = sum - db[0] - db[9];
            weights[4] = db[8] - weights[2];
            weights[0] = db[1] - weights[2];
            weights[1] = db[0] - weights[0];
            weights[3] = db[9] - weights[4];
            /* Print weight of kids */
            for (int i = 0; i < weights.length; i++) {
                System.out.print(weights[i] + " ");
            }
            System.out.println();
            a = scan.nextLine();
        }
    }

    /* Turns String array into Double Array */
    private static int[] intify(String a[]) {
        int x[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            x[i] = Integer.parseInt(a[i]);
        }
        return x;
    }
}
//int sums[10];
//   int weights[5];
//   int i,j,k, tmp;
//   int fullSum;
//
//   cout << "Enter ten paired sums (all zeros to end.)" << endl;
//
//	cin >> sums[0];
//
//	while (sums[0]!=0)
//	{	  
//		for (i=1;i<10;i++)
//		{
//			cin >> tmp;
//			// Add to array in a sorted method
//			for (j=0;j<i;j++)
//			{
//				if (tmp < sums[j])
//				{
//					for (k=i;k>j;k--)
//						sums[k]=sums[k-1];
//					break; // Stop the j-loop
//				}
//			}
//			sums[j]=tmp;
//		}
////		for (i=0;i<10;i++) cout << sums[i] <<" ";
//		for (fullSum=0, i=0; i<10;i++)
//			fullSum+=sums[i];
//		fullSum = fullSum/4;
//		weights[2] = fullSum - sums[0] - sums[9];
//		weights[4] = sums[8] - weights[2];
//		weights[0] = sums[1] - weights[2];
//		weights[1] = sums[0] - weights[0];
//		weights[3] = sums[9] - weights[4];
//		for (i=0;i<5;i++) cout << weights[i] << " ";
//		cout << endl;
//
//		cin >> sums[0]; // Read first element of next line
//    }	
//}
