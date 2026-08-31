class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> set, int i){
        if(i >= nums.length){
            res.add(new ArrayList<>(set));
            return;
        }

        set.add(nums[i]);
        dfs(nums, res, set, i+1);
        set.remove(set.size() - 1);
        dfs(nums, res, set, i+1);
    }
}
