public class Solution15 {
	
	/*
	Write a method to replace all spaces in a string with ‘%20’.
	*/

	public void replaceFun(char[] chars, int length) {
		int spaceCount = 0;
		int newLengh = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ' ') {
				spaceCount++;
			}
		}
		newLengh = chars.length + spaceCount * 2;
		for (i = length - 1; i >= 0; i--) {
			if (chars[i] == ' ') {
				chars[newLengh - 1] = '0';
				chars[newLengh - 2] = '2';
				chars[newLengh - 3] = '%';
				newLengh = newLengh - 3;
			} else {
				chars[newLengh - 1] = chars[i];
				newLengh = newLengh - 1;
			}
		}
	}
}