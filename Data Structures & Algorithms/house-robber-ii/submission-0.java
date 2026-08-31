class Solution {
    public int rob(int[] nums) {
        return Math.max(nums[0], Math.max(rob(nums, 1, nums.length), rob(nums, 0, nums.length - 1)));
    }

    private int rob(int[] nums, int s, int n){
        int r1 = 0, r2 = 0;

        for(int i=s; i<n; i++){
            int r3 = Math.max(r1 + nums[i], r2);
            r1 = r2;
            r2 = r3;
        }

        return r2;
    }
}
