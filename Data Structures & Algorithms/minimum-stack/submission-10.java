class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        int min = !minStack.isEmpty() && minStack.peek() < val ? minStack.peek() : val;
        minStack.push(min);
        stack.push(val);
    }
    
    public void pop() {
        minStack.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
