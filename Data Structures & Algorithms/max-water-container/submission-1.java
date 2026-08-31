class Solution {
    public int maxArea(int[] heights) {
        int max = 0, l=0, r=heights.length - 1;
        while(l < r) {
            int min = Math.min(heights[l], heights[r]);
            max = Math.max(max, min * (r - l));

            if(heights[l] < heights[r]){
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
