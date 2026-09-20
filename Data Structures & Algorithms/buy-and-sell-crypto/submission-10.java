class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE, profit=0;
        for(int p : prices){
            if(min > p) min = p;
            if(profit < p - min) profit = p - min;
        }
        return profit;
    }
}
