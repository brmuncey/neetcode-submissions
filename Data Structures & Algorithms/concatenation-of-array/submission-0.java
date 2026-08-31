class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] res = new int[nums.length * 2];

        int x=0;
        for(int n : nums) res[x++] = n;
        for(int n : nums) res[x++] = n;

        return res;
    }
}