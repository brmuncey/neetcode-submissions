class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int one = 0;
        int two = 0;
        for(int c : cost){
            int temp = c + Math.min(one, two);
            two = one;
            one = temp;
        }
        return Math.min(one, two);
    }
}
