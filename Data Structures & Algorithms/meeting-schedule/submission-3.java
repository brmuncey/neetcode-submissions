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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals == null || intervals.isEmpty()) return true;
        
        Collections.sort(intervals, (a,b) -> a.start - b.start);
        Interval prev = intervals.get(0);
        for(int i=1; i<intervals.size(); i++){
            Interval cur = intervals.get(i);
            if(prev.end > cur.start) return false;
            prev = cur;
        }
        return true;
    }
}
