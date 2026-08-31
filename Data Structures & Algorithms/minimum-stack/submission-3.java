class MinStack {

    Stack<Integer> minStack;
    Stack<Integer> stack;

    public MinStack() {
        minStack = new Stack<>();
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        int min = Math.min(minStack.isEmpty() ? val : minStack.peek(), val);
        minStack.push(min);
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
