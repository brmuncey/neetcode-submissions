class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(Integer x : nums){
            maxHeap.add(x);
        }

        int i=0, ans = 0;
        while(!maxHeap.isEmpty() && k != i){
            ans = maxHeap.poll();
            i++;
        }

        return ans;
    }
}
