class Solution {
    public int findDuplicate(int[] nums) {
        int i=0;
        while(i < nums.length){
            if(nums[i] != nums[nums[i] - 1]){
                int t = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = t;
            } else {
                i++;
            }
        }

        for(i = 0; i<nums.length; i++){
            if(nums[i] != i + 1){
                return nums[i];
            }
        }

        return nums.length + 1;
    }
}
