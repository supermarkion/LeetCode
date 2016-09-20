/*
    A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. The frog can 
    jump on a stone, but it must not jump into the water.

	Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing 
	on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.

	If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.

	The number of stones is ≥ 2 and is < 1,100. Each stone's position will be a non-negative integer < 231. The first stone's position is always 0.

    Link: https://leetcode.com/problems/frog-jump/

    Example: 
		Example 1:
			[0,1,3,5,6,8,12,17]

			There are a total of 8 stones.
			The first stone at the 0th unit, second stone at the 1st unit,
			third stone at the 3rd unit, and so on...
			The last stone at the 17th unit.

			Return true. The frog can jump to the last stone by jumping 
			1 unit to the 2nd stone, then 2 units to the 3rd stone, then 
			2 units to the 4th stone, then 3 units to the 6th stone, 
			4 units to the 7th stone, and 5 units to the 8th stone.

		Example 2:
			[0,1,2,3,4,8,9,11]

			Return false. There is no way to jump to the last stone as 
			the gap between the 5th and 6th stone is too large.
			    
	Solution: None

    Source: https://discuss.leetcode.com/topic/59423/simple-easy-to-understand-java-solution
*/

public class Solution {
    public static boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> stoneMap = new HashMap<>();
        for (int i = 1; i < stones.length; i++) {
            stoneMap.put(stones[i], new HashSet<Integer>());
        }
        if (stones[0] + 1 == stones[1]) {
            stoneMap.get(stones[1]).add(1);
        }
        for (int i = 1; i < stones.length; i++) {
            int eachStone = stones[i];
            for (Integer K : stoneMap.get(eachStone)) {
                if (K != 1 &&  stoneMap.containsKey(eachStone + K - 1)) {
                    stoneMap.get(eachStone + K - 1).add(K - 1);
                }
                if (stoneMap.containsKey(eachStone + K)) {
                    stoneMap.get(eachStone + K).add(K);
                }
                if (stoneMap.containsKey(eachStone + K + 1)) {
                    stoneMap.get(eachStone + K + 1).add(K + 1);
                }
            }
        }
        return stoneMap.get(stones[stones.length - 1]).size() >= 1;
    }
}