class Solution {
    public int trap(int[] height) {
        int l=0, r=height.length-1;
        int lMax=height[l], rMax=height[r], count=0;
        while(l < r){
            lMax = Math.max(height[l], lMax);
            rMax = Math.max(height[r], rMax);

            if(height[l] < height[r]){
                count += lMax - height[l++];
            } else {
                count += rMax - height[r--];
            }
        }
        return count;
    }
}
