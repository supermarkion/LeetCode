/*
    Suppose you are at a party with n people (labeled from 0 ton - 1) and among them, there may exist one celebrity. The definition 
    of a celebrity is that all the othern - 1 people know him/her but he/she does not know any of them.

	Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is 
	to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity 
	(or verify there is not one) by asking as few questions as possible (in the asymptotic sense).

	You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a functionint findCelebrity(n), 
	your function should minimize the number of calls toknows.

    Link: https://leetcode.com/problemset/algorithms/

    Example: None

    Solution: None

    Source: http://blog.csdn.net/xudli/article/details/48749295
*/

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int[] bitmap = new int[n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                	continue;
                }
                if (bitmap[j] >= 0) {
                    if (knows(i, j)) {
                        bitmap[i] = -1;
                        bitmap[j]++;
                    } else {
                        bitmap[j] = -1;
                    }
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (bitmap[i] == n - 1) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                    	continue;
                    } 
                    if (knows(i, j)) {
                    	return -1;
                    }
                }
                return i;
            }
        }
        return -1;
    }
}