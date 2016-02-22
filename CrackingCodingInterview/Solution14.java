public class Solution14 {
	
	/*
	Write a method to decide if two strings are anagrams or not.
	*/

	public boolean anagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] letters = new int[256];
		int num_unique_chars = 0;
		int num_complete_t = 0;
		char[] s_array = s.toCharArray();
		for (char c : s_array) {
			if (letters[c] == 0) {
				num_unique_chars++;
			}
			letters[c]++;
		}
		for (int i = 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
			if (letters[c] == 0) {
				return false;
			}
			letters[c]--;
			if (letters[c] == 0) {
				num_complete_t++;
				if (num_unique_chars == num_complete_t) {
					return i == t.length() - 1;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Solution14 sol = new Solution14();
		String s = "aaaabbbb";
		String t = "bbbaaaba";
		System.out.println(sol.anagram(s, t));
	}

}