package utilityPackage;

import java.util.Random;

public class TestClass {
	public static void main(String args[]) {
		Random ran = new Random();
		int x = ran.nextInt(100)+1;
		System.out.println(x);
	}

}
