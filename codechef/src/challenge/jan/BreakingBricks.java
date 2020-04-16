package challenge.jan;

import java.util.Scanner;

public class BreakingBricks {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int t = sc.nextInt();
			int[] result=new int[t];
			int s, w1, w2, w3;
			for (int i = 0; i < t; i++) {
				s = sc.nextInt();
				w1 = sc.nextInt();
				w2 = sc.nextInt();
				w3 = sc.nextInt();
				if((s<w1)&&(s<w2)&&(s<w3))
					return;
				if (s >= (w1 + w2 + w3)) {
					result[i]=1;
				}
				else {
					if((s>=w1)&&(s>=w3)) {
						if(s>=(w1+w2)) {
							result[i]=2;
						}
						else if(s>=(w2+w3)) {
							result[i]=2;
						}
						else {
							result[i]=3;
						}
					}
				}
			}
			for(int i:result)
				System.out.println(i);
		} catch (Exception e) {
			sc.close();
			return;
		}
		sc.close();
	}

}
