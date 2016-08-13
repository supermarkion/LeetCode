/*
    Design a data structure that supports all following operations in average O(1) time.
		1. insert(val): Inserts an item val to the set if not already present.
		2. remove(val): Removes an item val from the set if present.
		3. getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.

    Link: https://leetcode.com/problems/insert-delete-getrandom-o1/

    Example: 
    	// Init an empty set.
		RandomizedSet randomSet = new RandomizedSet();

		// Inserts 1 to the set. Returns true as 1 was inserted successfully.
		randomSet.insert(1);

		// Returns false as 2 does not exist in the set.
		randomSet.remove(2);

		// Inserts 2 to the set, returns true. Set now contains [1,2].
		randomSet.insert(2);

		// getRandom should return either 1 or 2 randomly.
		randomSet.getRandom();

		// Removes 1 from the set, returns true. Set now contains [2].
		randomSet.remove(1);

		// 2 was already in the set, so return false.
		randomSet.insert(2);

		// Since 1 is the only number in the set, getRandom always return 1.
		randomSet.getRandom();

    Solution: None

    Source: https://discuss.leetcode.com/topic/54069/java-solution-concise-code-with-hashmap-and-arraylist-easy-to-understand
*/

public class RandomizedSet {
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        } else {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) {
        	return false;
        } else {
            int key = map.get(val);
            int lastElement = list.get(list.size() - 1);
            map.put(lastElement, key);
            list.set(key, lastElement);
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */