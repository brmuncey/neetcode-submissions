class Solution {
    public boolean checkInclusion(String s1, String s2) {

        HashMap<Character, Integer> dict = new HashMap<>();
        for(Character c : s1.toCharArray()){
            dict.put(c, dict.getOrDefault(c, 0)+1);
        }

        int l=0, seen=0;
        for(int r=0 ; r<s2.length() ; r++){
            Character rc = s2.charAt(r);
            if(dict.containsKey(rc)){
                dict.put(rc, dict.get(rc) - 1);
                if(dict.get(rc) == 0){
                    seen++;
                }
            }

            if(seen == s1.length()){
                return true;
            }

            if(r >= s1.length() - 1){
                Character lc = s2.charAt(l);
                if(dict.containsKey(lc)){
                    if(dict.get(lc) == 0){
                        seen--;
                    }
                    dict.put(lc, dict.get(lc) + 1);
                }
                l++;
            }
        }
        
        return false;
    }
}
