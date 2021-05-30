package maylong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChefAndBitwiseProduct {
	static List<Long> xQueue = new ArrayList<>();
	static List<Long> yQueue = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int t = sc.nextInt();
			for (int p = 0; p < t; p++) {
				long x = sc.nextLong();
				long y = sc.nextLong();
				long l = sc.nextLong();
				long r = sc.nextLong();
				xQueue = binaryRepresentation(x);
				yQueue = binaryRepresentation(y);
				List<Long> temp = new ArrayList<Long>();
				long result = 0;
				long value, z = Long.MIN_VALUE;
				for (long k = l; k <= r; k++) {
					temp = binaryRepresentation(k);
					value = calculateProduct(temp);
					System.out.println(value);
					if (value > z) {
						z = value;
						result = k;
					}
				}
				System.out.println(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		} finally {
			sc.close();
		}
	}

	private static long calculateProduct(List<Long> temp) {
		return calculateAnd(xQueue, temp) * calculateAnd(yQueue, temp);
	}

	private static int calculateAnd(List<Long> a, List<Long> temp) {
		if (a.size() > temp.size()) {
			for (int i = temp.size(); i < a.size(); i++)
				temp.add((long) 0);
		} else if (a.size() < temp.size()) {
			for (int i = a.size(); i < temp.size(); i++) {
				a.add((long) 0);
			}
		}
		int result = 0;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) != 0 && (a.get(i) == temp.get(i))) {
				result += a.get(i) * Math.pow(2, i);
			}
		}
		return result;
	}

	private static List<Long> binaryRepresentation(long x) {
		List<Long> temp = new ArrayList<Long>();
		while (x / 2 >= 1) {
			temp.add(x % 2);
			x = x / 2;
		}
		temp.add(x);
		return temp;
	}
}