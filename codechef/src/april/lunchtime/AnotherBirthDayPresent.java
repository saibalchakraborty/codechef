package april.lunchtime;

import java.util.Scanner;

public class AnotherBirthDayPresent {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int t = sc.nextInt();
			for (int l = 0; l < t; l++) {
				int n = sc.nextInt();
				int k = sc.nextInt();
				long[] arr = new long[n];
				for (int i = 0; i < n; i++) {
					arr[i] = sc.nextInt();
				}
				for (int z = 0; z < n - k;) {
					for (int j = 0; j < k; j++) {
						for (int i = j; i + k < n;) {
							if (arr[i + k] < arr[i]) {
								arr[i] = arr[i] + arr[i + k];
								arr[i + k] = arr[i] - arr[i + k];
								arr[i] = arr[i] - arr[i + k];
							}
							i += k;
						}
					}
					z += k;
				}
				boolean flag = true;
				for (int i = 0; i < n - 1; i++) {
					if (arr[i] > arr[i + 1]) {
						flag = false;
						break;
					}
				}
				if (flag)
					System.out.println("yes");
				else
					System.out.println("no");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		} finally {
			sc.close();
		}
	}

}
