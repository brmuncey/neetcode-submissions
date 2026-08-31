class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int[] prev = intervals[0];
        for(int[] cur : intervals){
            if(prev[1] >= cur[0]){
                prev[0] = Math.min(prev[0], cur[0]);
                prev[1] = Math.max(prev[1], cur[1]);
            } else {
                res.add(prev);
                prev = cur;
            }
        }
        res.add(prev);

        return res.toArray(new int[res.size()][]);
    }
}
