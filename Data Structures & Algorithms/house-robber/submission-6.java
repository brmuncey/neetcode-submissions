class Solution {
    public int rob(int[] nums) {
        int one=0, two=0;
        for(int n : nums){
            int t = one;
            one = Math.max(two + n, one);
            two = t;
        }
        return one;
    }
}
