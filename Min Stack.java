/*
    Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
		push(x) -- Push element x onto stack.
		pop() -- Removes the element on top of the stack.
		top() -- Get the top element.
		getMin() -- Retrieve the minimum element in the stack.
    
    Link: https://leetcode.com/problems/min-stack/

    Example: None

    Solution: None
    
    Source: None
*/

class MinStack {
    private ArrayList<Integer> minList;
    private ArrayList<Integer> minStack;
    private int currentMin;
    public MinStack() {
        // do initialize if necessary
        this.minStack = new ArrayList<Integer>();
        this.minList = new ArrayList<Integer>();
        this.currentMin = Integer.MAX_VALUE;
    }

    public void push(int number) {
        // write your code here
        int length = minList.size();
        if (length > 0) {
            currentMin = minList.get(length - 1);
        } else {
            currentMin = Integer.MAX_VALUE;
        }
        if (currentMin > number) {
            currentMin = number;
        }
        minStack.add(number);
        minList.add(currentMin);
    }
    
    public int top() {
        int length = minStack.size();
        int returnValue = 0;
        if (length > 0) {
            returnValue = minStack.get(length - 1);
        }
        return returnValue;
    }

    public int pop() {
        // write your code here
        int length = minStack.size();
        int returnValue = 0;
        if (length > 0) {
            returnValue = minStack.get(length - 1);
            minStack.remove(length - 1);
            minList.remove(length - 1);
        }
        return returnValue;
    }

    public int getMin() {
        // write your code here
        int length = minList.size();
        int returnValue = 0;
        if (length > 0) {
            returnValue = minList.get(length - 1);
        }
        return returnValue;
        
    }
}
