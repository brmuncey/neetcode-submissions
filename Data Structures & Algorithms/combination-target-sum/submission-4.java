class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, target, result, new ArrayList<>(), 0, 0);
        return result;
    }

    private void dfs(int[] nums, int target, List<List<Integer>> result, List<Integer> cur, int i, int total){
        if(target == total){
            result.add(new ArrayList<>(cur));
            return;
        }

        if(total > target || i >= nums.length) return;

        cur.add(nums[i]);
        dfs(nums, target, result, cur, i, total + nums[i]);
        cur.remove(cur.size() - 1);
        dfs(nums, target, result, cur, i + 1, total);
    }
}
