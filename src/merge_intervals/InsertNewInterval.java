package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Given a list of non-overlapping intervals sorted by their start time, insert a given interval at the correct position
// and merge all necessary intervals to produce a list that has only mutually exclusive intervals.
// This is O(N) time complexity and O(N) space complexity.
// We could use MergeOverlappingIntervals but that is O(NlogN)
public class InsertNewInterval {

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval toBeInserted) {
        ArrayList<Interval> mergedIntervals = new ArrayList<>();
        int i;
        for (i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).start > toBeInserted.start || intervals.get(i).end > toBeInserted.end) {
                break;
            }
            mergedIntervals.add(intervals.get(i));
        }

        int start = Integer.min(intervals.get(i).start, toBeInserted.start);
        int end = Integer.max(intervals.get(i).end, toBeInserted.end);

        for (int j = i + 1; j < intervals.size(); j++) {
            if (intervals.get(j).start < end) {
                end = Integer.max(end, intervals.get(j).end);
            } else {
                mergedIntervals.add(new Interval(start, end));
                end = intervals.get(j).end;
                start = intervals.get(j).start;
            }
        }

        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>(Arrays.asList(new Interval(1, 3), new Interval(5, 7),
                new Interval(8, 12)));
        List<Interval> response = InsertNewInterval.insert(intervals, new Interval(4, 6));
        System.out.println("Response : ");
        for (Interval interval : response) {
            System.out.println("[" + interval.start + ", " + interval.end + "] ");
        }

        intervals = new ArrayList<>(Arrays.asList(new Interval(1, 3), new Interval(5, 7),
                new Interval(8, 12)));
        response = InsertNewInterval.insert(intervals, new Interval(4, 10));
        System.out.println("Response : ");
        for (Interval interval : response) {
            System.out.println("[" + interval.start + ", " + interval.end + "] ");
        }
    }

}
