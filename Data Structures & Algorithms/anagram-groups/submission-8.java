class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] key = s.toCharArray();
            Arrays.sort(key);
            String k = new String(key);
            map.putIfAbsent(k, new ArrayList<>());
            map.get(k).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
