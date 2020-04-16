package challenge.jan;

import java.util.Arrays;
import java.util.Scanner;

public class Equality {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int length=sc.nextInt();
			int queries=sc.nextInt();
			int[] a=new int[length];
			for(int i=0;i<length;i++) {
				a[i]=sc.nextInt();
			}
			int l,r,countMax, countMin, p=0, q;
			Equality eq=new Equality();
			for(int k=0;k<queries;k++) {
				countMax=0;
				countMin=0;
				l=sc.nextInt();
				r=sc.nextInt();
				for (int i = l - 1; i < r - 1; i++) {
					for (int j = i+2; j <= (r - 1 + 1); j++) {
						int[] check = Arrays.copyOfRange(a, i, j);
						p = i;
						q = i + j - 1;
						print(check);
						System.out.println("\np : " + p + " q : " + q);
						boolean result[] = eq.checkValidity(a, check, l - 1, r - 1, p, q);
						if (result[0] == true)
							countMax++;
						if (result[1] == true)
							countMin++;
					}
				}
				if(countMax==countMin) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
		}
		catch(Exception e) {
			sc.close();
			return;
		}
		sc.close();
	}

	private static void print(int[] check) {
		for(int i:check) {
			System.out.print(i+" ");
		}
	}

	//Checks if the current list is valid or not
	private boolean[] checkValidity(int[] a, int[] check, int l, int r, int p, int q) {
		boolean[] result = new boolean[2];
		result[0]=true;
		result[1]=true;
		for(int i=0;i<check.length;i++) {
			if(i==(check.length-1))
				break;
			if(check[i]<check[i+1])
				result[1] = false;
			if(check[i]>check[i+1])
				result[0] = false;
		}
		if(p>l) {
			if(a[p]<=a[p-1])
				result[1] = false;
			if(a[p]>=a[p-1])
				result[0] = false;
		}
		if(q<r) {
			if(a[q]>=a[q+1])
				result[1] = false;
			if(a[q]<=a[q+1])
				result[0] = false;
		}
		return result;
	}

}