/*
    Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
		get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
		set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
		it should invalidate the least recently used item before inserting a new item.

    Link: https://leetcode.com/problems/lru-cache/

    Example: None

    Solution: Use a list and a map to implement get and set key,value information. 

    Source: https://leetcode.com/discuss/79319/easiest-java-solution
*/

 public class LRUCache {
    int capacity;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        join(head, tail);
    }
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node n = map.get(key);
        moveToHead(n);
        return n.val;
    }
    public void set(int key, int value) {
        if(!map.containsKey(key)) {
            if(map.size() == capacity) rmOldest();
            create(key, value);
        }
        Node n = map.get(key); 
        n.val = value;
        moveToHead(n);
    }

    public void moveToHead(Node n) {
        remove(n);
        Node first = head.next; 
        join(head, n);
        join(n, first);
    }
    public void rmOldest() {
        Node last = tail.prev;
        remove(last);
        map.remove(last.key); // only delete here
    }
    public void create(int key, int value) { Node n = new Node(key, value); map.put(key, n); moveToHead(n); }
    public void remove(Node n) { if(n.prev == null) return; n.prev.next = n.next; n.next.prev = n.prev; }
    public void join(Node n1, Node n2) { n1.next = n2; n2.prev = n1; }

    class Node {
        int key, val;
        Node prev, next;
        public Node(int k, int v) { key = k; val = v; }
    }
}