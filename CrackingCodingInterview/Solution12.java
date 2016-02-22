public class Solution12 {

	/*
	Write code to reverse a C-Style String. (C-String means that “abcd” is represented as
	five characters, including the null character.)
	*/

	private void reverse(char[] chars) {
		int start = 0;
		int end = chars.length - 1;
		while (start < end) {
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start++;
			end--; 
		}

	}

	public static void main(String[] args) {
		Solution12 sol = new Solution12();
		String inputString = "acedfghijklmnopqxstuvwxyza";
		char[] chars = inputString.toCharArray();
		sol.reverse(chars);
		System.out.println(String.valueOf(chars));

	}
}