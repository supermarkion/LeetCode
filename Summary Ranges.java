/*
    Given a sorted integer array without duplicates, return the summary of its ranges.
    
    Link: https://leetcode.com/problems/summary-ranges/

    Example: For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

    Solution: Determine next number is continuous or not.
    
    Source: https://leetcode.com/discuss/82484/my-1ms-java-solution
*/

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if( nums.length == 0 ){
            return res;
        }
        int start = Integer.MIN_VALUE, end = Integer.MIN_VALUE;
        String tmp = "";
        for ( int i = 0; i < nums.length;  ){
            if (tmp == ""){
                start = nums[i];
                end = nums[i];
                i++;
                tmp += start;
            } else if (nums[i] == end + 1){
                end = nums[i];
                i++;
            } else {
                if(start == end){
                    res.add(tmp); 
                } else {
                    tmp += "->" + end;
                    res.add(tmp);
                }
                tmp = "";
            }
        }
        if (start != end) {
            tmp += "->" + end;
        }
        res.add(tmp);
        return res;
    }
}