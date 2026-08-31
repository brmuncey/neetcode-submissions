class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();

        int l=0, r=0;

        while(r<n){
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[r]){
                queue.pollLast();
            }
            queue.add(r);

            if(l > queue.peekFirst()){
                queue.pollFirst();
            }

            if(r + 1 >= k){
                result[l] = nums[queue.peekFirst()];
                l++;
            }
            r++;
        }

        return result;
    }
}
