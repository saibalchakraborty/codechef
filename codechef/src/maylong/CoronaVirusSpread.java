package maylong;

import java.util.Scanner;

public class CoronaVirusSpread {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int t = sc.nextInt();
			for (int l = 0; l < t; l++) {
				int n= sc.nextInt();
				int[] arr = new int[n];
				for(int i=0; i<n; i++)
					arr[i] = sc.nextInt();
				int infectedMin = Integer.MAX_VALUE;
				int infectedMax = Integer.MIN_VALUE;
				for(int i=0; i<arr.length; i++) {
					if(infectedMin > getInfectedCount(arr[i], arr, i))
						infectedMin = getInfectedCount(arr[i], arr, i);
					if(infectedMax < getInfectedCount(arr[i], arr, i) )
						infectedMax = getInfectedCount(arr[i], arr, i);
				}
				System.out.println(infectedMin+" "+infectedMax);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		} finally {
			sc.close();
		}
	}
	public static int getInfectedCount(int a, int[] arr, int index) {
		int leftCount = getLeftCount(a, arr, index);
		int rightCount = getRightCount(a, arr, index);
		return leftCount+rightCount+1;
	}
	
	private static int getRightCount(int a, int[] arr, int index) {
		if(index == arr.length-1)
			return 0;
		else {
			if(Math.abs(a-arr[index+1])<=2) {
				return 1+getRightCount(arr[index+1], arr, index+1);
			}
			else
				return 0;
		}
	}
	
	private static int getLeftCount(int a, int[] arr, int index) {
		if (index==0)
			return 0;
		else {
			if(Math.abs(a-arr[index-1])<=2)
				return 1+getLeftCount(arr[index-1], arr, index-1);
			else return 0;
		}
	}
}
