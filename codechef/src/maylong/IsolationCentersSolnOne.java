package maylong;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IsolationCentersSolnOne {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try {
			long t = sc.nextLong();
			for (int l = 0; l < t; l++) {
				int n = sc.nextInt();
				long q = sc.nextLong();
				String s = sc.next();
				char[] input = s.toCharArray();
				Map<Character, Long> inputMap= new HashMap<>();
				for(int i=0; i<n; i++) {
					if(inputMap.containsKey(input[i])) {
						long value = inputMap.get(input[i]);
						inputMap.put(input[i], value+1);
					}
					else
						inputMap.put(input[i], (long) 1);
				}
				for (int j = 0; j < q; j++) {
					long c = sc.nextInt();
					long count = 0;
					for (Character myChar : inputMap.keySet()) {
						if (inputMap.get(myChar) > c) {
							count+=(inputMap.get(myChar)-c);
						}
					}
					System.out.println(count);
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
