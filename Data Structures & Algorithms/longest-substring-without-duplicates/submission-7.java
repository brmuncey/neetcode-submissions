class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l=0, max=0;
        for(int r=0; r<s.length(); r++){
            char rc = s.charAt(r);
            while(set.contains(rc)){
                set.remove(s.charAt(l++));
            }
            set.add(rc);
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
