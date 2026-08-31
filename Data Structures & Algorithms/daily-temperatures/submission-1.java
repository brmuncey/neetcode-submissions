class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] res = new int[n];
        for(int i=0 ; i<n ; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int ind = stack.pop();
                res[ind] = i - ind;
            }
            stack.push(i);
        }
        return res;
    }
}
