class Solution {
    public int findMin(int[] nums) {
        int l=0, r=nums.length-1, min=nums[0];
        while(l <= r){
            int m = l + (r - l) / 2;

            if(nums[m] <= nums[r]){
                r = m - 1;
            } else {
                l = m + 1;
            }

            min = Math.min(min, nums[m]);
        }

        return min;
    }
}


// 5,6,1,2,3,4