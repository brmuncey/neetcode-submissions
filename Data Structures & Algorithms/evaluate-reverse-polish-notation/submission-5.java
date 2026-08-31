class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int x=0;
        for(String s : tokens){
            if(s.equals("+")){
                stack.push(stack.pop() + stack.pop());
            } else if(s.equals("-")) {
                x = stack.pop();
                stack.push(stack.pop() - x);
            } else if(s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if(s.equals("/")){
                x = stack.pop();
                stack.push(stack.pop() / x);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
