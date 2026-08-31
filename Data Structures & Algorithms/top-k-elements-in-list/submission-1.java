class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(Integer n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length+1];
        for(Integer x : map.keySet()){
            int c = map.get(x);
            if(bucket[c] == null){
                bucket[c] = new ArrayList<>();
            }
            bucket[c].add(x);
        }

        int[] result = new int[k];
        int f=0;
        for(int i=bucket.length-1; i >= 0; i--){
            if(bucket[i] != null){
                for(int j=0; j<bucket[i].size() && k > f; j++){
                    result[f] = bucket[i].get(j);
                    f++;
                }
            }
        }
        
        return result;
    }
}
