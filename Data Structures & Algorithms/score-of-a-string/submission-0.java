class Solution {
    public int scoreOfString(String s) {
        int score = 0, n=s.length();
        for(int i=1; i<n; i++){
            score += Math.abs(s.charAt(i-1) - s.charAt(i)); 
        }
        return score;
    }
}