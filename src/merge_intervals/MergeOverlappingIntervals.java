package merge_intervals;

import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

// Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.
public class MergeOverlappingIntervals {

    public static List<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals.size() < 2) {
            return intervals;
        }

        List<Interval> mergedIntervals = new ArrayList<>();

        // sort the intervals by starting time
        intervals.sort(Comparator.comparingInt(a -> a.start));
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        // iterate and merged based on cases
        for (int i = 1; i < intervals.size(); i++) {
            // checking for overlap
            if (intervals.get(i).start < end) {
                end = Integer.max(intervals.get(i).end, end);
            } else {
                mergedIntervals.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }
        // adding the last interval
        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>(Arrays.asList(new Interval(1, 4), new Interval(2, 5),
                new Interval(3, 4), new Interval(3, 7), new Interval(8, 10)));
        List<Interval> response = MergeOverlappingIntervals.merge(intervals);
        for (Interval interval : response) {
            System.out.println("[" + interval.start + ", " + interval.end + "] ");
        }
    }

}
