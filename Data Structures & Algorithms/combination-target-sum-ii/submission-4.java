class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(candidates);
        dfs(candidates, target, result, new ArrayList<>(), 0, 0);
        return new ArrayList<>(result);
    }

    private void dfs(int[] nums, int target, Set<List<Integer>> result, List<Integer> cur, int i, int total){
        if(total == target){
            result.add(new ArrayList<>(cur));
            return;
        }
        if(i >= nums.length || total > target) return;

        cur.add(nums[i]);
        dfs(nums, target, result, cur, i+1, total + nums[i]);
        cur.remove(cur.size() - 1);
        while(i + 1 < nums.length && nums[i] == nums[i+1]) i++;
        dfs(nums, target, result, cur, i + 1, total);
    }
}