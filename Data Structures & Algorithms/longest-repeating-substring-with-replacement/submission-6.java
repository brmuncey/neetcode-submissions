class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int l=0, max=0, swaps=0;
        for(int r=0; r<s.length(); r++){
            char rc = s.charAt(r);
            map.put(rc, map.getOrDefault(rc, 0) + 1);
            swaps = Math.max(swaps, map.get(rc));

            while(r - l + 1 - swaps > k){
                char lc = s.charAt(l++);
                map.put(lc, map.get(lc) - 1);
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
