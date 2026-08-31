class Solution {
    public int rob(int[] nums) {
        int r1=0, r2=0;
        for(int x : nums){
            int t = Math.max(r1 + x, r2);
            r1 = r2;
            r2 = t;
        }
        return r2;
    }
}
