class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int count =0, l=0;
        for(int r=0; r<s.length(); r++){
            char rc = s.charAt(r);
            map.put(rc, map.getOrDefault(rc, 0) + 1);
            while(map.get(rc) > 1 || map.size() > k){
                char lc = s.charAt(l++);
                map.put(lc, map.get(lc) - 1);
                if(map.get(lc) == 0) map.remove(lc);
            }
            if(map.size() == k) count++;
        }
        return count;
    }
}
