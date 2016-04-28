/*
    The API: int read4(char *buf) reads 4 characters at a time from a file. The return value is the actual number of characters read. 
    For example, it returns 3 if there is only 3 characters left in the file. By using the read4 API, implement the function int 
    read(char *buf, int n) that reads n characters from the file.
    
    Link: https://leetcode.com/problemset/algorithms/

    Example: None
    
    Solution: None

    Source: http://yuanhsh.iteye.com/blog/2186426
*/

private char[] buffer = new char[4];
private int offset = 0, bufsize = 0; 
public int read(char[] buf, int n) {
    int total = 0;
    boolean eof = false;
    while (!eof && total < n) {
        if (bufsize == 0) {
			bufsize = read4(buffer);
			if (bufsize < 4) {
				eof = true;
			}
		}
        int bytes = Math.min(n - total, bufsize); 
        System.arraycopy(buffer /*src*/, offset /*srcPos*/, 
                         buf /*dest*/,   total /*destPos*/, 
                         bytes /*length*/);
        offset = (offset + bytes) % 4;
        bufsize -= bytes;
        total += bytes;
    }
    return total;
}
