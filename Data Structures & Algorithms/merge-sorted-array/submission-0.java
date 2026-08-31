class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[nums1.length];

        int o=0, t=0, p=0;

        while(o < m || t < n){
            if(o < m && t < n){
                if(nums1[o] < nums2[t]) temp[p] = nums1[o++];
                else temp[p] = nums2[t++];
            } else if(o < m && t >= n){
                temp[p] = nums1[o++];
            } else {
                temp[p] = nums2[t++];
            }
            p++;
        }

        for(int i=0; i<nums1.length; i++){
            nums1[i] = temp[i];
        }
    }
}