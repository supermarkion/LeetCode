public class Solution11 {

	/*
	Implement an algorithm to determine if a string has all unique characters. 
	What if you can not use additional data structures?
	*/

	private boolean isUniqueChars(String inputString) {
		if (inputString.length() > 256) {
			return false;			// if size is too long, we must meet duplicate
		}
		boolean[] chars = new boolean[256];
		for (int i = 0; i < inputString.length(); i++) {
			int val = inputString.charAt(i);
			if (chars[i]) {
				return false;
			} else {
				chars[i] = true;	// we already meet this char
			}
		}
		return true;
	}


	public static void main(String[] args) {
		Solution11 sol = new Solution11();
		String inputString = "acedfghijklmnopqxstuvwxyza";
		boolean result = sol.isUniqueChars(inputString);
		if (result) {
			System.out.println("Find duplicate char");
		} else {
			System.out.println("No duplicate char");
		}
	}

}