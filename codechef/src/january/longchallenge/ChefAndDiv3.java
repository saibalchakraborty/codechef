package january.longchallenge;

import java.util.Scanner;

public class ChefAndDiv3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try {
			int t = sc.nextInt();
			for (int i = 0; i < t; i++) {
				int n = sc.nextInt();
				long k = sc.nextLong();
				long d = sc.nextLong();
				long sum = 0;
				for (int j = 0; j < n; j++) {
					sum = sum + sc.nextLong();
				}
				long finalDays = sum / k;
				System.out.println((finalDays < d) ? finalDays : d);
			}
		} catch (Exception e) {
			return;
		} finally {
			sc.close();
		}
	}

}
