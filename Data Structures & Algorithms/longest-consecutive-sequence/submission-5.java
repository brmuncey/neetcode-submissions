class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(Integer x : nums){
            set.add(x);
        }

        int max = 0;
        for(Integer x : set){
            if(!set.contains(x - 1)){
                int i=0;
                while(set.contains(x + i)){
                    i++;
                }
                max = Math.max(max, i);
            }
        }
        return max;
    }
}
