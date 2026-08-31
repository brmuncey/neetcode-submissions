class Solution {
    public int characterReplacement(String s, int k) {
        int l=0, max=0, result=0;
        Map<Character, Integer> map = new HashMap<>();
        for(int r=0; r<s.length(); r++) {
            Character rc = s.charAt(r);
            map.put(rc, map.getOrDefault(rc, 0) + 1);
            max = Math.max(max, map.get(rc));

            while((r - l + 1) - max > k){
                Character lc = s.charAt(l);
                map.put(lc, map.get(lc) - 1);
                l++;
            }

            result = Math.max(result, r - l + 1);
        }

        return result;
    }
}
