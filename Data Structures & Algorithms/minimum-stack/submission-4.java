class MinStack {

    Stack<Integer> minStack;
    Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        int min = Math.min(val, minStack.isEmpty() ? val : minStack.peek());
        minStack.push(min);
        stack.push(val);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
