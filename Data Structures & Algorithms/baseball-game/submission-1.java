class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int x=0, y=0, t=0;
        for(String s : operations){
            if(s.equals("+")){
                x=stack.pop();
                y=stack.pop();
                stack.push(y);
                stack.push(x);
                stack.push(x + y);
            } else if(s.equals("C")) {
                stack.pop();
            } else if(s.equals("D")) {
                t = stack.peek();
                stack.push(t * 2);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        int sum = 0;
        for(int s : stack) sum += s;
        return sum;
    }
}