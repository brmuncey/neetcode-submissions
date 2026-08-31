class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++){
            count += validate(s, i, i);
            count += validate(s, i, i+1);
        }
        return count;
    }

    private int validate(String s, int l, int r){
        int c = 0;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            c++;
            l--;
            r++;
        }
        return c;
    }
}
