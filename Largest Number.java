/*
    Given a list of non negative integers, arrange them such that they form the largest number.

    Link: https://leetcode.com/problems/largest-number/

    Example: 
    	For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

    Solution: The key process is compare two strings. It is faster than compare two number. We override a comparator 
    of two strings. After that, we filter 0 in the return strings. 
    
    Source: None
*/

public class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, new NumbersComparator());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        String result = sb.toString();
        int index = 0;
        while (index < result.length() && result.charAt(index) == '0') {
            index++;
        }
        if (index == result.length()) {
            return "0";
        }
        return result.substring(index);
    }
}

class NumbersComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return (s2 + s1).compareTo(s1 + s2); // sum to string to get max values
    }
}