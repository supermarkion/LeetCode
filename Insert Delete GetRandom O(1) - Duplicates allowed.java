/*
    Design a data structure that supports all following operations in average O(1) time.

	Note: Duplicate elements are allowed.
		1. insert(val): Inserts an item val to the collection.
		2. remove(val): Removes an item val from the collection if present.
		3. getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
    
    Link: https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/

    Example: 
    	// Init an empty collection.
		RandomizedCollection collection = new RandomizedCollection();

		// Inserts 1 to the collection. Returns true as the collection did not contain 1.
		collection.insert(1);

		// Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
		collection.insert(1);

		// Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
		collection.insert(2);

		// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
		collection.getRandom();

		// Removes 1 from the collection, returns true. Collection now contains [1,2].
		collection.remove(1);

		// getRandom should return 1 and 2 both equally likely.
		collection.getRandom();

    Solution: None

    Source: https://discuss.leetcode.com/topic/53768/easy-understanding-java-solution-using-hashset
*/

public class RandomizedCollection {

    List<Integer> nums;
    Map<Integer, Set<Integer>> map;
    java.util.Random random;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        random = new java.util.Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean doesContain = map.containsKey(val);
        if (!doesContain) {
        	map.put(val, new HashSet<>());	
        }
        map.get(val).add(nums.size());
        nums.add(val);
        return !doesContain;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
        	return false;
        }
        if (!map.get(val).contains(nums.size()-1)) {
            int currPos = map.get(val).iterator().next();
            int lastVal = nums.get(nums.size() - 1);
            map.get(lastVal).remove(nums.size() - 1);
            map.get(lastVal).add(currPos);
            map.get(val).remove(currPos);
            map.get(val).add(nums.size() - 1);
            nums.set(currPos, lastVal);
        }
        map.get(val).remove(nums.size()-1);
        if (map.get(val).isEmpty()) {
        	map.remove(val);	
        }
        nums.remove(nums.size()-1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}