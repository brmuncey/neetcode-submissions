class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        int l=0, i=0;
        int[] res = new int[nums.length - k + 1];
        for(int r=0; r<nums.length; r++){
            maxHeap.offer(nums[r]);
            if(r >= k - 1){
                res[i++] = maxHeap.peek();
                maxHeap.remove(nums[l++]);
            }
        }
        return res;
    }
}
