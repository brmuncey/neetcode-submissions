class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, List<Integer> cur, int i){
        if(i >= nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        dfs(res, nums, cur, i + 1);
        cur.remove(cur.size() - 1);
        dfs(res, nums, cur, i + 1);
    }
}
