/*
    We are playing the Guess Game. The game is as follows:
    I pick a number from 1 to n. You have to guess which number I picked.
    Every time you guess wrong, I'll tell you whether the number is higher or lower.

    You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
        -1 : My number is lower
         1 : My number is higher
         0 : Congrats! You got it!

    Link: https://leetcode.com/problems/guess-number-higher-or-lower/

    Example: 
        n = 10, I pick 6.
        Return 6.
    
    Solution: None

    Source: None
*/

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int mid = (n + low) / 2;
        int g = guess(mid);
        while (g != 0) {
            if (g > 0) {
                low = mid + 1;
            } else {
                n = mid - 1;
            }
            mid = (int)((double) n / 2 + (double) low / 2);
            g = guess(mid);
        }
        
        return mid;
    }
}