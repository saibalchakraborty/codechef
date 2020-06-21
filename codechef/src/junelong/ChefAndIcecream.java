package challenge.junelong;

import java.util.Scanner;

public class ChefAndIcecream {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int t = sc.nextInt();
			for (int l = 0; l < t; l++) {
				int n = sc.nextInt();
				int input;
				int five = 0, ten = 0;
				boolean result = true;
				for (int i = 0; i < n; i++) {
					input = sc.nextInt();
					switch (input) {
					case 5:
						five++;
						break;
					case 10:
						ten++;
						if (five > 0)
							five--;
						else
							result = false;
						break;
					case 15:
						if (ten > 0)
							ten--;
						else {
							if (five > 1)
								five -= 2;
							else
								result = false;
						}
						break;
					default:
						throw new Exception();
					}
				}
				if (result)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		} finally {
			sc.close();
		}
	}
}
