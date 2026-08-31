class Solution {
    public int trap(int[] height) {
        int l=0,r=height.length-1;
        int count = 0, lmax = 0, rmax = 0;
        while(l < r){
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);

            if(lmax < rmax){
                count += lmax - height[l];
                l++;
            } else {
                count += rmax - height[r];
                r--;
            }
        }
        return count;
    }
}
