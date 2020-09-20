package merge_intervals;

import java.util.*;

// Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the appointments.
// Appointments: [[1,4], [2,5], [7,9]]
// Output: false
// Explanation: Since [1,4] and [2,5] overlap, a person cannot attend both of these appointments.
//
// Appointments: [[6,7], [2,4], [8,12]]
// Output: true
// Explanation: None of the appointments overlap, therefore a person can attend all of them
public class ConflictingAppointments {

    public static boolean isPossible(ArrayList<Interval> intervals) {

        if (intervals.size() < 2) {
            return true;
        }

        // sort the intervals
        intervals.sort(Comparator.comparingInt(a -> a.start));

        for (int i = 1; i <= intervals.size() - 1; i++) {
            if (intervals.get(i).start < intervals.get(i - 1).end) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>(Arrays.asList(new Interval(1, 4), new Interval(2, 5),
                new Interval(7, 9)));
        boolean response = ConflictingAppointments.isPossible(intervals);
        System.out.println("Is Possible : " + response);
        intervals = new ArrayList<>(Arrays.asList(new Interval(6, 7), new Interval(2, 4),
                new Interval(8, 12)));
        response = ConflictingAppointments.isPossible(intervals);
        System.out.println("Is Possible : " + response);
        intervals = new ArrayList<>(Arrays.asList(new Interval(4, 5), new Interval(2, 3), new Interval(3, 6)));
        response = ConflictingAppointments.isPossible(intervals);
        System.out.println("Is Possible : " + response);
    }

}
