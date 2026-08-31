class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++){
            count += search(s, i, i);
            count += search(s, i, i+1);
        }
        return count;
    }

    private int search(String s, int l, int r){
        int i=0;
        while(l >= 0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            i++;
            l--;
            r++;
        }
        return i;
    }
}
