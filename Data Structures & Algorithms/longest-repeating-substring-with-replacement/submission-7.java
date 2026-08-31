class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int l=0, max=0, len=0;
        for(int r=0; r<s.length(); r++){
            char rc = s.charAt(r);
            map.put(rc, map.getOrDefault(rc, 0) + 1);
            max = Math.max(map.get(rc), max);
            while(r-l+1-max > k){
                char lc = s.charAt(l++);
                map.put(lc, map.get(lc) - 1);
            }
            len = Math.max(len, r-l+1);
        }
        return len;
    }
}
