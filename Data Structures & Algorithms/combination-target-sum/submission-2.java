class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, target, result, 0, 0, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, int target, List<List<Integer>> result, int i, int cur, List<Integer> it){
        if(cur == target) {
            result.add(new ArrayList<>(it));
            return;
        }

        if(i >= nums.length || cur > target) return;

        it.add(nums[i]);
        dfs(nums, target, result, i, cur + nums[i], it);
        it.remove(it.size() - 1);
        dfs(nums, target, result, i+1, cur, it);
    }
}
