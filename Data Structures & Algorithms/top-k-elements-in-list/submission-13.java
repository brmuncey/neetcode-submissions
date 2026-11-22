class Solution {

    class Entry {
        int key;
        int val;
        public Entry(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums) map.put(x, map.getOrDefault(x, 0) + 1);

        PriorityQueue<Entry> pq = new PriorityQueue<>((a,b) -> b.val - a.val);

        for(int key : map.keySet()) pq.offer(new Entry(key, map.get(key)));
        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = pq.poll().key;
        }
        return res;
    }
}
