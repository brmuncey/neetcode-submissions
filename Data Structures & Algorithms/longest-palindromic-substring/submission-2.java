class Solution {
    public String longestPalindrome(String s) {
        String res = "";

        for(int i=0; i<s.length(); i++){
            String odd = helper(s, i, i);
            String even = helper(s, i, i+1);

            if(odd.length() > res.length()) {
                res = odd;
            }
            if(even.length() > res.length()) {
                res = even;
            }
        }

        return res;
    }

    private String helper(String s, int l, int r){
        String res = "";
        int max = 0;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            if(r - l + 1 > max){
                max = r - l + 1;
                res = s.substring(l, r + 1);
            }
            l--;
            r++;
        }
        return res;
    }
}
