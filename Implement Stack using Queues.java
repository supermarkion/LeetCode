/*
    Implement the following operations of a stack using queues.
		push(x) -- Push element x onto stack.
		pop() -- Removes the element on top of the stack.
		top() -- Get the top element.
		empty() -- Return whether the stack is empty.
    
    Link: https://leetcode.com/problems/implement-stack-using-queues/

    Example: None

    Solution: None
    
    Source: https://leetcode.com/discuss/80278/java-solution-with-one-queue
*/

class MyStack {
    private LinkedList<Integer> list = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        if (list.isEmpty()) {
            list.add(x);
        } else {
            list.add(x);
            while (list.peek() != x) {
                int value = list.poll();
                list.add(value);
            }
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        list.poll();
    }

    // Get the top element.
    public int top() {
        return list.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return list.isEmpty();
    }
}