public class Solution13 {
	
	/*
	Design an algorithm and write code to remove the duplicate characters in a string
	without using any additional buffer. NOTE: One or two additional variables are fine.
	An extra copy of the array is not.
	*/

	public void removeDuplicates(char[] chars) {
		if (chars == null) {
			return;
		}
		int len = chars.length;
		if (len < 2) {
			return;
		}
		boolean[] hit = new boolean[256];
		for (int i = 0; i < 256; i++) {
			hit[i] = false;
		}
		hit[chars[0]] = true;
		int tail = 1;
		for (int i = 1; i < len; i++) {
			if (!hit[chars[i]]) {
				chars[tail] = chars[i];
				tail++;
				hit[chars[i]] = true;
			}
		}
		chars[tail] = 0;
	}

	public static void main(String[] args) {
		Solution13 sol = new Solution13();
		String inputString = "aaaabbbb";
		char[] chars = inputString.toCharArray();
		sol.removeDuplicates(chars);
		System.out.println(String.valueOf(chars));
	}

}