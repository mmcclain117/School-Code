import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;

public class Main {
	public static FileWriter writer;

	public static void main(String args[]) throws Exception {
		writer = new FileWriter("Results.txt");
		System.out.println("Load?");
		Scanner scan = new Scanner(System.in);
		double load = scan.nextDouble();
		Open(load);
		Linear(load);
		Quad(load);
		Random(load);
	}

	public static void Open(double a) throws Exception {
		ArrayList<String> store = new ArrayList<>();
		Scanner scan = new Scanner(new File("Large Data Set.txt"));
		for (int i = 0; i < 50000; i++) {
			store.add(scan.nextLine());
		}
		scan.close();
		ArrayList<String> successful = new ArrayList<>();
		Scanner scan2 = new Scanner(new File("Successful Search Records.txt"));
		while (scan2.hasNextLine()) {
			successful.add(scan2.nextLine());
		}
		scan2.close();
		ArrayList<String> unsuccessful = new ArrayList<>();
		Scanner scan3 = new Scanner(new File("Unsuccessful Search Records.txt"));
		while (scan3.hasNextLine()) {
			unsuccessful.add(scan3.nextLine());
		}
		scan3.close();

		int size = (int) ((store.size() / a) + .5);
		HashTable hash = new HashTable(size);
		long startbuild = System.nanoTime();
		for (int i = 0; i < store.size(); i++) {
			String line = store.get(i);
			String[] arr = line.split("\\s+");
			Person person = new Person(arr[0] + " Time: " +arr[1], arr[2], arr[3],
					new ID(arr[4]));
			hash.put(arr[arr.length - 1], person);
		}
		for (String x : store) {
			String[] l = x.split("\\s+");
			hash.get(l[4]);
		}
		long time = System.nanoTime() - startbuild;
		int collisions = hash.getNumOfCollisions();
		int probes = hash.getProbes();
		long untime = System.nanoTime();
		hash.get(13);
		untime = System.nanoTime() - untime;
		int unprobes = hash.getProbes();
		int size2 = (int) ((successful.size() / a) + .5);
		HashTable hash2 = new HashTable(size2);
		long successfultimer = System.nanoTime();
		for (int i = 0; i < successful.size(); i++) {
			String line = successful.get(i);
			String[] arr = line.split("\\s+");
			Person person = new Person(arr[0] + " Time: " +arr[1], arr[2], arr[3],
					new ID(arr[4]));
			hash2.put(arr[4], person);
		}
		for (String x : store) {
			String[] l = x.split("\\s+");
			hash2.get(l[4]);
		}
		long timesuccess = System.nanoTime() - successfultimer;
		int collisions2 = hash2.getNumOfCollisions();
		int probes2 = hash2.getProbes();
		long untime2 = System.nanoTime();
		hash2.get(13);
		untime2 = System.nanoTime() - untime2;
		int unprobes2 = hash.getProbes();
		int size3 = (int) ((unsuccessful.size() / a) + .5);
		HashTable hash3 = new HashTable(size3);
		long unsuccessfultimer = System.nanoTime();
		for (int i = 0; i < unsuccessful.size(); i++) {
			String line = unsuccessful.get(i);
			String[] arr = line.split("\\s+");
			Person person = new Person(arr[0] + " Time: " +arr[1], arr[2], arr[3],
					new ID(arr[4]));
			hash3.put(arr[arr.length - 1], person);
		}
		for (String x : store) {
			String[] l = x.split("\\s+");
			hash3.get(l[4]);
		}
		long timeunsuccess = System.nanoTime() - successfultimer;
		int collisions3 = hash3.getNumOfCollisions();
		int probes3 = hash3.getProbes();
		long untime3 = System.nanoTime();
		hash3.get(13);
		untime3 = System.nanoTime() - untime3;
		int unprobes3 = hash.getProbes();
		double percent = (double) collisions / store.size() * 100;
		double percent2 = (double) collisions2 / successful.size() * 100;
		double percent3 = (double) collisions3 / unsuccessful.size() * 100;
		int averagelistlength = store.size() / (store.size() - collisions);
		int averagelistlength2 = successful.size()
				/ (successful.size() - collisions2);
		int averagelistlength3 = unsuccessful.size()
				/ (unsuccessful.size() - collisions3);
		writer.write("Chaining\n");
		writer.write("Modulus by List Size\n");
		writer.write("Number Of Elements: " + store.size() + "\n");
		writer.write("Size Of Array: " + hash.arr.length + "\n");
		writer.write("Load: " + a + "\n");
		writer.write("Time Build Table " + time + " ns\n");
		writer.write("Time Successful: " + timesuccess + " ns\n");
		writer.write("Time Unsuccessful: " + timeunsuccess + " ns\n");
		writer.write("Collisions 1: " + collisions + "\n");
		writer.write("Collisions Successful: " + collisions2 + "\n");
		writer.write("Collisions Unsuccessful: " + collisions3 + "\n");
		writer.write("Collisions VS Insertion: "
				+ Double.toString(percent).substring(0,4) + "%\n");
		writer.write("Collisions VS Insertion Successful: "
				+ Double.toString(percent2).substring(0,4) + "%\n");
		writer.write("Collisions VS Insertion Unsuccessful: "
				+ Double.toString(percent3).substring(0,4) + "%\n");
		writer.write("Average List Length: " + averagelistlength + "\n");
		writer.write("Average List Length Successful: " + averagelistlength2
				+ "\n");
		writer.write("Average List Length Unsuccessful: " + averagelistlength3
				+ "\n");
		writer.write("Probes 1: " + probes + "\n");
		writer.write("Probes Successful: " + probes2 + "\n");
		writer.write("Probes Unsuccessful: " + probes3 + "\n");
		writer.write("Unprobes 1: " + unprobes + " Time: " +untime + "\n");
		writer.write("Unprobes Successful: " + unprobes2 + " Time: " +untime2 + "\n");
		writer.write("Unprobes Unsuccessful: " + unprobes3 + " Time: " +untime3
				+ "\n");
		writer.write("\n");
	}

