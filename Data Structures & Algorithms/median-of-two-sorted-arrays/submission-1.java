class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> merged = new ArrayList<>();
        for(int x : nums1) merged.add(x);
        for(int x : nums2) merged.add(x);
        Collections.sort(merged);

        int len = merged.size(), mid = len / 2;
        if(len % 2 == 0) return (merged.get(mid - 1) + merged.get(mid)) / 2.0;
        return merged.get(len/2);
    }
}
