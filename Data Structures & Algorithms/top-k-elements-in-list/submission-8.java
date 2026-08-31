class Pair {

    int key;
    int value;

    public Pair(int key, int value){
        this.key = key;
        this.value = value;
    }

}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> a.value - b.value);
        for(Integer key : map.keySet()){
            minHeap.offer(new Pair(key, map.get(key)));
            while(minHeap.size() > k) minHeap.poll();
        }

        int[] res = new int[k];
        int i=0;
        while(!minHeap.isEmpty() && i < k){
            res[i++] = minHeap.poll().key;
        }
        return res;
    }
}
