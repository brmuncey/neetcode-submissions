class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        for(int x : stones) maxHeap.offer(x);

        while(!maxHeap.isEmpty() && maxHeap.size() > 1){
            int one = maxHeap.poll();
            int two = maxHeap.poll();

            if(one - two != 0) maxHeap.offer(one - two);
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
