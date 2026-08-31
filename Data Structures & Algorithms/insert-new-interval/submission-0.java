class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> temp = new ArrayList<>();
        int i=0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            temp.add(intervals[i++]);
        }

        while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        temp.add(newInterval);

        while(i < intervals.length) {
            temp.add(intervals[i++]);
        }

        return temp.toArray(new int[temp.size()][]);

    }
}
