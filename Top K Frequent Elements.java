/*
    Given a non-empty array of integers, return the k most frequent elements.

    Link: https://leetcode.com/problems/top-k-frequent-elements/

    Example: 
    	Given [1,1,1,2,2,3] and k = 2, return [1,2].
    
    Solution: None

    Source: https://leetcode.com/discuss/100581/java-o-n-solution-bucket-sort
*/

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
    
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }
    
        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
    
        List<Integer> res = new ArrayList<>();
    
        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }
}