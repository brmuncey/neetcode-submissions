class Solution {
    public void sortColors(int[] nums) {
        int i=0, l=0, r=nums.length-1;

        while(i <= r){
            if(nums[i] == 0){
                swap(nums, i, l);
                i++;
                l++;
            } else if(nums[i] == 1){
                i++;
            } else {
                swap(nums, i, r);
                r--;
            }
        }
    }

    private void swap(int[] nums, int l, int r){
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }
}