class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max=0, l=0;
        for(int r=0; r<s.length(); r++){
            char rc = s.charAt(r);
            while(set.contains(rc)){
                set.remove(s.charAt(l++));
            }
            set.add(rc);
            max = Math.max(set.size(), max);
        }
        return max;
    }
}
