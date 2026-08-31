class Solution {
    public int mySqrt(int x) {
        if(x < 2) return x;

        long num;
        int l=2, r=x/2, m=0;
        while(l <= r){
            m = l + (r-l)/2;
            num = (long)m * m;
            if(num == x) return m;

            if(num < x) l = m + 1;
            else r = m - 1;
        }

        return r;
    }
}