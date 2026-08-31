class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1, r=1;
        for(int p : piles) if(p > r) r = p;

        while(l < r){
            int m = (l+r)/2;
            int hours = 0;

            for(int p : piles) hours += Math.ceil((double) p / m);

            if(hours <= h){
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }
}
