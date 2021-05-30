package junelong;

import java.util.Scanner;

public class ChefAndPriceControl {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try {
			int t = sc.nextInt();
			for (int l = 0; l < t; l++) {
				long n = sc.nextLong();
				long k = sc.nextLong();
				long input = 0, loss = 0;
				for (int i = 0; i < n; i++) {
					input = sc.nextLong();
					if (input > k) {
						loss += (input - k);
					}
				}
				System.out.println(loss);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		} finally {
			sc.close();
		}
	}

}
