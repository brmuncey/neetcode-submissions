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
        Collections.sort(intervals, (a,b) -> a.start - b.start);
        Interval p = null;
        for(Interval i : intervals){
            if(p != null && p.end > i.start) return false;
            p = i;
        }

        return true;
    }
}
