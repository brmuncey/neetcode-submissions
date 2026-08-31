class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, min = Integer.MAX_VALUE, cur=0;

        for(Integer x : prices) {
            min = Math.min(min, x);
            max = Math.max(max, x - min);
        }

        return max;
    }
}
