class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0, max=0;
        Map<Character, Integer> map = new HashMap<>();
        for(int r=0; r<s.length(); r++){
            Character rc = s.charAt(r);
            map.put(rc, map.getOrDefault(rc, 0) + 1);
            while(l < r && map.get(rc) > 1){
                Character lc = s.charAt(l);
                map.put(lc, map.get(lc) - 1);
                if(map.get(lc) == 0){
                    map.remove(lc);
                }
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
