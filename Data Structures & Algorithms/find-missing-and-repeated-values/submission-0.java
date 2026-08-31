class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        int max = 1;
        for(int[] x : grid){
            for(int y : x){
                map.put(y, map.getOrDefault(y, 0) + 1);
                if(map.get(y) > 1) res[0] = y;
                if(y > max) max = y;
            }
        }
        
        for(int i=1; i<=max+1; i++){
            if(!map.containsKey(i)){
                res[1] = i;
                break;
            }
        }
        return res;
    }
}