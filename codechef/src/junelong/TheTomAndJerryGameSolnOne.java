package junelong;

import java.util.Scanner;

public class TheTomAndJerryGameSolnOne {

	//Time limit exceeded
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int t = sc.nextInt();
			for(int l=0; l<t; l++) {
				long tom = sc.nextLong();
				int a = (int) tom % 2;
				long count = 0;
				if(a != 0) {
					count = (tom - 1) / 2;
				}
				else {
					for(long i=2; i< tom; i+=2) {
						if(validate(i, tom) == 1) {
							count++;
						}
					}
				}
				System.out.println(count);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return;
		}
		finally {
			sc.close();
		}
	}

	private static int validate(long i, long tom) {
		if (i % 2 != 0 && tom % 2 != 0) {
			return -1;
		} else if (i % 2 != 0 && tom % 2 == 0) {
			return 0;
		} else if (i % 2 == 0 && tom % 2 != 0) {
			return 1;
		} else if (i % 2 == 0 && tom % 2 == 0) {
			return validate(i / 2, tom / 2);
		}
		return 0;
	}

}
