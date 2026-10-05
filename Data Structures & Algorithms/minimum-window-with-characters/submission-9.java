class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        int l=0, min=s.length() + 1, seen=0, start=0;
        for(int r=0; r<s.length(); r++){
            char rc = s.charAt(r);
            if(map.containsKey(rc)){
                map.put(rc, map.get(rc) - 1);
                if(map.get(rc) == 0) seen++;
            }

            while(seen == map.size()){
                if(r - l + 1 < min){
                    start = l;
                    min = r - l + 1;
                }
                char lc = s.charAt(l++);
                if(map.containsKey(lc)){
                    if(map.get(lc) == 0) seen--;
                    map.put(lc, map.get(lc) + 1);
                }
            }
        }

        return min > s.length() ? "" : s.substring(start, start + min);
    }
}
