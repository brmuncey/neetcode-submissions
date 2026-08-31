class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String res = "";
        for(int i=0; i<s.length(); i++){
            String even = find(s, i, i);
            String odd = find(s, i, i+1);

            if(even.length() > max){
                max = even.length();
                res = even;
            }

            if(odd.length() > max){
                max = odd.length();
                res = odd;
            }
        }

        return res;
    }

    private String find(String s, int l, int r){
        String res = "";
        while(l >= 0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            res = s.substring(l, r+1);
            l--;
            r++;
        }
        return res;
    }
}
