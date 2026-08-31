class Pair {
    int key;
    int count;

    public Pair(int key, int count){
        this.key = key;
        this.count = count;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for(Integer x : nums){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b) -> a.count - b.count);
        for(Integer key : map.keySet()){
            Pair p = new Pair(key, map.get(key));
            minHeap.add(p);
        }

        while(minHeap.size() > k){
            minHeap.poll();
        }

        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = minHeap.poll().key;
        }
        
        return res;
    }
}
