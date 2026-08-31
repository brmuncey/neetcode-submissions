class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) set.add(n);

        int i=0;
        while(i < nums.length){
            if(!set.contains(i)) return i;
            i++;
        }

        return nums.length;
    }
}
