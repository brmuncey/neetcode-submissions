class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> cur, int i){
        if(i >= nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        dfs(nums, res, cur, i+1);
        cur.remove(cur.size() - 1);
        dfs(nums, res, cur, i+1);
    }
}
