class Solution {
    public int rob(int[] nums) {
        int one = 0;
        int two = 0;
        for(int x : nums){
            int temp = Math.max(one + x, two);
            one = two;
            two = temp;
        }
        return two;
    }
}
