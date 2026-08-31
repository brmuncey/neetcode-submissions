class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = next(n);
        while(slow != fast){
            slow = next(slow);
            fast = next(next(fast));
        }

        return fast == 1;
    }

    private int next(int n){
        int sum=0, d=0;
        while(n != 0){
            d = n%10;
            sum += d * d;
            n /= 10;
        }
        return sum;
    }
}
