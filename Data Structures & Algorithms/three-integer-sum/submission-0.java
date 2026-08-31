class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0 ; i<nums.length ; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            findAll(result, i, i+1, nums);
        }
        return result;
    }

    private void findAll(List<List<Integer>> result, int i, int m, int[] nums){
        int r = nums.length -1;

        while(m < r){
            int cur = nums[i] + nums[m] + nums[r];
            if(cur == 0){
                result.add(Arrays.asList(nums[i], nums[m], nums[r]));
                m++;
                r--;
                while(m < r && nums[m] == nums[m - 1]){
                    m++;
                }
            } else if(cur < 0){
                m++;
            } else {
                r--;
            }
        }
    }
}
