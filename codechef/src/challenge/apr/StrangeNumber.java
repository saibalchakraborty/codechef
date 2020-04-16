package challenge.apr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StrangeNumber {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try {
			int t = sc.nextInt();
			for (int l = 0; l < t; l++) {
				long x = sc.nextLong();
				long k = sc.nextLong();
				if (checkValidNumberExist(x, k))
					System.out.println(1);
				else
					System.out.println(0);
			}
		} catch (Exception e) {
			return;
		} finally {
			sc.close();
		}
	}

	private static boolean checkValidNumberExist(long x, long k) {
		List<Long> elements = new ArrayList<>();
		elements = calculateFactors(elements, x);
		for(long l:elements)
			System.out.println(l);
		if (elements.size() >= k)
			return true;
		else {
			if (elements.size() == 0 && k == 1) {
				return true;
			} else
				return false;
		}
	}

	private static List<Long> calculateFactors(List<Long> elements, long x) {
		while (x % 2 == 0) {
			elements.add((long) 2);
			x /= 2;
		}
		for (int i = 3; i <= Math.sqrt(x); i += 2) {
			while (x % i == 0) {
				elements.add((long) i);
				x /= i;
			}
		}
		if (x > 2)
			elements.add(x);
		return elements;
	}

}
