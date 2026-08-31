class Solution { 
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void dfs(int[] nums, int target, int i, int cur, List<Integer> vals, List<List<Integer>> result){
        if(target == cur){
            result.add(new ArrayList<>(vals));
            return;
        }

        if(i >= nums.length || cur > target) return;

        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) continue;
            if (cur + nums[j] > target) break;
            vals.add(nums[j]);
            dfs(nums, target, j + 1, cur + nums[j], vals, result);
            vals.remove(vals.size() - 1);
        }
    }
}