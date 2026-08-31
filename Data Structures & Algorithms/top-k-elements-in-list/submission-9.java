class Entry {

    int val;
    int count;

    public Entry(int val, int count){
        this.val = val;
        this.count = count;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for(int x : nums) counts.put(x, counts.getOrDefault(x, 0) + 1);

        PriorityQueue<Entry> pq = new PriorityQueue<>((a,b) -> a.count - b.count);
        for(int r : counts.keySet()){
            pq.offer(new Entry(r, counts.get(r)));
            while(pq.size() > k) pq.poll();
        }

        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = pq.poll().val;
        }

        return res;
    }
}
