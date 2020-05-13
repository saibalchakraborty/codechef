package challenge.maylong;

import java.util.Arrays;
import java.util.Scanner;

public class IsolationCentersSolnTwo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			long t = sc.nextLong();
			for (int l = 0; l < t; l++) {
				int n = sc.nextInt();
				long q = sc.nextLong();
				String s = sc.next();
				char[] input = s.toCharArray();
				Arrays.sort(input);
				char temp;
				for (int j = 0; j < q; j++) {
					int c = sc.nextInt();
					int emptyQueue = 0;
					for (int i = 0; i < n;) {
						int count = 0;
						temp = input[i];
						while (i<n && input[i] == temp) {
							count++;
							i++;
						}
						if (count > c)
							emptyQueue += (count - c);
					}
					System.out.println(emptyQueue);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		} finally {
			sc.close();
		}

	}

}
