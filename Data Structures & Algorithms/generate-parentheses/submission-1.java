class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        generate(result, stack, n, 0, 0);
        return result;
    }

    private void generate(List<String> result, Stack<Character> stack, int n, int left, int right) {

        if(left == right && left == n){
            StringBuilder sb = new StringBuilder();
            for(Character c : stack){
                sb.append(c);
            }
            result.add(sb.toString());
            return;
        }

        if(left < n){
            stack.push('(');
            generate(result, stack, n, left+1, right);
            stack.pop();
        }

        if(right < left){
            stack.push(')');
            generate(result, stack, n, left, right+1);
            stack.pop();
        }
    }
}
