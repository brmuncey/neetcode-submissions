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
        int sum=0, t=0;
        while(n > 0){
            t = n % 10;
            sum += t * t;
            n /= 10;
        }
        return sum;
    }
}
