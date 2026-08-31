class Solution {
    public int trap(int[] height) {
        if(height == null || height.length < 3){
            return 0;
        }

        int l=0, r=height.length-1, result = 0;
        int lMax = height[l], rMax = height[r];

        while( l < r ){
            if(lMax < rMax){
                l++;
                lMax = Math.max(height[l], lMax);
                result += lMax - height[l];
            } else {
                r--;
                rMax = Math.max(height[r], rMax);
                result += rMax - height[r];
            }
        }

        return result;
    }
}
