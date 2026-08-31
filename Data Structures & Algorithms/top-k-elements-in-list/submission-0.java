class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(Integer x : nums){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length+1];
        for(Integer key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] result = new int[k];
        int f = 0;
        for(int i=bucket.length-1 ; i >= 0 ; i--){
            if(bucket[i] != null){
                for(int j=0 ; j<bucket[i].size() && k > f ; j++){
                    result[f] = bucket[i].get(j);
                    f++;
                }
            }
        }

        return result;
    }
}
