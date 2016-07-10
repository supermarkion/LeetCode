/*
    You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
    Define a pair (u,v) which consists of one element from the first array and one element from the second array.
    Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
    
    Link: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

    Example: 
    	Example 1:

        Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
        Return: [1,2],[1,4],[1,6]

        The first 3 pairs are returned from the sequence:
        [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

        Example 2:

        Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
        Return: [1,1],[1,1]

        The first 2 pairs are returned from the sequence:
        [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

        Example 3:

        Given nums1 = [1,2], nums2 = [3],  k = 3 
        Return: [1,3],[2,3]

        All possible pairs are returned from the sequence:
        [1,3],[2,3]
    
    Solution: None

    Source: https://discuss.leetcode.com/topic/50716/java-solution-easy-to-understand
*/

public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        if (nums1 == null || nums2 == null) {
            return null;
        }
            
        int n = nums1.length;
        int m = nums2.length;
            
        List<int[]> ret = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ret.add(new int[]{nums1[i], nums2[j]});
            }
        }
        
        //Java 8
        Collections.sort(ret, (int[] n1, int[] n2) -> (n1[0] + n1[1]) - (n2[0] + n2[1]));
        
        if (ret.size() < k) {
            return ret;
        }
            
            
        return ret.subList(0, k);
    }
}