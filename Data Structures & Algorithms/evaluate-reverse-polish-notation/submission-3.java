class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String c : tokens){
            if(c.equals("+")){
                stack.push(stack.pop() + stack.pop());
            } else if(c.equals("-")){
                int x = stack.pop();
                int y = stack.pop();
                stack.push(y - x);
            } else if(c.equals("*")){
                stack.push(stack.pop() * stack.pop());
            } else if(c.equals("/")){
                int x = stack.pop();
                int y = stack.pop();
                stack.push(y/x);
            } else {
                stack.push(Integer.parseInt(c));
            }
        }

        return stack.pop();
    }
}
