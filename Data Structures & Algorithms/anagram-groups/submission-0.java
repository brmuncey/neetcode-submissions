class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> temp = map.getOrDefault(key, new ArrayList<>());
            temp.add(s);
            map.put(key, temp);
        }

        return new ArrayList<>(map.values());
    }
}
