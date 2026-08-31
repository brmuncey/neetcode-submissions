class Solution {
    public int mySqrt(int x) {
        if(x < 2) return x;
        long num=0;
        int l=2, r=x/2;
        while(l <= r){
            int m=l+(r-l)/2;
            num = (long)m * m;
            if(num == x) return m;

            if(num < x) l = m + 1;
            else r = m - 1;
        }

        return r;
    }
}