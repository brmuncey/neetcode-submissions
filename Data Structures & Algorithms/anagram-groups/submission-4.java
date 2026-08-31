class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] letters = s.toCharArray();
            Arrays.sort(letters);
            String key =  new String(letters);
            List<String> cur = map.getOrDefault(key, new ArrayList<>());
            cur.add(s);
            map.put(key, cur);
        }

        return new ArrayList<>(map.values());
    }
}
