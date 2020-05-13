package codechef.recode;

import java.util.Scanner;

public class ChefAndString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int t = sc.nextInt();
			for(int l=0; l<t; l++) {
				String s = sc.next();
				char cBeg= s.charAt(0);
				char cEnd = s.charAt(s.length()-1);
				String left = myLeftString(s,cBeg);
				String right = myRightString(s,cEnd);
				//System.out.println(left +" "+right);
				if(left.equals(right)) {
					System.out.println("yes");
				}
				else {
					System.out.println("no");
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return;
		}
		finally {
			sc.close();
		}
	}

	private static String myRightString(String s, char cEnd) {
		String t = cEnd+s;
		return t.substring(0, t.length()-1);
	}

	private static String myLeftString(String s, char cBeg) {
		return (s+cBeg).substring(1);
	}
	

}
