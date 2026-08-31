class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        Map<Character,Integer> map = new HashMap<>();
        for(Character c : s1.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        int seen = 0, l=0;
        for(int i=0; i<s2.length(); i++){
            char rc = s2.charAt(i);
            if(map.containsKey(rc)){
                map.put(rc, map.get(rc) - 1);
                if(map.get(rc) == 0) seen++;
            }

            if(seen == map.size()) return true;

            if(i >= s1.length() - 1){
                char lc = s2.charAt(l++);
                if(map.containsKey(lc)){
                    if(map.get(lc) == 0) seen--;
                    map.put(lc, map.get(lc) + 1);
                }
            }
        }

        return false;
    }
}
