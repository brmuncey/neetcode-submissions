class Solution {
    public int findDuplicate(int[] nums) {
        int i=0, t=0; 
        while(i < nums.length){
            if(nums[i] != nums[nums[i]]){
                t = nums[i];
                nums[i] = nums[t];
                nums[t] = t;
            } else {
                i++;
            }
        }

        for(int j = 0; j<nums.length; j++){
            if(nums[j] != j) return nums[j];
        }
        return -1;
    }
}
