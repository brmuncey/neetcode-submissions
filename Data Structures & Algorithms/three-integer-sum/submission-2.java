class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null){
            return result;
        }
        Arrays.sort(nums);
        for(int i=0 ; i<nums.length ; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            findTriplets(nums, i, result);
        }

        return result;
    }

    private void findTriplets(int[] nums, int i, List<List<Integer>> result){
        int l = i + 1, r = nums.length - 1;

        while(l < r){
            int cur = nums[i] + nums[l] + nums[r];

            if(cur == 0){
                result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                l++;
                r--;
                while(l<r && nums[l] == nums[l-1]){
                    l++;
                }
                while(l<r && nums[r] == nums[r+1]){
                    r--;
                }
            } else if(cur < 0){
                l++;
            } else {
                r--;
            }
        }
    }
}
