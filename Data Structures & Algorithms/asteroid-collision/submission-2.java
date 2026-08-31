class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int a : asteroids){
            boolean destroyed = false;
            while(!stack.isEmpty() && stack.peek() > 0 && a < 0) {
                if(stack.peek() < Math.abs(a)) {
                    stack.pop();
                    continue;
                } else if(stack.peek() == Math.abs(a)) {
                    stack.pop();
                }
                destroyed = true;
                break;
            }
            if(!destroyed) stack.push(a);
        }

        int[] res = new int[stack.size()];
        for(int i=res.length-1; i>=0; i--) res[i] = stack.pop();
        return res; 
    }
}