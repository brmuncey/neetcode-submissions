class Solution {
    public boolean hasDuplicate(int[] nums) {
        Arrays.sort(nums);

        int i=0;
        for(int j=i+1; j<nums.length; j++){
            if(nums[j] == nums[i]){
                return true;
            }
            i++;
        }

        return false;
    }
}
