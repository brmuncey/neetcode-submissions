class Solution {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<StringBuilder> strs = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                count = count * 10 + (c - '0');
            } else if(c =='[') {
                strs.add(sb);
                nums.add(count);
                sb = new StringBuilder();
                count = 0;
            } else if(c == ']') {
                int k = nums.pop();
                StringBuilder prev = strs.pop();
                while(k > 0){
                    prev.append(sb);
                    k--;
                }
                sb = prev;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}