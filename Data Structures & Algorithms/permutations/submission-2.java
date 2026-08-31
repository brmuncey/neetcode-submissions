class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> cur, int i){
        if(i >= nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int n : nums){
            if(cur.contains(n)) continue;
            cur.add(n);
            dfs(nums, res, cur, i+1);
            cur.remove(cur.size() - 1);
        }
    }
}
