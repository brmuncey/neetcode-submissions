class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, min=Integer.MAX_VALUE;
        for(Integer p : prices){
            min = Math.min(p, min);
            profit = Math.max(profit, p - min);
        }
        return profit;
    }
}
