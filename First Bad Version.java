/*
    You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest 
    version of your product fails the quality check. Since each version is developed based on the previous version, 
    all the versions after a bad version are also bad. Suppose you have n versions [1, 2, ..., n] and you want to 
    find out the first bad one, which causes all the following ones to be bad. You are given an API bool isBadVersion(version) 
    which will return whether version is bad. Implement a function to find the first bad version. You should minimize the 
    number of calls to the API.

    Link: https://leetcode.com/problems/first-bad-version/

    Example: None

    Solution: None
    
    Source: https://leetcode.com/discuss/67561/solution-with-using-low-high-2-and-not-low-high-low-2
*/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long start = 1, end = n;
        int res = -1;
        while(start <= end){
            long mid = (start + end) / 2;
            if (isBadVersion((int)mid)) {
                res = (int)mid;
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        return res;
    }
}