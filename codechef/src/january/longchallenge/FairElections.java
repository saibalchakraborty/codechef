package january.longchallenge;

import java.util.Arrays;
import java.util.Scanner;

public class FairElections {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try {
			int t = sc.nextInt();
			for (int i = 0; i < t; i++) {
				int n = sc.nextInt();
				int m = sc.nextInt();
				long[] johnVotes = new long[n];
				long[] jackVotes = new long[m];
				for (int k = 0; k < n; k++) {
					johnVotes[k] = sc.nextLong();
				}
				for (int k = 0; k < m; k++) {
					jackVotes[k] = sc.nextLong();
				}
				System.out.println(calculateMinimumShuffle(johnVotes, jackVotes));
			}
		} catch (Exception e) {
			return;
		} finally {
			sc.close();
		}
	}

	private static long calculateMinimumShuffle(long[] johnVotes, long[] jackVotes) {
		Arrays.sort(johnVotes);
		Arrays.sort(jackVotes);
		if (johnVotes.length < jackVotes.length) {
			return minimumShuffles(johnVotes, jackVotes, johnVotes.length);
		} else if ((jackVotes.length < johnVotes.length) || (jackVotes.length == johnVotes.length)) {
			return minimumShuffles(johnVotes, jackVotes, jackVotes.length);
		}
		return -1;
	}

	private static long minimumShuffles(long[] johnVotes, long[] jackVotes, int length) {
		long temp = 0;
		if (totalVotes(johnVotes) > totalVotes(jackVotes)) {
			return 0;
		}
		for (int i = 0; i < length; i++) {
			temp = johnVotes[i];
			johnVotes[i] = jackVotes[jackVotes.length - (i + 1)];
			jackVotes[jackVotes.length - (i + 1)] = temp;
			long sumJohnVotes = totalVotes(johnVotes);
			long sumJackVotes = totalVotes(jackVotes);
			if (sumJohnVotes > sumJackVotes) {
				return i + 1;
			}
		}
		return -1;
	}

	private static long totalVotes(long[] votes) {
		long sum = 0;
		for (long l : votes) {
			sum += l;
		}
		return sum;
	}

}
