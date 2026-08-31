class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(Integer i : nums){
            set.add(i);
        }

        int count = 0;
        for(Integer x : set){
            if(!set.contains(x - 1)){
                int t = x, c=0;
                while(set.contains(t)){
                    c++;
                    t++;
                }
                count = Math.max(c, count);
            }
        }
        return count;
    }
}
