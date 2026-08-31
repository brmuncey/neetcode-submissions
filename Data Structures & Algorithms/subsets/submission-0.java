class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, int i, List<Integer> cur){
        if(i >= nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);
        dfs(nums, res, i+1, cur);
        cur.remove(cur.size() - 1);
        dfs(nums, res, i+1, cur);
    }
}
