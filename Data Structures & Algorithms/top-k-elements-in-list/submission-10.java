class Entry {
    int key;
    int count;
    public Entry(int key, int count){
        this.key = key;
        this.count = count;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];

        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums) map.put(x, map.getOrDefault(x, 0) + 1);

        PriorityQueue<Entry> pq = new PriorityQueue<>((a,b) -> a.count - b.count);
        for(int key : map.keySet()){
            pq.offer(new Entry(key, map.get(key)));
            while(!pq.isEmpty() && pq.size() > k) pq.poll();
        }

        for(int i=0; i<k; i++){
            res[i] = pq.poll().key;
        }
        return res;
    }
}
