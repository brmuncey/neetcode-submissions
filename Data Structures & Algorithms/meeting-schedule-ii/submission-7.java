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
        Collections.sort(intervals, (a,b) -> a.start - b.start);
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b) -> a.end - b.end);
        int max = 0;
        for(Interval x : intervals){
            while(!pq.isEmpty() && pq.peek().end <= x.start) pq.poll();
            pq.offer(x);
            max = Math.max(pq.size(), max);
        }
        return max;
    }
}
