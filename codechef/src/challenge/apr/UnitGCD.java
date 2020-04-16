package challenge.apr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;


public class UnitGCD {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try {
			int t = sc.nextInt();
			for(int l=0; l<t; l++) {
				int n = sc.nextInt();
				Map<Integer, Boolean> myMap = new ConcurrentHashMap<>();
				List<List<Integer>> result = new ArrayList<>();
				List<Integer> temp = new ArrayList<>();
				temp.add(1);
				for(int i = 1; i<n; i++) {
					if(coprime(temp, i+1)) {
						temp.add(i+1);
					}
					else
						myMap.put(i+1, false);
				}
				result.add(temp);
				while(myMap.containsValue(false)) {
					temp = new ArrayList<>();
					for (int a : myMap.keySet()) {
						if (myMap.get(a) == false) {
							if (coprime(temp, a)) {
								temp.add(a);
								myMap.put(a, true);
							}
						}
					}
					result.add(temp);
				}
				System.out.print(result.size());
				for(List<Integer> lst: result) {
					System.out.println();
					for(int a: lst)
						System.out.print(a+" ");
				}
			}
		}
		catch(Exception e) {
			return;
		}
		finally {
			sc.close();
		}
	}

	private static boolean coprime(List<Integer> temp, int i) {
		if(temp.size() == 0) {
			return true;
		}
		boolean flag = true;
		for(int j: temp) {
			if(gcd(j,i)>1) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	private static int gcd(int j, int i) {
		if (j == 0)
			return i;
		return gcd(i % j, j);
	}
}
