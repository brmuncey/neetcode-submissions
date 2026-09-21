class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l=0, max=0;
        for(int i=0; i<s.length(); i++){
            char rc = s.charAt(i);
            while(set.contains(rc)){
                char lc = s.charAt(l++);
                set.remove(lc);
            }
            set.add(rc);
            max = Math.max(max, i - l + 1);
        }
        return max;
    }
}
