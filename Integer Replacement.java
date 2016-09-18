/*
    Given a positive integer n and you can do operations as follow:
		If n is even, replace n with n/2.
		If n is odd, you can replace n with either n + 1 or n - 1.
		What is the minimum number of replacements needed for n to become 1?

    Link: https://leetcode.com/problems/integer-replacement/

    Example: 
		Example 1:
			Input:
			8
			Output:
			3
			Explanation:
			8 -> 4 -> 2 -> 1

		Example 2:
			Input:
			7
			Output:
			4
			Explanation:
			7 -> 8 -> 4 -> 2 -> 1
			or
			7 -> 6 -> 3 -> 2 -> 1
			    
	Solution: None

    Source: https://discuss.leetcode.com/topic/59081/easy-and-straight-forward-java-solution
*/

public int integerReplacement(int n) {
	if (n == Integer.MAX_VALUE || n == Integer.MIN_VALUE) {
		return 32;
	}
    return helper(n, 0);
}

private int helper(int n , int count) {
	if (n == 1) {
		return count;
	} if (n % 2 == 0) {
		count = helper(n / 2, count + 1);
	} else {
		count = Math.min(helper(n + 1, count + 1), 
							helper(n - 1, count + 1));
	}
	return count;
}