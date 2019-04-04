/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
• push(x) -- Push element x onto stack.
• pop() -- Removes the element on top of the stack.
• top() -- Get the top element.
• getMin() -- Retrieve the minimum element in the stack.


Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.


Trick is to maintain two stacks. One to actually work like a stack. Another one just storing mins.
Only push into the min stack if the current number is smaller/equal to the top...if it's bigger, we
would have to pop them off before we get to the min...so it's same as not storing them.
 */

package leetcode;

class MinStack {

    private java.util.Stack<Integer> backing;
    private java.util.Stack<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        this.backing = new java.util.Stack<>();
        this.min = new java.util.Stack<>();
    }

    public void push(int x) {
        this.backing.push(x);
        if ((this.min.empty()) || (this.min.peek() >= x)) {
            this.min.push(x);
        }
    }

    public void pop() {
        int x = this.backing.pop();
        if (x == this.min.peek()) {
            this.min.pop();
        }
    }

    public int top() {
        return this.backing.peek();
    }

    public int getMin() {
        return this.min.peek();
    }
}
