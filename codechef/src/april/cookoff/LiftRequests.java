package april.cookoff;

import java.util.Scanner;

public class LiftRequests {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int t = sc.nextInt();
			long floorTraveled;
			for (int l = 0; l < t; l++) {
				long n = sc.nextInt();
				long request = sc.nextInt();
				floorTraveled = 0;
				long source = 0;
				long temp = 0;
				long dest = 0;
				for (int i = 0; i < request; i++) {
					source = sc.nextInt();
					dest = sc.nextInt();
					if (floorTraveled == 0) {
						floorTraveled += source;
						temp = source;
					}
					if (temp > source) {
						floorTraveled = (dest - source) > 0 ? floorTraveled + (dest - source) + (temp - source)
								: floorTraveled + (source - dest) + (temp - source);
					} else {
						floorTraveled = (dest - source) > 0 ? floorTraveled + (dest - source) + (source - temp)
								: floorTraveled + (source - dest) + (source - temp);
					}
					temp = dest;
				}
				System.out.println(floorTraveled);
			}

		} catch (Exception e) {
			return;
		} finally {
			sc.close();
		}
	}

}
