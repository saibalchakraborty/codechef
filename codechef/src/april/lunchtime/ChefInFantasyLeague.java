package april.lunchtime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ChefInFantasyLeague {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int t = sc.nextInt();
			for (int l = 0; l < t; l++) {
				int playerCount = sc.nextInt();
				int spent = sc.nextInt();
				int[] cost = new int[playerCount];
				for (int i = 0; i < playerCount; i++) {
					cost[i] = sc.nextInt();
				}
				List<Integer> deffender = new ArrayList<>();
				List<Integer> attacker = new ArrayList<>();
				for (int i = 0; i < playerCount; i++) {
					int pos = sc.nextInt();
					if (pos == 0) {
						deffender.add(cost[i]);
					} else if (pos == 1) {
						attacker.add(cost[i]);
					}
				}
				Collections.sort(attacker);
				Collections.sort(deffender);
				if (attacker.size() == 0 || deffender.size() == 0) {
					System.out.println("no");
				} else if ((attacker.get(0) + deffender.get(0)) <= (100 - spent)) {
					System.out.println("yes");
				} else {
					System.out.println("no");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		} finally {
			sc.close();
		}
	}

}