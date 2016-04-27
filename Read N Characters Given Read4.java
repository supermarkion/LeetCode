/*
    The API: int read4(char *buf) reads 4 characters at a time from a file. The return value is the actual number of characters read. 

    Link: https://leetcode.com/problemset/algorithms/

    Example: 
	    For example, it returns 3 if there is only 3 characters left in the file. By using the read4 API, implement the function 
	    int read(char *buf, int n) that reads n characters from the file.
    
    Solution: None

    Source: https://leetcode.com/discuss/85767/java-easy-version-to-understand
*/

public int read(char[] buf, int n) {
    if (n <= 0) {
    	return 0;
    }
    char[] tmp = new char[4];
    int j = 0;
    while (true) {
        int readCount = read4(tmp);
        for (int i = 0; i < readCount && j < n; i++) {
        	buf[j++] = tmp[i];
        }
        if (j == n || readCount < 4) {
        	break;
        }
    }
    return j;
}