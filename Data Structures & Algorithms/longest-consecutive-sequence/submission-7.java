class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(Integer x : nums){
            set.add(x);
        }

        int max = 0;
        for(Integer x : set){
            if(set.contains(x-1)) continue;

            int i = x, count=0;
            while(set.contains(i)){
                count++;
                i++;
            }
            max = Math.max(count, max);
        }

        return max;   
    }
}
