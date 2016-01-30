/*
    Implement the following operations of a queue using stacks.
		push(x) -- Push element x to the back of queue.
		pop() -- Removes the element from in front of queue.
		peek() -- Get the front element.
		empty() -- Return whether the queue is empty.
    
    Link: https://leetcode.com/problems/implement-queue-using-stacks/

    Example: None

    Solution: None
    
    Source: None
*/

class MyQueue {
    
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    // Push element x to the back of queue.
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        stack2.pop();
    }

    // Get the front element.
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if (stack1.empty() && stack2.empty()) {
            return true;
        }
        return false;
        
    }
}