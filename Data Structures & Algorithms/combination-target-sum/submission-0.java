class Solution {    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, new ArrayList<>(), 0, target, res, nums);
        return res;
    }

    private void dfs(int i, List<Integer> cur, int total, int target,  List<List<Integer>> result, int[] nums){
        if(total == target) {
            result.add(new ArrayList<>(cur));
            return;
        }
        if(i >= nums.length || total > target) return;

        cur.add(nums[i]);
        dfs(i, cur, total + nums[i], target, result, nums);
        cur.remove(cur.size() - 1);
        dfs(i + 1, cur, total, target, result, nums);
    }
}
