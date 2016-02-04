/*
    Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
    If the fractional part is repeating, enclose the repeating part in parentheses.

    Link: https://leetcode.com/problems/fraction-to-recurring-decimal/

    Example: For example,
		Given numerator = 1, denominator = 2, return "0.5".
		Given numerator = 2, denominator = 1, return "2".
		Given numerator = 2, denominator = 3, return "0.(6)".

    Solution: The main point is that how to consider of repeat digits. What is more, we transform int to long to avoid
    missing digits problem. We use a map to trace digit repeat situation. If it contains old repeat digits, we assume
    that we meet '()' problem.
    
    Source: https://leetcode.com/discuss/50512/accepted-clean-java-solution
*/

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean isNegative = (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) ? true : false;
        long numeratorL = Math.abs((long) numerator);
        long denominatorL = Math.abs((long) denominator);
        Map<Long, Integer> previousRemains = new HashMap<Long, Integer>();
        StringBuilder sb = new StringBuilder();
        long quotian = numeratorL / denominatorL;
        sb.append(quotian);

        numeratorL %= denominatorL;

        if (numeratorL != 0) {
            sb.append(".");
        }

        int quotianIndex = 0;
        while (numeratorL != 0) {
            numeratorL *= 10;
            quotian = Math.abs(numeratorL / denominatorL);
            if (!previousRemains.containsKey(numeratorL)) {
                sb.append(quotian);
                previousRemains.put(numeratorL, quotianIndex++);
            } else {
                int firstIndex = 1 + previousRemains.get(numeratorL) + sb.indexOf(".");
                sb.insert(firstIndex, '(');
                sb.append(")");
                break;
            }
            numeratorL %= denominatorL;
        }

        if (isNegative) {
            sb.insert(0, "-");
        }
        return sb.toString();
    }
}