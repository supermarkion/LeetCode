/*
    A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:

	For 1-byte character, the first bit is a 0, followed by its unicode code.
	For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed by n-1 bytes with most significant 2 bits being 10.
	This is how the UTF-8 encoding would work:

	   Char. number range  |        UTF-8 octet sequence
	      (hexadecimal)    |              (binary)
	   --------------------+---------------------------------------------
	   0000 0000-0000 007F | 0xxxxxxx
	   0000 0080-0000 07FF | 110xxxxx 10xxxxxx
	   0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
	   0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
	Given an array of integers representing the data, return whether it is a valid utf-8 encoding.

	Note:
	The input is an array of integers. Only the least significant 8 bits of each integer is used to store the data. This means each integer represents only 1 byte of data.

    Link: https://leetcode.com/problems/utf-8-validation/

    Example: 
		Example 1:
		data = [197, 130, 1], which represents the octet sequence: 11000101 10000010 00000001.
		Return true.
		It is a valid utf-8 encoding for a 2-bytes character followed by a 1-byte character.

		Example 2:
		data = [235, 140, 4], which represented the octet sequence: 11101011 10001100 00000100.
		Return false.
		The first 3 bits are all one's and the 4th bit is 0 means it is a 3-bytes character.
		The next byte is a continuation byte which starts with 10 and that's correct.
		But the second continuation byte does not start with 10, so it is invalid.

    Source: https://discuss.leetcode.com/topic/57787/my-java-solution
*/

public class Solution {
    public boolean validUtf8(int[] data) 
    {
        for (int i = 0; i < data.length; ++i)
        {
            String s = transfer(data[i]);
            if (s.charAt(0) == '0')
           	{
           		continue;
            }
            else
            {
                int count = 0;
                while (s.charAt(count) =='1')
                {
                    count++;
                    if (count > 4)
                    {
                    	return false;
                    }
                }
                if (count == 1)
                {
                	return false;
                }
                count--;
                int j = i + count;
                while (count > 0)
                {
                    if (i + count >= data.length)
                    {
                    	return false;
                    }
                    String tmp = transfer(data[i + count]);
                    if (tmp.charAt(0) == '1' && tmp.charAt(1) == '0')
                    {
                        count--;
                        continue;
                    }
                    else
                    {
                    	return false;
                    }
                }
                i = j;
                
            }
        }
        return true;
    }
    public String transfer(int num)
    {
        String res = "";
        int i = 1;
        int count = 8;
        while (count --> 0)
        {
            if ((num&i) == 0)
            {
            	res = '0' + res; 
            }
            else 
            {
            	res = '1' + res;
            }
            i = i<< 1;
        }
        return res;
    }
}