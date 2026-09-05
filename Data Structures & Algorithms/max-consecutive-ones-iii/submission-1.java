class Solution {
    public int longestOnes(int[] nums, int k) {
        int z=0, l=0, max=0;
        for(int r=0; r<nums.length; r++){
            if(nums[r] == 0) z++;

            while(z > k){
                if(nums[l] == 0) z--;
                l++;
            }
            max = Math.max(r - l + 1, max);
        }
        return max;
    }
}