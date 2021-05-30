package junelong;

import java.util.Scanner;

public class ChefAndString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = null;
		try {
			int t = sc.nextInt();
			for (int l = 0; l < t; l++) {
				s = sc.next();
				char[] input = s.toCharArray();
				char c;
				int count = 0;
				for (int i = 0; i < input.length - 1;) {
					c = input[i];
					if (c == 'x') {
						if (input[i + 1] == 'y') {
							count++;
							i += 2;
						} else
							i++;
					} else if (c == 'y') {
						if (input[i + 1] == 'x') {
							count++;
							i += 2;
						} else
							i++;
					} else
						throw new Exception();
				}
				System.out.println(count);
				s = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		} finally {
			sc.close();
		}
	}

}
