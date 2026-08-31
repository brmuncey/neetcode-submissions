class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] sChars = s.toCharArray();
            Arrays.sort(sChars);
            String key = new String(sChars);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
