class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> res = new ArrayList<>();

        int carry = 1;
        for(int i=digits.length-1; i>=0; i--){
            int t = digits[i] + carry;
            carry = t/10;
            res.add(t%10);
        }

        if(carry != 0) res.add(carry);

        Collections.reverse(res);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
