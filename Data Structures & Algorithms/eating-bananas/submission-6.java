class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int r=0;
        for(int p : piles) r = Math.max(r, p);

        int l=0, min=r;
        while(l <= r){
            int k = l + (r - l)/2;

            long time = 0;
            for(int p : piles){
                time += Math.ceil((double)p / k);
            }

            if(time <= h){
                min = Math.min(k, min);
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return min;
    }
}
