import java.io.File;
import java.util.Scanner;

public class TriggyAngles {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("triggyangles.in"));
		int val = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < val; i++) {
			String s1 = scan.next();
			double num1 = scan.nextDouble();
			String s2 = scan.next();
			double num2 = scan.nextDouble();
			String ang = scan.next();
			// System.out.printf("%.2f\n",num1 + " " + num2);
			if(ang.equals("C")){
				System.out.println("90.00");
			}
			else if (!s1.equals("c") && !s2.equals("c")) {
				if (ang.equals("A")) {
					if (s1.equals("a")) {
						System.out.printf("%.2f\n",
								Math.toDegrees(Math.atan((num1 / num2))));
					}
					if (s1.equals("b")) {
						System.out.printf("%.2f\n",
								Math.toDegrees(Math.atan((num2 / num1))));
					}
				}
				if (ang.equals("B")) {
					if (s1.equals("a")) {
						System.out.printf("%.2f\n",
								Math.toDegrees(Math.atan((num2 / num1))));
					}
					if (s1.equals("b")) {
						System.out.printf("%.2f\n",
								Math.toDegrees(Math.atan((num1 / num2))));
					}
				}
			} else if (s1.equals("a") || s2.equals("a")) {
				if (ang.equals("A")) {
					if (s1.equals("a")) {
						System.out.printf("%.2f\n",
								Math.toDegrees(Math.asin((num1 / num2))));
					}
					if (s1.equals("c")) {
						System.out.printf("%.2f\n",
								Math.toDegrees(Math.asin((num2 / num1))));
					}
				}
				if (ang.equals("B")) {
					if (s1.equals("a")) {
						System.out.printf("%.2f\n",
								Math.toDegrees(Math.acos((num1 / num2))));
					}
					if (s1.equals("c")) {
						System.out.printf("%.2f\n",
								Math.toDegrees(Math.acos((num2 / num1))));
					}
				}
			} else if (s1.equals("b") || s2.equals("b")) {
				if (ang.equals("A")) {
					if (s1.equals("b")) {
						System.out.printf("%.2f\n",
								Math.toDegrees(Math.acos((num1 / num2))));
					}
					if (s1.equals("c")) {
						System.out.printf("%.2f\n",
								Math.toDegrees(Math.acos((num2 / num1))));
					}
				}
				if (ang.equals("B")) {
					if (s1.equals("b")) {
						System.out.printf("%.2f\n",
								Math.toDegrees(Math.asin((num1 / num2))));
					}
					if (s1.equals("c")) {
						System.out.printf("%.2f\n",
								Math.toDegrees(Math.asin((num2 / num1))));
					}
				}
			}
		}
	}
}
