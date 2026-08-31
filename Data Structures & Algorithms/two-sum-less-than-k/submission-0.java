class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);

        int max = -1, l=0, r=nums.length-1;
        while(l < r){
            int sum = nums[l] + nums[r];

            if(sum < k) {
                if(sum > max) max = sum;
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
