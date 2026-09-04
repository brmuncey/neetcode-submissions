class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int l=0, max=0;
        for(int r=0; r<s.length(); r++){
            char rc = s.charAt(r);
            map.put(rc, map.getOrDefault(rc, 0) + 1);
            while(map.size() > k){
                char lc = s.charAt(l++);
                map.put(lc, map.get(lc) - 1);
                if(map.get(lc) == 0) map.remove(lc);
            }
            max = Math.max(max, r-l+1);
        }
        return max;
    }
}
