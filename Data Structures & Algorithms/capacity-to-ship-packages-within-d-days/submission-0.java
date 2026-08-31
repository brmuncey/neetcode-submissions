class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l=0, r=0;
        for(int w : weights) {
            l = Math.max(l, w);
            r += w;
        }

        while(l < r){
            int m = l + (r - l)/2;

            int totalDays = 1, currentWeight = 0;
            for(int w : weights) {
                if (currentWeight + w > m) {
                    totalDays++;
                    currentWeight = 0;
                }
                currentWeight += w;
            }

            if(totalDays > days){
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}