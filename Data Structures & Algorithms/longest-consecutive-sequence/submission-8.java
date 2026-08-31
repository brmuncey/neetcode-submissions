class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(Integer x : nums) set.add(x);

        int count = 0;
        for(int x : set){
            if(set.contains(x-1)) continue;
            int t = x, c = 0;
            while(set.contains(t)){
                c++;
                t++;
            }
            count = Math.max(count, c);
        }

        return count;
    }
}
