class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        int i=0; 
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            result.add(intervals[i++]);
        }

        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i++][1], newInterval[1]);
        }

        result.add(newInterval);

        while(i < intervals.length){
            result.add(intervals[i++]);
        }

        return result.toArray(new int[result.size()][]);
    }
}
