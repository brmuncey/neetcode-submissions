class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 1) return cost[0];
        int one = cost[0];
        int two = cost[1];
        for(int i=2; i<cost.length; i++){
            int temp = two;
            two = cost[i] + Math.min(one, two);
            one = temp;
        }
        return Math.min(one, two);
    }
}