class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 0){
            return 0;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        for(Integer x : stones){
            maxHeap.add(x);
        }

        while(maxHeap.size() > 1){
            int one = maxHeap.poll();
            int two = maxHeap.poll();

            if(one > two){
                maxHeap.add(one - two);
            } 
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
