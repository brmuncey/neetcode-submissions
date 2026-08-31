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
        if(intervals == null || intervals.size() < 1) return 0;
        int rooms = 0;
        Collections.sort(intervals, (a,b) -> a.start - b.start);
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a,b) -> a.end - b.end);
        for(Interval i : intervals){
            while(!minHeap.isEmpty() && minHeap.peek().end <= i.start){
                minHeap.poll();
            }
            minHeap.offer(i);
            rooms = Math.max(minHeap.size(), rooms);
        }
        return rooms;
    }
}
