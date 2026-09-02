class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ones = 0, max = 0, l = 0;
        for(int r=0; r<nums.length; r++){
            if(nums[r] == 1) ones++;
            max = Math.max(ones, max);
            while(l < r && nums[r] == 0){
                if(nums[l] == 1) ones--;
                l++;
            }
        }
        return max;
    }
}