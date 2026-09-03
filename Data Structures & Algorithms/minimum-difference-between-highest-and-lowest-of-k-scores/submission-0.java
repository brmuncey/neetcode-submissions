class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE, l=0;
        for(int r=0; r<nums.length; r++){
            if(r >= k - 1){
                min = Math.min(min, nums[r] - nums[l]);
                l++;
            }
        }
        return min;
    }
}