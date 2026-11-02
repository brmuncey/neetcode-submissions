class Solution {

    class Entry {
        
        int key;
        int count;

        public Entry(int key, int count){
            this.key = key;
            this.count = count;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums) map.put(x, map.getOrDefault(x, 0) + 1);

        PriorityQueue<Entry> pq = new PriorityQueue<>((a,b) -> a.count - b.count);
        for(Integer key : map.keySet()){
            pq.offer(new Entry(key, map.get(key)));
            while(pq.size() > k) pq.poll();
        }

        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = pq.poll().key;
        }

        return res;
    }
}
