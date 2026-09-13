class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);

        int max=0, count=0, temp=0;
        for(int x : nums){
            if(!set.contains(x - 1)){
                count=0;
                temp=x;
                while(set.contains(temp)){
                    temp++;
                    count++;
                }
                if(max < count) max = count;
            }
        }
        return max;
    }
}
