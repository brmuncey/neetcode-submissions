class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0, sum=0, min=nums.length + 1;
        for(int r=0; r<nums.length; r++){
            sum += nums[r];
            while(sum >= target){
                min = Math.min(r - l + 1, min);
                sum -= nums[l++];
            }
        }
        return min == nums.length + 1 ? 0 : min;
    }
}