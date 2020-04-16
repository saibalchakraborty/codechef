package challenge.apr;

import java.util.Arrays;
import java.util.Scanner;

public class SellAllTheCars {

	private static long div = 1000000007;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try {
			int t = sc.nextInt();
			int n = 0;
			for (int i = 0; i < t; i++) {
				n = sc.nextInt();
				long[] cost = new long[n];
				for (int j = 0; j < n; j++)
					cost[j] = sc.nextInt();
				System.out.println("Cost is " + calculateCost(cost));
			}
		} catch (Exception e) {
			return;
		} finally {
			sc.close();
		}
	}

	private static long calculateCost(long[] cost) {

		Arrays.sort(cost);
		long sum = 0;
		long count = 0;
		for (int i = cost.length - 1; i >= 0; i--) {
			if ((cost[i] - count) > 0) {
				sum = (sum + (cost[i] - count)) % div;
			}
			count++;
		}

		return sum;
	}

}
