/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals == null || intervals.isEmpty()) return 0;

        Collections.sort(intervals, (a,b) -> a.start - b.start);
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a,b) -> a.end - b.end);

        int min = 0;
        for(Interval cur : intervals){
            while(!minHeap.isEmpty() && minHeap.peek().end <= cur.start){
                minHeap.poll();
            }
            minHeap.offer(cur);
            min = Math.max(min, minHeap.size());
        }
        return min;
    }
}
