/*
    Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns 
    of the Android lock screen, which consist of minimum of m keys and maximum n keys.
	
	Rules for a valid pattern:
		1. Each pattern must connect at least m keys and at most n keys.
		2. All the keys must be distinct.
		3. If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have 
		previously selected in the pattern. No jumps through non selected key is allowed.
		4. The order of keys used matters.

    Link: https://leetcode.com/problemset/algorithms/

    Example:  
        Invalid move: 4 - 1 - 3 - 6 
		Line 1 - 3 passes through key 2 which had not been selected in the pattern.

		Invalid move: 4 - 1 - 9 - 2
		Line 1 - 9 passes through key 5 which had not been selected in the pattern.

		Valid move: 2 - 4 - 1 - 3 - 6
		Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

		Valid move: 6 - 5 - 4 - 1 - 9 - 2
		Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.

		Example:
			Given m = 1, n = 1, return 9.

		Credits:
			Special thanks to @elmirap for adding this problem and creating all test cases.
    
    Solution: None

    Source: http://www.cnblogs.com/grandyang/p/5541012.html
*/

public int numberOfPatterns(int m, int n) {
    boolean[][] board = new boolean[3][3];
    int result = 0;

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            board[i][j] = true;
            result += helper(board, i, j, m, n, 1);
            board[i][j] = false;
        }
    }

    return result;
}

private int helper(boolean[][] board, int i, int j, int m, int n, int count) {
    if (count > n) return 0;

    int result = (count >= m) ? 1 : 0;

    for (int x = 0; x < 3; x++) {
        for (int y = 0; y < 3; y++) {
            if (board[x][y] ||
                (x == i && Math.abs(y - j) == 2 && !board[x][1]) ||
                (y == j && Math.abs(x - i) == 2 && !board[1][y]) ||
                (Math.abs(x - i) == 2 && Math.abs(y - j) == 2 && !board[1][1])) {
                continue;
            }

            board[x][y] = true;
            result += helper(board, x, y, m, n, count + 1);
            board[x][y] = false;
        }
    }

    return result;
}