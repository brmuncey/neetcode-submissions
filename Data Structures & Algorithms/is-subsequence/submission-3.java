class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        if(s.length() > t.length()) return false;

        Stack<Character> stack = new Stack<>();
        for(char c : t.toCharArray()) stack.push(c);

        int seen = 0;
        for(int i=s.length() - 1; i>=0; i--){
            while(!stack.isEmpty()){
                if(s.charAt(i) == stack.pop()) {
                    seen++;
                    break;
                }
            }
        }

        return seen == s.length();
    }
}