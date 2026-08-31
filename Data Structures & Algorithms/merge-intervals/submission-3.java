class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        int[] prev = intervals[0];
        for(int i=1; i<intervals.length; i++){
            int[] cur = intervals[i];
            if(prev[1] >= cur[0]){
                prev[0] = Math.min(prev[0], cur[0]);
                prev[1] = Math.max(prev[1], cur[1]);
            } else {
                result.add(prev);
                prev = cur;
            }
        }

        result.add(prev);

        return result.toArray(new int[result.size()][]);
    }
}
