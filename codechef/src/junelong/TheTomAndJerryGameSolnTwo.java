package junelong;

import java.util.Scanner;

public class TheTomAndJerryGameSolnTwo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			long t = sc.nextLong();
			for (long l = 0; l < t; l++) {
				long tom = sc.nextLong();
				long count = 0;
				if (tom % 2 != 0) {
					count = (tom - 1) / 2;
				} else {
					long power = 1, temp = tom;
					while (temp % 2 == 0) {
						power *= 2;
						temp = temp / 2;
					}
					count = (tom - 1) / (power * 2);
				}
				System.out.println(count);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		} finally {
			sc.close();
		}
	}

}