	public static void Linear(double a) throws Exception {

		ArrayList<String> store = new ArrayList<>();
		Scanner scan = new Scanner(new File("Large Data Set.txt"));
		for (int i = 0; i < 50000; i++) {
			store.add(scan.nextLine());
		}
		scan.close();
		ArrayList<String> successful = new ArrayList<>();
		Scanner scan2 = new Scanner(new File("Successful Search Records.txt"));
		while (scan2.hasNextLine()) {
			successful.add(scan2.nextLine());
		}
		scan2.close();
		ArrayList<String> unsuccessful = new ArrayList<>();
		Scanner scan3 = new Scanner(new File("Unsuccessful Search Records.txt"));
		while (scan3.hasNextLine()) {
			unsuccessful.add(scan3.nextLine());
		}
		scan3.close();
		int size = (int) ((store.size() / a) + .5);
		Linear hash = new Linear(size);
		long startbuild = System.nanoTime();
		for (int i = 0; i < store.size(); i++) {
			String line = store.get(i);
			String[] arr = line.split("\\s+");
			Person person = new Person(arr[0] + " Time: " +arr[1], arr[2], arr[3],
					new ID(arr[4]));
			hash.put(arr[arr.length - 1], person);
		}
		for (String x : store) {
			String[] l = x.split("\\s+");
			hash.get(l[4]);
		}
		long time = System.nanoTime() - startbuild;
		int collisions = hash.getNumOfCollisions();
		int probes = hash.getProbes();
		long untime = System.nanoTime();
		hash.get(13);
		untime = System.nanoTime() - untime;
		int unprobes = hash.getProbes();
		int size2 = (int) ((successful.size() / a) + .5);
		Linear hash2 = new Linear(size2);
		long successfultimer = System.nanoTime();
		for (int i = 0; i < successful.size(); i++) {
			String line = successful.get(i);
			String[] arr = line.split("\\s+");
			Person person = new Person(arr[0] + " Time: " +arr[1], arr[2], arr[3],
					new ID(arr[4]));
			hash2.put(arr[4], person);
		}
		for (String x : store) {
			String[] l = x.split("\\s+");
			hash2.get(l[4]);
		}
		long timesuccess = System.nanoTime() - successfultimer;
		int collisions2 = hash2.getNumOfCollisions();
		int probes2 = hash2.getProbes();
		long untime2 = System.nanoTime();
		hash2.get(13);
		untime2 = System.nanoTime() - untime2;
		int unprobes2 = hash2.getProbes();
		int size3 = (int) ((unsuccessful.size() / a) + .5);
		Linear hash3 = new Linear(size3);
		long unsuccessfultimer = System.nanoTime();
		for (int i = 0; i < unsuccessful.size(); i++) {
			String line = unsuccessful.get(i);
			String[] arr = line.split("\\s+");
			Person person = new Person(arr[0] + " Time: " +arr[1], arr[2], arr[3],
					new ID(arr[4]));
			hash3.put(arr[arr.length - 1], person);
		}
		for (String x : store) {
			String[] l = x.split("\\s+");
			hash3.get(l[4]);
		}
		long timeunsuccess = System.nanoTime() - successfultimer;
		int collisions3 = hash3.getNumOfCollisions();
		int probes3 = hash3.getProbes();
		long untime3 = System.nanoTime();
		hash3.get(13);
		untime3 = System.nanoTime() - untime3;
		int unprobes3 = hash3.getProbes();
		double percent = (double) collisions / store.size() * 100;
		double percent2 = (double) collisions2 / successful.size() * 100;
		double percent3 = (double) collisions3 / unsuccessful.size() * 100;
		int averagelistlength = store.size() / (store.size() - collisions);
		int averagelistlength2 = successful.size()
				/ (successful.size() - collisions2);
		int averagelistlength3 = unsuccessful.size()
				/ (unsuccessful.size() - collisions3);
		writer.write("Linear\n");
		writer.write("Number Of Elements: " + store.size() + "\n");
		writer.write("Size Of Array: " + hash.arr.length + "\n");
		writer.write("Load: " + a + "\n");
		writer.write("Time Build Table " + time + " ns\n");
		writer.write("Time Successful: " + timesuccess + " ns\n");
		writer.write("Time Unsuccessful: " + timeunsuccess + " ns\n");
		writer.write("Collisions 1: " + collisions + "\n");
		writer.write("Collisions Successful: " + collisions2 + "\n");
		writer.write("Collisions Unsuccessful: " + collisions3 + "\n");
		writer.write("Collisions VS Insertion: "
				+ Double.toString(percent).substring(0,4) + "%\n");
		writer.write("Collisions VS Insertion Successful: "
				+ Double.toString(percent2).substring(0,4) + "%\n");
		writer.write("Collisions VS Insertion Unsuccessful: "
				+ Double.toString(percent3).substring(0,4) + "%\n");
		writer.write("Probes 1: " + probes + "\n");
		writer.write("Probes Successful: " + probes2 + "\n");
		writer.write("Probes Unsuccessful: " + probes3 + "\n");
		writer.write("Unprobes 1: " + unprobes + " Time: " +untime + "\n");
		writer.write("Unprobes Successful: " + unprobes2 + " Time: " +untime2 + "\n");
		writer.write("Unprobes Unsuccessful: " + unprobes3 + " Time: " +untime3
				+ "\n");
		writer.write("\n");
	}

