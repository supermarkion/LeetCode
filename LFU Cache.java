/*
    Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the 
    following operations: get and put.

	get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise 
	return -1.

	put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its 
	capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose
	 of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least 
	 recently used key would be evicted.

	Follow up:
		Could you do both operations in O(1) time complexity?

	Link: https://leetcode.com/problems/lfu-cache/

    Example: 
	    LFUCache cache = new LFUCache( 2 );

		cache.put(1, 1);
		cache.put(2, 2);
		cache.get(1);       // returns 1
		cache.put(3, 3);    // evicts key 2
		cache.get(2);       // returns -1 (not found)
		cache.get(3);       // returns 3.
		cache.put(4, 4);    // evicts key 1.
		cache.get(1);       // returns -1 (not found)
		cache.get(3);       // returns 3
		cache.get(4);       // returns 4 

    Solution: None

    Source: https://discuss.leetcode.com/topic/69137/java-o-1-accept-solution-using-hashmap-doublelinkedlist-and-linkedhashset/6
*/

public class LFUCache {
    class DNode {
        int key, val, freq;
        DNode prev, next;
        DNode(int k, int v) {
            key = k; val = v; freq = 1;
        }
    }
    class FNode {
        int freq;
        FNode prev, next;
        DNode first, cur;
        FNode(int freq) {
            this.freq = freq;
        }
        FNode(FNode prev) {
            this.freq = prev.freq + 1;
            this.prev = prev;
        }
    }
    
    Map<Integer, FNode> fMap;
    Map<Integer, DNode> dMap;
    FNode dummy;
    int capacity;
    
    public LFUCache(int capacity) {
        fMap = new HashMap<Integer, FNode>();
        dMap = new HashMap<Integer, DNode>();
        dummy = new FNode(0);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!dMap.containsKey(key)){
            return -1;
        } 
        DNode result = dMap.get(key);
        updateDNode(result);
        return result.val;
    }
    
    public void set(int key, int value) {
        if (!dMap.containsKey(key)) {
            if (dMap.size() == capacity) {
                if (capacity == 0) { return; }
                removeLFU();
            }
            addDNode(new DNode(key, value), fMap.containsKey(1) ? fMap.get(1) : addFNode(dummy));
        } else {
            DNode result = dMap.get(key);
            result.val = value;
            updateDNode(result);
        }
    }
    
    public void updateDNode(DNode dNode) {
        FNode prevFNode = fMap.get(dNode.freq);
        removeDNode(dNode, prevFNode);
        dNode.freq++;
        addDNode(dNode, fMap.containsKey(dNode.freq)? fMap.get(dNode.freq) : addFNode(prevFNode));
        if (prevFNode.first == null && prevFNode.cur == null) {
            removeFNode(prevFNode);
        }
    }
    
    public void removeDNode(DNode dNode, FNode fNode) {
        if (fNode.first == dNode && fNode.cur == dNode) {
            fNode.first = null;
            fNode.cur = null;
        } else if (fNode.first == dNode) {
            fNode.first = dNode.next;
            dNode.next.prev = null;
        } else if (fNode.cur == dNode) {
            fNode.cur = dNode.prev;
            dNode.prev.next = null;
        } else {
            dNode.prev.next = dNode.prev.next.next;
            dNode.next.prev = dNode.next.prev.prev;
        }
        dMap.remove(dNode.key);
    }
    
    public void addDNode(DNode dNode, FNode fNode) {
        dNode.prev = fNode.cur;
        if (fNode.cur == null && fNode.first == null) {
            fNode.first = dNode;
        } else {
            fNode.cur.next = dNode;
        }
        fNode.cur = dNode;
        dNode.next = null;
        dMap.put(dNode.key, dNode);
    }
    
    public void removeFNode(FNode fNode) {
        fNode.prev.next = fNode.prev.next.next;
        if (fNode.next != null) {
            fNode.next.prev = fNode.next.prev.prev;
        }
        fMap.remove(fNode.freq);
    }
    
    public FNode addFNode(FNode prevFNode) {
        FNode newNode = new FNode(prevFNode);
        if (prevFNode.next != null) {
            newNode.next = prevFNode.next;
            newNode.next.prev = newNode;
        }
        prevFNode.next = newNode;
        newNode.prev = prevFNode;
        fMap.put(newNode.freq, newNode);
        return newNode;
    }
    
    public void removeLFU() {
        removeDNode(dummy.next.first, dummy.next);
        if (dummy.next.first == null && dummy.next.cur == null) {
            removeFNode(dummy.next);
        }
    }
    
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */