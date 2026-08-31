class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int l=0, max=0, swaps = 0;
        for(int i=0; i<s.length(); i++){
            char rc = s.charAt(i);
            map.put(rc, map.getOrDefault(rc, 0) + 1);
            swaps = Math.max(swaps, map.get(rc));
            while(i - l + 1 - swaps > k){
                char lc = s.charAt(l++);
                map.put(lc, map.get(lc) - 1);
            }
            max = Math.max(max, i - l + 1);
        }
        return max;
    }
}
