class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        search(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    private void search(int[] nums, int target, List<List<Integer>> res, List<Integer> cur, int ind){
        if(target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if(target < 0 || ind >= nums.length) return;

        cur.add(nums[ind]);
        search(nums, target - nums[ind], res, cur, ind + 1);
        cur.remove(cur.size() - 1);
        while(ind + 1 < nums.length && nums[ind] == nums[ind + 1]) ind++;
        search(nums, target, res, cur, ind + 1);
    }
}