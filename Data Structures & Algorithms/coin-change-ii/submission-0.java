class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for(int i = coins.length - 1; i >= 0; i--){
            int[] next = new int[amount + 1];
            next[0] = 1;

            for(int a = 1; a <= amount; a++){
                next[a] = dp[a];
                if(a - coins[i] >= 0) next[a] += next[a - coins[i]];
            }
            dp = next;
        }

        return dp[amount];
    }
}
