/*
    Think about Zuma Game. You have a row of balls on the table, colored red(R), yellow(Y), 
    blue(B), green(G), and white(W). You also have several balls in your hand.

    Each time, you may choose a ball in your hand, and insert it into the row (including 
    the leftmost place and rightmost place). Then, if there is a group of 3 or more balls 
    in the same color touching, remove these balls. Keep doing this until no more balls 
    can be removed.

    Find the minimal balls you have to insert to remove all the balls on the table. If 
    you cannot remove all the balls, output -1.

    Link: https://leetcode.com/problems/zuma-game/

    Example: 

        Input: "WRRBBW", "RB"
        Output: -1
        Explanation: WRRBBW -> WRR[R]BBW -> WBBW -> WBB[B]W -> WW

        Input: "WWRRBBWW", "WRBRW"
        Output: 2
        Explanation: WWRRBBWW -> WWRR[R]BBWW -> WWBBWW -> WWBB[B]WW -> WWWW -> empty

        Input:"G", "GGGGG"
        Output: 2
        Explanation: G -> G[G] -> GG[G] -> empty 

        Input: "RBYYBBRRB", "YRBGB"
        Output: 3
        Explanation: RBYYBBRRB -> RBYY[Y]BBRRB -> RBBBRRB -> RRRB -> B -> B[B] -> BB[B] -> empty 

    Solution: None

    Source: https://discuss.leetcode.com/topic/75618/38-ms-java-bfs-solution-with-explanation
*/

class Node{
    String str;
    Map<Character, Integer> handMap;
    Node(String str,  Map<Character, Integer> handMap){
        this.str = str;
        this.handMap = new HashMap<>();
        this.handMap.putAll(handMap);
    } 
}

public class Solution {
    public int findMinStep(String board, String hand) {
        if(board == null || hand == null){
            return -1;
        }
        
        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        /*use hashMap to describe the hand string*/
        Map<Character, Integer> handMap = new HashMap<>();
        handMap.put('R', 0);
        handMap.put('Y', 0);
        handMap.put('B', 0);
        handMap.put('G', 0);
        handMap.put('W', 0);
        for(char ch : hand.toCharArray()){
            handMap.put(ch, handMap.get(ch) + 1);    
        }
        
        board = update(board); // to initialize the board string
        if(board.isEmpty()){
            return 0;
        }
        
        queue.add(new Node(board, handMap));
        visited.add(board);
        
        int cnt = 0; // counter to record the depth of the layer
        while(!queue.isEmpty()){
            int size = queue.size();
            cnt++;
            
            for(int i = 0; i < size; i++){
                Node node = queue.poll();
                String str = node.str;
                Map<Character, Integer> map = node.handMap;
                
                for(int j = 0; j < str.length(); j++){
                    char ch = str.charAt(j);
                    if(map.get(ch) > 0 && (j == 0 || ch != str.charAt(j - 1))){
                        
                        String newStr = update(str.substring(0, j) + ch + str.substring(j), j);
                        
                        if(newStr.isEmpty()){
                            return cnt;
                        }
                        
                        if(!visited.contains(newStr)){ // visited is used to avoid repeated computation 
                            visited.add(newStr);
                            Node newNode = new Node(newStr, map);
                            Map<Character, Integer> newMap = newNode.handMap;
                            newMap.put(ch, newMap.get(ch) - 1);
                            queue.add(newNode);
                        }
                        
                    }
                }
                
            }
        } 
        
        return -1;
    }
    /*I overwrite the update function, the first one is used to update the board string initially, it needs be scan from the begin to end*/
    public String update(String str){
        int len = str.length();
        for(int i = 0; i < len - 2; i++){
            int j = i + 1;
            while(j < len && str.charAt(j) == str.charAt(i)){
                j++;
            }
            
            if(j - i >= 3){
                return update(str.substring(0, i) + str.substring(j));
            }
        }
        
        return str;
    }
    /*The second update function is used to update the board string after insertion, we keep the insert position i, so as to avoid useless scan*/
    public String update(String str, int i){
        int j = i + 1;
        int len = str.length();
        while(j < len && str.charAt(j) == str.charAt(i)){
            j++;
        }
        
        if(j - i >= 3){
            int next_i = i > 0 ? i - 1 : 0;
            if(i - 2 >= 0 && str.charAt(i - 2) == str.charAt(i - 1)){
                next_i = i - 2;
            }
            
            return update(str.substring(0, i) + str.substring(j), next_i);
        }
        return str;
    }
}