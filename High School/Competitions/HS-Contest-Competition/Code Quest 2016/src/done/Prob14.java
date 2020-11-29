package done;
import java.io.File;
import java.util.Scanner;

public class Prob14 {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("ExampleInputs\\Prob14.in.txt"));
		int a = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < a; i++) {
			String b = scan.nextLine();
//			System.out.println(b);
			int score = getScore(b);
			System.out.println(score);
			// String c[] = b.split(",");
		}
	}

	public static void Attempt1(String c[]) {
		c[9] += "--";
		int score = 0;
		for (int ii = 0; ii < c.length - 2; ii++) {
			if (c[ii].equals("X")) {
				score += 10; // for the Stike
				if (c[ii + 1].equals("X")) {
					score += 10;
					if (c[ii + 1].equals("X")) {
						score += 10;
					} else {
						score += ((c[ii + 1].charAt(0) != '-' ? c[ii + 1].charAt(0) - '0' : 0));
					}
				} else { // Next Frame bowling
					if (c[ii + 1].contains("/")) {
						score += 10;
					} else {
						score += ((c[ii + 1].charAt(0) != '-' ? c[ii + 1].charAt(0) - '0' : 0)); // First
						score += ((c[ii + 1].charAt(1) != '-' ? c[ii + 1].charAt(1) - '0' : 0)); // Second
					}
				}
				// Mkae sure not the tenth frame
			} else if (c[ii].contains("/")) {
				score += 10; // For the Strike
				if (c[ii + 1].equals("X")) {
					score += 10;
				} else {
					score += ((c[ii + 1].charAt(0) != '-' ? c[ii + 1].charAt(0) - '0' : 0));
				}
			} else { // Are Numbers
				char ch1 = c[ii].charAt(0);
				char ch2 = c[ii].charAt(1);
				if (ch1 != '-') {
					score += ch1 - '0';
				}
				if (ch2 != '-') {
					score += ch2 - '0';
				}
			}
			System.out.println("Frame " + ii + " " + score);
		}
		// Tenth Frame
		System.out.println(score);
	}

	public static int getScore(String line) {
		int score = 0;
		int[] scoreByFrame = new int[10];

		// stripping out gutter balls and replacing with 0 points
		line = line.replaceAll("\\-", "0");

		// break inLine into frames using array data structure
		String[] frames = line.split(",");

		int[] ballsBowled = new int[line.length() - 9];

		int ballIdx = 0;
		// parse the values in each frame into balls bowled
		for (int i = 0; i < line.length(); i++) {
			String frame = String.valueOf(line.charAt(i));
			if (!frame.equals(",")) { // Skipping Commas
				if (frame.equals("X")) {
					ballsBowled[ballIdx] = 10;
				} else if (frame.equals("/")) {
					ballsBowled[ballIdx] = 10 - Integer.parseInt(String.valueOf(line.charAt(i - 1)));
				} else {
					ballsBowled[ballIdx] = Integer.parseInt(String.valueOf(line.charAt(i)));
				}
				ballIdx++;
			}
		}
		// reset for next loop
		ballIdx = 0;
		// loop through 10 frames
		for (int i = 0; i < frames.length; i++) {
			String curFrame = frames[i];
			if (i < 9) {
				if (curFrame.equals("X")) {
					scoreByFrame[i] = ballsBowled[ballIdx] + ballsBowled[ballIdx + 1] + ballsBowled[ballIdx + 2];
					ballIdx += 1;
				} else if (curFrame.contains("/")) {
					scoreByFrame[i] = 10 + ballsBowled[ballIdx + 2];
					ballIdx += 2;
				} else {
					scoreByFrame[i] = ballsBowled[ballIdx] + ballsBowled[ballIdx + 1];
					ballIdx += 2;
				}
			} else {
				// add last frame
				if (curFrame.contains("X")) {
					scoreByFrame[i] = ballsBowled[ballIdx] + ballsBowled[ballIdx + 1] + ballsBowled[ballIdx + 2];
					ballIdx += 1;
				} else if (curFrame.contains("/")) {
					scoreByFrame[i] = 10 + ballsBowled[ballIdx + 2];
					ballIdx += 2;
				} else {
					scoreByFrame[i] = ballsBowled[ballIdx] + ballsBowled[ballIdx + 1];
					ballIdx += 2;
				}
			}
		}
		for (int i = 0; i < 10; i++) {
			score += scoreByFrame[i];
		}
		return score;
	}
}
