class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length < 1) return intervals;

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        int[] prev = intervals[0];
        for(int i=1; i<intervals.length; i++){
            int[] cur = intervals[i];

            if(prev[1] < cur[0]){
                result.add(prev);
                prev = cur;
            } else {
                prev[0] = Math.min(cur[0], prev[0]);
                prev[1] = Math.max(cur[1], prev[1]);
            }
        }

        result.add(prev);

        return result.toArray(new int[result.size()][]);
    }
}
