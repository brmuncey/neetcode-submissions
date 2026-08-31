class Solution {
    public boolean search(int[] nums, int target) {
        int l=0, r=nums.length-1;

        while(l <= r){
            while(l < r && nums[l + 1] == nums[l]) l++;
            while(l < r && nums[r - 1] == nums[r]) r--;

            int m = l + (r - l)/2;

            if(nums[m] == target) return true;

            if(nums[l] <= nums[m]){
                if(target < nums[l] || nums[m] < target){
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                if(target > nums[r] || nums[m] > target){
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }

        return false;
    }
}