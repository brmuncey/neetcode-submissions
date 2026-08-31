class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = square(n);

        while(slow != fast){
            slow = square(slow);
            fast = square(square(fast));
        }

        return fast == 1;
    }

    private int square(int n){
        int sum = 0;
        while(n != 0){
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }
        return sum;
    }
}
