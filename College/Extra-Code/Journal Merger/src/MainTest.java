import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {

	/* Testing it gets through the program */
//	 @Test
	void test() {
		Main test1 = new Main();
		String filename = "C:\\Users\\maste\\Dropbox\\Secret\\Finish\\April 2, 2018";
		boolean x = test1.main(filename) != -1;
		assertEquals(true, x);

	}

	/* Goind through 2 layers */
//	 @Test
	void subDir() {
		Main test2 = new Main();
		String filename = "C:\\Users\\maste\\Dropbox\\Secret\\Finish";
		assertEquals(4, test2.main(filename));
	}

//	 @Test
	void subSubDir() {
		Main test3 = new Main();
		String filename = "C:\\Users\\maste\\Dropbox\\Secret";
		assertEquals(10, test3.main(filename));
	}

//	 @Test
	void testSelSort() {
		Main test4 = new Main();
		int arr[] = { 64, 25, 12, 22, 11 };
		int a[] = { 1, 4, 2, 56, 73, 23, 88, 52, 12, 3, 4, 2, 1, 0 };
		test4.SelectionSort(a);
		test4.SelectionSort(arr);
	}

	// @Test
	void testCal() {
		Main test5 = new Main();
		test5.testCal();
	}

//	@Test
	void test2018() {
		Main test6 = new Main();
		String filename = "C:\\Users\\maste\\Desktop\\Test Files\\2018";
		System.out.println(test6.main(filename));
		boolean x = test6.main(filename) != -1;
		assertEquals(true, x);

	}

	@Test
	void test2s() {
		Main test7 = new Main();
		String filename = "C:\\Users\\maste\\Desktop\\Test Files\\2015";
		System.out.println(test7.main(filename));
		boolean x = test7.main(filename) != -1;
		assertEquals(true, x);
	}

//	@Test
	void testMEGA() {
		Main test8 = new Main();
		String filename = "C:\\Users\\maste\\Desktop\\Test Files";
		System.out.println(test8.main(filename));
		boolean x = test8.main(filename) != -1;
		assertEquals(true, x);
	}
}
