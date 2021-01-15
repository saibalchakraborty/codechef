package january.longchallenge;

import java.util.Scanner;

public class EncodedString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			short t = sc.nextShort();
			for (short i = 0; i < t; i++) {
				long l = sc.nextLong();
				String s = sc.next();
				StringBuilder sb = new StringBuilder();
				int index = 0;
				while (index <= (l - 4)) {
					sb.append(characterValue(s.substring(index, index + 4)));
					index += 4;
				}
				System.out.println(sb.toString());
			}
		} catch (Exception e) {
			return;
		} finally {
			sc.close();
		}
	}

	private static String characterValue(String input) {
		String encoder = "abcdefghijklmnop";
		for(char c : input.toCharArray()) {
			if(c == '0') {
				encoder = encoder.substring(0, encoder.length()/2);
			}
			else {
				encoder = encoder.substring(encoder.length()/2, encoder.length());
			}
		}
		return encoder;
	}

}
