/*
    Write a program that outputs the string representation of numbers from 1 to n.

    But for multiples of three it should output “Fizz” instead of the number and for 
    the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.

    Link: https://leetcode.com/problems/fizz-buzz/

    Example: 

        n = 15,

            Return:
            [
                "1",
                "2",
                "Fizz",
                "4",
                "Buzz",
                "Fizz",
                "7",
                "8",
                "Fizz",
                "Buzz",
                "11",
                "Fizz",
                "13",
                "14",
                "FizzBuzz"
            ]

    Solution: None

    Source: https://discuss.leetcode.com/topic/74355/java-3ms-solution-with-2-operations
*/

public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList<String>(n);
        boolean r3, r5;
        for (int i = 1; i <= n; i++) {
            r3 = i % 3 == 0;
            r5 = i % 5 == 0;
            if (r3 && r5) {
                ret.add("FizzBuzz");
            } else if (r3) {
                ret.add("Fizz");
            } else if (r5) {
                ret.add("Buzz");
            }   
            else {
                ret.add(String.valueOf(i));
            }      
        }
        return ret;
    }
}