class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, n=gas.length;
        int[] dif = new int[n];
        for(int i=0; i<n; i++){
            dif[i] = gas[i] - cost[i];
            total += dif[i];
        }
        
        if(total < 0) return -1;

        int start = 0;
        total = 0;
        for(int i=0; i<gas.length; i++){
            total += dif[i];
            if (total < 0) {
                start = i + 1;
                total = 0;
            }

        }
        return start;
    }
}