class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for(String x : strs){
            char[] chars = x.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            List<String> temp = map.getOrDefault(key, new ArrayList<>());
            temp.add(x);
            map.put(key, temp);
        }

        List<List<String>> result = new ArrayList<>();
        for(String key : map.keySet()){
            result.add(map.get(key));
        }

        return result;
    }
}
