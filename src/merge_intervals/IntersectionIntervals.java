package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Given two lists of intervals, find the intersection of these two lists.
// Each list consists of disjoint intervals sorted on their start time.
// Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
// Output: [2, 3], [5, 6], [7, 7]
// Explanation: The output list contains the common intervals between the two lists.
public class IntersectionIntervals {

    public static ArrayList<Interval> intersectionTwoIntervalsList(ArrayList<Interval> list1, ArrayList<Interval> list2) {

        ArrayList<Interval> intersectionList = new ArrayList<>();
        int list1Index = 0;
        int list2Index = 0;

        while (list1Index < list1.size() && list2Index < list2.size()) {
            int startList1 = list1.get(list1Index).start;
            int endList1 = list1.get(list1Index).end;
            int startList2 = list2.get(list2Index).start;
            int endList2 = list2.get(list2Index).end;

            if ((startList1 > startList2 && startList1 > endList2)) {
                list2Index++;
            } else if (startList1 < startList2 && endList1 < startList2) {
                list1Index++;
            } else {
                int start = Integer.max(startList1, startList2);
                int end = Integer.min(endList1, endList2);
                intersectionList.add(new Interval(start, end));
                if (end == endList1) {
                    list1Index++;
                }
                if (end == endList2) {
                    list2Index++;
                }
            }
        }

        return intersectionList;
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals1 = new ArrayList<>(Arrays.asList(new Interval(1, 3), new Interval(5, 6),
                new Interval(7, 9)));
        ArrayList<Interval> intervals2 = new ArrayList<>(Arrays.asList(new Interval(2, 3), new Interval(5, 7)));
        List<Interval> response = IntersectionIntervals.intersectionTwoIntervalsList(intervals1, intervals2);
        System.out.println("Response : ");
        for (Interval interval : response) {
            System.out.println("[" + interval.start + ", " + interval.end + "] ");
        }

        intervals1 = new ArrayList<>(Arrays.asList(new Interval(1, 3), new Interval(5, 7),
                new Interval(9, 12)));
        intervals2 = new ArrayList<>(Collections.singletonList(new Interval(5, 10)));
        response = IntersectionIntervals.intersectionTwoIntervalsList(intervals1, intervals2);
        System.out.println("Response : ");
        for (Interval interval : response) {
            System.out.println("[" + interval.start + ", " + interval.end + "] ");
        }
    }

}
