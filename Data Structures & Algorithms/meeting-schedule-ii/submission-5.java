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

        int count = 0;
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a,b) -> a.end - b.end);
        for(Interval x : intervals){
            while(!minHeap.isEmpty() && x.start >= minHeap.peek().end) minHeap.poll();
            minHeap.offer(x);
            count = Math.max(count, minHeap.size());
        }
        return count;
    }
}
