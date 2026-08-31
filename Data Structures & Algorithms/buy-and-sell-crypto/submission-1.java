class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 1){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int profit = 0;

        for(Integer x : prices){
            min = Math.min(x, min);
            profit = Math.max(profit, x - min);
        }

        return profit;
    }
}
