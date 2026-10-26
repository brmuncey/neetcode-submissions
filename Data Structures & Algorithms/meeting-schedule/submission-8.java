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

        Interval prev = null;
        for(Interval cur : intervals){
            if(prev != null && prev.end > cur.start) return false;
            prev = cur;
        }

        return true;
    }
}
