/*
    Implement a data structure supporting the following operations:

    Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to 
    be a non-empty string.

    Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing 
    key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty 
    string.

    GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty 
    string "".

    GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty 
    string "".

    Challenge: Perform all these in O(1) time complexity.

    Link: https://leetcode.com/problems/all-oone-data-structure/

    Example: None
        
    Solution: None

    Source: https://discuss.leetcode.com/topic/67622/java-accepted-solution-using-hashmap-and-doublelinkedlist
*/

public class AllOne {
    private HashMap<String, Node> hash = null;
    private Node head = null, tail = null;
    
    /** Initialize your data structure here. */
    public AllOne() {
        hash = new HashMap<String, Node>();
        head = tail = null;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (head == null) {
            Node node = new Node(1);
            node.keys.add(key);
            head = tail = node;
            hash.put(key, node);
            return;
        }
        if (hash.containsKey(key)) {
            Node node = hash.get(key);
            if (node.next != null && node.next.val == node.val + 1) {
                node.next.keys.add(key);
                hash.put(key, node.next);
            } else {
                Node tmp = new Node(node.val + 1);
                tmp.keys.add(key);
                tmp.prev = node;
                tmp.next = node.next;
                if (node.next != null) {
                    node.next.prev = tmp;
                }
                node.next = tmp;
                if (tmp.val > tail.val) {
                    tail = tmp;
                }
                hash.put(key, tmp);
            }
            node.keys.remove(key);
            if (node.keys.size() == 0) {
                remove(node);
            }
        } else {
            if (head.val == 1) {
                head.keys.add(key);
                hash.put(key, head);
            } else {
                Node node = new Node(1);
                node.keys.add(key);
                node.next = head;
                head.prev = node;
                head = node;
                hash.put(key, node);
            }
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (hash.containsKey(key)) {
            Node node = hash.get(key);
            if (node.val != 1) {
                if (node.prev != null && node.prev.val == node.val - 1) {
                    node.prev.keys.add(key);
                    hash.put(key, node.prev);
                } else {
                    Node tmp = new Node(node.val - 1);
                    tmp.keys.add(key);
                    tmp.next = node;
                    tmp.prev = node.prev;
                    if (node.prev != null) {
                        node.prev.next = tmp;
                    }
                    node.prev = tmp;
                    if (tmp.val < head.val) {
                        head = tmp;
                    }
                    hash.put(key, tmp);
                }
            } else {
                hash.remove(key);
            }
            node.keys.remove(key);
            if (node.keys.size() == 0) {
                remove(node);
            }
        }
    }

    
    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
        }
        if (next == null) {
            tail = node.prev;
        } else {
            next.prev = prev;
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (tail != null && tail.keys.size() > 0) {
            // System.out.println("max:"+tail.val);
            for (String str: tail.keys) {
                return str;
            }
        } 
        return "";
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (head != null && head.keys.size() > 0) {
            // System.out.println("min:"+head.val);
            for (String str : head.keys) {
                return str;
            }
        }
        return "";
    }
    
    class Node {
        public int val = 1;
        public HashSet<String> keys = null;
        public Node prev, next;
        
        public Node(int val) {
            this.val = val;
            keys = new HashSet<String>();
            prev = next = null;
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */