import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		System.out.println(Math.pow(3, 2));
		double total = 0.0;
		ArrayList<Integer> grades = new ArrayList();

		for (int g : grades)
			total += g;
		float f = Math.round(total / grades.size());

	}

}
