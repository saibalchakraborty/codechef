package challenge.jan;

import java.math.BigInteger;
import java.util.Scanner;

public class ChefAndDynamo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int t = sc.nextInt();
			int n, a, s, b, c, d, e, temp, result;
			for (int i = 0; i < t; i++) {
				n = sc.nextInt();
				if (n <= 5) {
					a = sc.nextInt();
					temp = (int) (Math.pow(10, n));
					s = (temp * 2) + a;
					System.out.println(s);
					System.out.flush();
					b = sc.nextInt();
					c = temp - b;
					System.out.println(c);
					System.out.flush();
					d = sc.nextInt();
					e = temp - d;
					System.out.println(e);
					System.out.flush();
					result = sc.nextInt();
					if (result == 1) {

					} else if (result == -1) {
						return;
					}

				} else {
					BigInteger ba = new BigInteger(sc.next());
					BigInteger btemp = new BigInteger("1");
					BigInteger bmult = new BigInteger("10");
					for (int j = 0; j < n; j++) {
						btemp = btemp.multiply(bmult);
					}
					BigInteger sum = btemp.add(btemp);
					sum = sum.add(ba);
					System.out.println(sum.toString());
					System.out.flush();
					BigInteger bb = new BigInteger(sc.next());
					System.out.println(btemp.subtract(bb));
					System.out.flush();
					BigInteger bc = new BigInteger(sc.next());
					System.out.println(btemp.subtract(bc));
					System.out.flush();
					result = sc.nextInt();
					if (result == 1) {

					} else if (result == -1) {
						return;
					}
				}
			}
		} catch (Exception e) {
			sc.close();
			return;
		}
		sc.close();
	}
}
