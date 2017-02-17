/*
	Given scores of N athletes, find their relative ranks and the people with the 
	top three highest scores, who will be awarded medals: "Gold Medal", "Silver 
	Medal" and "Bronze Medal".
    
    Link: https://leetcode.com/problems/relative-ranks/

	Example: 
		Input: [5, 4, 3, 2, 1]
		Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
		Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
		For the left two athletes, you just need to output their relative ranks according to their scores.
				
    Solution: None

    Source: https://discuss.leetcode.com/topic/79670/java-8-solution
*/

public class Solution {
    public String[] findRelativeRanks(int[] nums) {
		String[] RANKS = { "Gold Medal", "Silver Medal", "Bronze Medal" };
		Map<Integer, String> map = new HashMap<Integer, String>();
		Arrays.stream(nums).mapToObj(i -> new Integer(i)).sorted(Comparator.reverseOrder()).reduce(1, (i, v) -> {
			map.put(v, i > 3 ? Integer.toString(i) : RANKS[i - 1]);
			return i + 1;
		});
		return Arrays.stream(nums).mapToObj(n -> map.get(n)).toArray(String[]::new);
	}
}