	public static void Quad(double a) throws Exception {

		ArrayList<String> store = new ArrayList<>();
		Scanner scan = new Scanner(new File("Large Data Set.txt"));
		for (int i = 0; i < 50000; i++) {
			store.add(scan.nextLine());
		}
		scan.close();
		ArrayList<String> successful = new ArrayList<>();
		Scanner scan2 = new Scanner(new File("Successful Search Records.txt"));
		while (scan2.hasNextLine()) {
			successful.add(scan2.nextLine());
		}
		scan2.close();
		ArrayList<String> unsuccessful = new ArrayList<>();
		Scanner scan3 = new Scanner(new File("Unsuccessful Search Records.txt"));
		while (scan3.hasNextLine()) {
			unsuccessful.add(scan3.nextLine());
		}
		scan3.close();
		int size = (int) ((store.size() / a) + .5);
		Quad hash = new Quad(size);
		long startbuild = System.nanoTime();
		for (int i = 0; i < store.size(); i++) {
			String line = store.get(i);
			String[] arr = line.split("\\s+");
			Person person = new Person(arr[0] + " Time: " +arr[1], arr[2], arr[3],
					new ID(arr[4]));
			hash.put(arr[arr.length - 1], person);
		}
		for (String x : store) {
			String[] l = x.split("\\s+");
			hash.get(l[4]);
		}
		long time = System.nanoTime() - startbuild;
		int collisions = hash.getNumOfCollisions();
		int probes = hash.getProbes();
		long untime = System.nanoTime();
		hash.get(13);
		untime = System.nanoTime() - untime;
		int unprobes = hash.getProbes();
		int size2 = (int) ((successful.size() / a) + .5);
		Quad hash2 = new Quad(size2);
		long successfultimer = System.nanoTime();
		for (int i = 0; i < successful.size(); i++) {
			String line = successful.get(i);
			String[] arr = line.split("\\s+");
			Person person = new Person(arr[0] + " Time: " +arr[1], arr[2], arr[3],
					new ID(arr[4]));
			hash2.put(arr[4], person);
		}
		for (String x : store) {
			String[] l = x.split("\\s+");
			hash2.get(l[4]);
		}
		long timesuccess = System.nanoTime() - successfultimer;
		int collisions2 = hash2.getNumOfCollisions();
		int probes2 = hash2.getProbes();
		long untime2 = System.nanoTime();
		hash2.get(13);
		untime2 = System.nanoTime() - untime2;
		int unprobes2 = hash2.getProbes();
		int size3 = (int) ((unsuccessful.size() / a) + .5);
		Quad hash3 = new Quad(size3);
		long unsuccessfultimer = System.nanoTime();
		for (int i = 0; i < unsuccessful.size(); i++) {
			String line = unsuccessful.get(i);
			String[] arr = line.split("\\s+");
			Person person = new Person(arr[0] + " Time: " +arr[1], arr[2], arr[3],
					new ID(arr[4]));
			hash3.put(arr[arr.length - 1], person);
		}
		for (String x : store) {
			String[] l = x.split("\\s+");
			hash3.get(l[4]);
		}
		long timeunsuccess = System.nanoTime() - successfultimer;
		int collisions3 = hash3.getNumOfCollisions();
		int probes3 = hash3.getProbes();
		long untime3 = System.nanoTime();
		hash3.get(13);
		untime3 = System.nanoTime() - untime3;
		int unprobes3 = hash3.getProbes();
		double percent = (double) collisions / store.size() * 100;
		double percent2 = (double) collisions2 / successful.size() * 100;
		double percent3 = (double) collisions3 / unsuccessful.size() * 100;
		int averagelistlength = store.size() / (store.size() - collisions);
		int averagelistlength2 = successful.size()
				/ (successful.size() - collisions2);
		int averagelistlength3 = unsuccessful.size()
				/ (unsuccessful.size() - collisions3);
		writer.write("Quadratic\n");
		writer.write("Incrementing by C Squared\n");
		writer.write("Number Of Elements: " + store.size() + "\n");
		writer.write("Size Of Array: " + hash.arr.length + "\n");
		writer.write("Load: " + a + "\n");
		writer.write("Time Build Table " + time + " ns\n");
		writer.write("Time Successful: " + timesuccess + " ns\n");
		writer.write("Time Unsuccessful: " + timeunsuccess + " ns\n");
		writer.write("Collisions 1: " + collisions + "\n");
		writer.write("Collisions Successful: " + collisions2 + "\n");
		writer.write("Collisions Unsuccessful: " + collisions3 + "\n");
		writer.write("Collisions VS Insertion: "
				+ Double.toString(percent).substring(0,4) + "%\n");
		writer.write("Collisions VS Insertion Successful: "
				+ Double.toString(percent2).substring(0,4) + "%\n");
		writer.write("Collisions VS Insertion Unsuccessful: "
				+ Double.toString(percent3).substring(0,4) + "%\n");
		writer.write("Probes 1: " + probes + "\n");
		writer.write("Probes Successful: " + probes2 + "\n");
		writer.write("Probes Unsuccessful: " + probes3 + "\n");
		writer.write("Unprobes 1: " + unprobes + " Time: " +untime + "\n");
		writer.write("Unprobes Successful: " + unprobes2 + " Time: " +untime2 + "\n");
		writer.write("Unprobes Unsuccessful: " + unprobes3 + " Time: " +untime3
				+ "\n");
		writer.write("\n");
	}

