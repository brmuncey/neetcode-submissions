class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(Integer x : nums){
            set.add(x);
        }

        int max = 0;
        for(Integer x : set){
            if(!set.contains(x-1)){
                int len=1;
                while(set.contains(x+len)){
                    len++;
                }
                max = Math.max(max, len);
            }
        }

        return max;
    }
}
