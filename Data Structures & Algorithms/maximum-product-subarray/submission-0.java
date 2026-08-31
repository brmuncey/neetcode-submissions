class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int pos = nums[0];
        int neg = nums[0];
        
        for(int i=1; i<nums.length; i++){
            int t = pos;

            pos = Math.max(Math.max(pos * nums[i], nums[i] * neg), nums[i]);
            neg = Math.min(Math.min(t * nums[i], nums[i] * neg), nums[i]);
            max = Math.max(pos, max);
        }

        return max;
    }
}