	public static void Random(double a) throws Exception {

		ArrayList<String> store = new ArrayList<>();
		Scanner scan = new Scanner(new File("Large Data Set.txt"));
		for (int i = 0; i < 50000; i++) {
			store.add(scan.nextLine());
		}
		scan.close();
		ArrayList<String> successful = new ArrayList<>();
		Scanner scan2 = new Scanner(new File("Successful Search Records.txt"));
		while (scan2.hasNextLine()) {
			successful.add(scan2.nextLine());
		}
		scan2.close();
		ArrayList<String> unsuccessful = new ArrayList<>();
		Scanner scan3 = new Scanner(new File("Unsuccessful Search Records.txt"));
		while (scan3.hasNextLine()) {
			unsuccessful.add(scan3.nextLine());
		}
		scan3.close();
		int size = (int) ((store.size() / a) + .5);
		Rand hash = new Rand(size);
		long startbuild = System.nanoTime();
		for (int i = 0; i < store.size(); i++) {
			String line = store.get(i);
			String[] arr = line.split("\\s+");
			Person person = new Person(arr[0] + " Time: " +arr[1], arr[2], arr[3],
					new ID(arr[4]));
			hash.put(arr[arr.length - 1], person);
		}
		for (String x : store) {
			String[] l = x.split("\\s+");
			hash.get(l[4]);
		}
		long time = System.nanoTime() - startbuild;
		int collisions = hash.getNumOfCollisions();
		int probes = hash.getProbes();
		long untime = System.nanoTime();
		hash.get(13);
		untime = System.nanoTime() - untime;
		int unprobes = hash.getProbes();
		int size2 = (int) ((successful.size() / a) + .5);
		Rand hash2 = new Rand(size2);
		long successfultimer = System.nanoTime();
		for (int i = 0; i < successful.size(); i++) {
			String line = successful.get(i);
			String[] arr = line.split("\\s+");
			Person person = new Person(arr[0] + " Time: " +arr[1], arr[2], arr[3],
					new ID(arr[4]));
			hash2.put(arr[4], person);
		}
		for (String x : store) {
			String[] l = x.split("\\s+");
			hash2.get(l[4]);
		}

		long timesuccess = System.nanoTime() - successfultimer;
		int collisions2 = hash2.getNumOfCollisions();
		int probes2 = hash2.getProbes();
		long untime2 = System.nanoTime();
		hash2.get(13);
		untime2 = System.nanoTime() - untime2;
		int unprobes2 = hash2.getProbes();
		int size3 = (int) ((unsuccessful.size() / a) + .5);
		Rand hash3 = new Rand(size3);
		long unsuccessfultimer = System.nanoTime();
		for (int i = 0; i < unsuccessful.size(); i++) {
			String line = unsuccessful.get(i);
			String[] arr = line.split("\\s+");
			Person person = new Person(arr[0] + " Time: " +arr[1], arr[2], arr[3],
					new ID(arr[4]));
			hash3.put(arr[arr.length - 1], person);
		}
		for (String x : store) {
			String[] l = x.split("\\s+");
			hash3.get(l[4]);
		}
		long timeunsuccess = System.nanoTime() - successfultimer;
		int collisions3 = hash3.getNumOfCollisions();
		int probes3 = hash3.getProbes();
		long untime3 = System.nanoTime();
		hash3.get(13);
		untime3 = System.nanoTime() - untime3;
		int unprobes3 = hash3.getProbes();
		double percent = (double) collisions / store.size() * 100;
		double percent2 = (double) collisions2 / successful.size() * 100;
		double percent3 = (double) collisions3 / unsuccessful.size() * 100;
		int averagelistlength = store.size() / (store.size() - collisions);
		int averagelistlength2 = successful.size()
				/ (successful.size() - collisions2);
		int averagelistlength3 = unsuccessful.size()
				/ (unsuccessful.size() - collisions3);
		writer.write("Random\n");
		writer.write("Random Number Key\n");
		writer.write("Number Of Elements: " + store.size() + "\n");
		writer.write("Size Of Array: " + hash.arr.length + "\n");
		writer.write("Load: " + a + "\n");
		writer.write("Time Build Table " + time + " ns\n");
		writer.write("Time Successful: " + timesuccess + " ns\n");
		writer.write("Time Unsuccessful: " + timeunsuccess + " ns\n");
		writer.write("Collisions 1: " + collisions + "\n");
		writer.write("Collisions Successful: " + collisions2 + "\n");
		writer.write("Collisions Unsuccessful: " + collisions3 + "\n");
		writer.write("Collisions VS Insertion: "
				+ Double.toString(percent).substring(0,4) + "%\n");
		writer.write("Collisions VS Insertion Successful: "
				+ Double.toString(percent2).substring(0,4) + "%\n");
		writer.write("Collisions VS Insertion Unsuccessful: "
				+ Double.toString(percent3).substring(0,4) + "%\n");
		writer.write("Probes 1: " + probes + "\n");
		writer.write("Probes Successful: " + probes2 + "\n");
		writer.write("Probes Unsuccessful: " + probes3 + "\n");
		writer.write("Unprobes 1: " + unprobes + " Time: " +untime + "\n");
		writer.write("Unprobes Successful: " + unprobes2 + " Time: " +untime2 + "\n");
		writer.write("Unprobes Unsuccessful: " + unprobes3 + " Time: " +untime3
				+ "\n");
		writer.flush();
		writer.close();
	}
}