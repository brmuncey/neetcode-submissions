class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> dict = new HashMap<>();
        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            List<String> temp = dict.getOrDefault(key, new ArrayList<>());
            temp.add(s);
            dict.put(key, temp);
        }

        List<List<String>> result = new ArrayList<>();
        for(String key : dict.keySet()) {
            result.add(dict.get(key));
        }

        return result;
    }
}
