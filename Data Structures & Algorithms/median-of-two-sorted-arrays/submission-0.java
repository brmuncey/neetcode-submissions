class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> merged = new ArrayList<>();
        for(int x : nums1) merged.add(x);
        for(int x : nums2) merged.add(x);
        Collections.sort(merged);

        int len = merged.size();
        if(len % 2 == 0) return ((merged.get(len / 2 - 1) + merged.get(len / 2)) / 2.0);
        return merged.get(len/2);
    }
}
