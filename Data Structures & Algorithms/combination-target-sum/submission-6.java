class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, target, res, new ArrayList<>(), 0, 0);
        return res;
    }

    private void dfs(int[] nums, int target, List<List<Integer>> res, List<Integer> cur, int sum, int ind){
        if(target == sum){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(ind >= nums.length || target < sum) return;

        cur.add(nums[ind]);
        dfs(nums, target, res, cur, sum + nums[ind], ind);
        cur.remove(cur.size() - 1);
        dfs(nums, target, res, cur, sum, ind + 1);
    }
}
