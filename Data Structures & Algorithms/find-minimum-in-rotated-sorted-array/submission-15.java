class Solution {
    public int findMin(int[] nums) {
        int l=0, r=nums.length-1, min=Integer.MAX_VALUE;
        while(l <= r){
            int m = l + (r-l)/2;

            min = Math.min(nums[m], min);
            if(nums[m] <= nums[r]){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return min;
    }
}
