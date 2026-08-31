class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        List<int[]> res = new ArrayList<>();
        int[] prev = intervals[0];
        int i=1; 
        while(i < intervals.length){
            if(prev[1] >= intervals[i][0]){
                prev[1] = Math.max(prev[1], intervals[i][1]);
            } else {
                res.add(prev);
                prev = intervals[i];
            }
            i++;
        }
        res.add(prev);

        return res.toArray(new int[res.size()][]);
    }
}
