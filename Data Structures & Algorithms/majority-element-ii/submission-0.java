class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int limit = nums.length/3;

        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) map.put(n, map.getOrDefault(n, 0)+1);

        List<Integer> res = new ArrayList<>();
        for(int x : map.keySet()){
            if(map.get(x) > limit) res.add(x);
        }
        return res;
    }
}