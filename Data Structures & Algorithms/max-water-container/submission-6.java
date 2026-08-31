class Solution {
    public int maxArea(int[] heights) {
        int max = 0, l=0, r=heights.length-1;
        while(l<r) {
            int area = Math.min(heights[l], heights[r]) * (r - l);
            max = Math.max(max, area);
            if(heights[l] < heights[r]){
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
