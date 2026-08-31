class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) set.add(n);

        int max = 0, count = 0;
        for(int n : set){
            if(!set.contains(n-1)){
                int k = n;
                while(set.contains(k)){
                    count++;
                    k++;
                }
            }
            max = Math.max(max, count);
            count = 0;
        }
        return max;

    }
}
