package merge_intervals;

import java.util.ArrayList;
import java.util.Comparator;

// Given a list of intervals, remove all intervals that are covered by another interval in the list.
//
// Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.
//
// After doing so, return the number of remaining intervals.
// This is not like merging, we do not have to merge intervals, just remove already covered intervals.
// example : intervals = [[1,4],[3,6],[2,8]]
// answer : 2, because : [3,6] is already covered by [2,8] so no need to have [3,6]
public class HRemoveCoveredIntervals {

    class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int removeCoveredIntervals(int[][] intervals) {
        ArrayList<Interval> intervalList = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        for (int[] interval : intervals) {
            intervalList.add(new Interval(interval[0], interval[1]));
        }

        // time to sort intervals
        intervalList.sort(Comparator.comparingInt(a -> a.start));

        // time to merge intervals
        int start = intervalList.get(0).start;
        int end = intervalList.get(0).end;
        int totalIntervals = intervalList.size();

        for (int i = 1; i < intervalList.size(); i++) {
            // if the next interval is already covered by this interval
            if (end >= intervalList.get(i).end) {
                totalIntervals--;
            } else if(start == intervalList.get(i).start && end < intervalList.get(i).end) {
                // if this interval gets covered by the next interval
                totalIntervals--;
                end = Math.max(end, intervalList.get(i).end);
            } else {
                // no one covering each other, carry on.
                start = intervalList.get(i).start;
                end = intervalList.get(i).end;
            }
        }

        return totalIntervals;
    }

}
