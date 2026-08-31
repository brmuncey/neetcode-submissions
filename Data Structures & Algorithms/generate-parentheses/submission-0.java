class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        backtrack(n, 0, 0, stack, result);
        return result;
    }

    private void backtrack(int n, int open, int closed, Stack<String> stack, List<String> result){
        if(n == open && closed == open){
            StringBuilder sb = new StringBuilder();
            for(String s : stack){
                sb.append(s);
            }
            result.add(sb.toString());
        }

        if(open < n){
            stack.push("(");
            backtrack(n, open + 1, closed, stack, result);
            stack.pop();
        }

        if(closed < open){
            stack.push(")");
            backtrack(n, open, closed + 1, stack, result);
            stack.pop();
        }
    }
}
