class Solution {
    public int maxProduct(int[] nums) {
        
        int max = nums[0], lMax = nums[0], lMin = nums[0];
        for(int i=1; i<nums.length; i++){
            int t = lMax;

            lMax = Math.max(lMax * nums[i], Math.max(lMin * nums[i], nums[i]));
            lMin = Math.min(t * nums[i], Math.min(lMin * nums[i], nums[i]));
            max = Math.max(lMax, max);
        }

        return max;
    }
}
