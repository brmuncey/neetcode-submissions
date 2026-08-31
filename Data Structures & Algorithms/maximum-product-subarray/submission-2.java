class Solution {
    public int maxProduct(int[] nums) {
        int min=nums[0], max = nums[0], res = nums[0];
        for(int i=1; i<nums.length ; i++){
            int temp = max;
            max = Math.max(max * nums[i], Math.max(nums[i], min * nums[i]));
            min = Math.min(temp * nums[i], Math.min(nums[i], min * nums[i]));
            res = Math.max(max, res);
        }
        return res;
    }
}
