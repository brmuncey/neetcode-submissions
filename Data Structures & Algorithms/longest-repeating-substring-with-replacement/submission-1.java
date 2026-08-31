class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l=0, max=0, count=0;
        for(int r=0; r<s.length(); r++){
            Character rc = s.charAt(r);
            map.put(rc, map.getOrDefault(rc, 0) + 1);
            count = Math.max(count, map.get(rc));

            while(r - l + 1 - count > k){
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
