class Solution {
    public int missingNumber(int[] nums) {
        int i=0, t=0;
        while(i<nums.length){
            if(nums[i] < nums.length && nums[i] != nums[nums[i]]){
                t = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = t;
            } else {
                i++;
            }
        }

        for(i=0; i<nums.length; i++) {
            if(nums[i] != i) return i;
        }

        return nums.length;
    }
}
