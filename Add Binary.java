/*
    Given two binary strings, return their sum (also a binary string).

    Link: https://leetcode.com/problems/add-binary/

    Example: For example,
        a = "11"
        b = "1"
        Return "100".

    Solution: None
    
    Source: None
*/

public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            return "";
        }
        if (b.length() == 0) {
            return a;            
        }
        if (a.length() == 0) {
            return b;
        }
        if (b.length() > a.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int up = 0;
        String rst = "";
        while (bIndex >= 0) {
            int sum = (int)(a.charAt(aIndex) - '0')
                + (int)(b.charAt(bIndex) - '0') + up;
            rst = String.valueOf(sum % 2) + rst;    // maybe StringBuilder will speed up
            up = sum / 2;
            aIndex--;
            bIndex--;
        }
        while (aIndex >= 0) {
            int sum = (int)(a.charAt(aIndex) - '0') + up;
            rst = String.valueOf(sum % 2) + rst;
            up = sum / 2;
            aIndex--;
        }
        if (up == 1) {
            rst = '1' + rst;
        }
        return rst;
    }
}