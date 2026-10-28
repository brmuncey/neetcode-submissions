class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0], cur=0;
        for(Integer x : nums){
            if(cur < 0) cur = 0;
            cur += x;
            max = Math.max(cur, max);
        }

        return max;
    }
}
