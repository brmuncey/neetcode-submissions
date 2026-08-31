class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];

        Map<Integer, Integer> map = new HashMap<>();
        for(Integer x : nums){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
        for(Map.Entry entry : map.entrySet()){
            minHeap.offer(entry);
            while(minHeap.size() > k){
                minHeap.poll();
            } 
        }

        for(int i=0; i<k; i++){
            arr[i] = minHeap.poll().getKey();
        }

        return arr;
    }
}
