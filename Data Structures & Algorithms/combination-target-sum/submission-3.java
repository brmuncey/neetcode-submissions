class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, target, result, 0, 0, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, int target, List<List<Integer>> result, int i, int total, List<Integer> cur){
        if(total == target){
            result.add(new ArrayList<>(cur));
            return;
        }

        if(i >= nums.length || total > target) return;

        cur.add(nums[i]);
        dfs(nums, target, result, i, total + nums[i], cur);
        cur.remove(cur.size() - 1);
        dfs(nums, target, result, i+1, total, cur);
    }
}
