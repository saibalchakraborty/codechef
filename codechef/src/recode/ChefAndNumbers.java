package recode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChefAndNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int t = sc.nextInt();
			for (int l = 0; l < t; l++) {
				int n = sc.nextInt();
				int[] arr = new int[n];
				for (int i = 0; i < n; i++)
					arr[i] = sc.nextInt();
				Map<Integer, Integer> result = new HashMap<>();
				int temp = 0;
				for (int i = 0; i < arr.length; i++) {
					int count = 1;
					int previous=0, next=0;
					temp = arr[i];
					if (result.keySet().contains(temp))
						continue;
					else {
						previous = i;
						next = i;
						for(int j=i+1; j<arr.length; j++) {
							 if(arr[j] == temp) {
								 next = j;
								if (next - previous > 1) {
									count++;
									previous = j;
								}
							 }
						}
						result.put(temp, count);
					}
				}
				System.out.println(answer(result));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		} finally {
			sc.close();
		}
	}

	private static int answer(Map<Integer, Integer> result) {
		int max = 0;
		for(int i:result.values()) {
			if(i>max)
				max=i;
		}
		int min = Integer.MAX_VALUE;
		for(int i:result.keySet()) {
			if(result.get(i).equals(max)) {
				if(i < min)
					min =i;
			}
		}
		return min;
	}

}
