package challenge.apr;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CovidPandemic {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try {
			int t = sc.nextInt();
			for (int i = 0; i < t; i++) {
				boolean check = false;
				int input = 0, index = 0;
				int n = sc.nextInt();
				List<Integer> indices = new ArrayList<>();
				for (int j = 0; j < n; j++) {
					input = sc.nextInt();
					if (input == 1)
						indices.add(index);
					index++;
				}
				check = validateSocialDistancing(indices);
				if (check)
					System.out.println("YES");
				else
					System.out.println("NO");
			}

		} catch (Exception e) {
			return;
		} finally {
			sc.close();
		}

	}

	private static boolean validateSocialDistancing(List<Integer> indices) {
		boolean result = true;
		for (int i = 0; i < indices.size() - 1; i++) {
			if (indices.get(i + 1) - indices.get(i) < 6) {
				result = false;
				break;
			}
		}
		return result;
	}

}
