class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        int l=0;
        List<Integer> res = new ArrayList<>();
        for(int r=0; r<nums.length; r++){
            maxHeap.offer(nums[r]);
            if(r >= k - 1){
                res.add(maxHeap.peek());
                maxHeap.remove(nums[l++]);
            }
        }
        return res.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
