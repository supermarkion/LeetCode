/*
    Given two numbers represented as strings, return multiplication of the numbers as a string.


    Link: https://leetcode.com/problems/multiply-strings/

    Example: None

    Solution: None
    
    Source: https://leetcode.com/discuss/80283/java-4ms-beats-99%25
*/

public class Solution {
    public String multiply(String num1, String num2) {
        int length1 = num1.length();
        int[] nOne = new int[length1];
        for(int i = 0; i < length1; i++){
            nOne[i]= num1.charAt(i) - '0';
        }
        int length2 = num2.length();
        int[] nTwo = new int[length2];
        for(int i = 0; i < length2; i++){
            nTwo[i]= num2.charAt(i) - '0';
        }
        int[] res = new int[length1 + length2];
        int base = length1 + length2 - 1;
        for(int i = length2 - 1; i >= 0; i--){
            int mark = base;
            for(int j = length1 - 1; j >= 0; j--){
                res[mark] = nOne[j] * nTwo[i] + res[mark];
                mark--;
            }
            base--;
        }
        for(int i = length1 + length2 - 1; i > 0; i--){
            if(res[i] > 9) {
            int temp = res[i];
            res[i] = temp % 10;
            res[i - 1] += temp / 10;
            }
        }
        char[] tempRes = new char[length1 + length2];
        for(int i = 0; i < length1 + length2; i++) tempRes[i] = (char)(res[i] + 48);
    
        StringBuffer s = new StringBuffer(new String(tempRes));
        while (s.charAt(0) == '0' && s.length() > 1) s.deleteCharAt(0);
        return s.toString();
    }
}