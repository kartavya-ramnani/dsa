package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// Given a list of intervals representing the start and end time of ‘N’ meetings,
// find the minimum number of rooms required to hold all the meetings.
// Meetings: [[4,5], [2,3], [2,4], [3,5]]
// Output: 2
// Explanation: We will need one room for [2,3] and [3,5], and another room for [2,4] and [4,5].
public class MinimumMeetingRooms {

    public static int findMin(ArrayList<Interval> meetings) {

        if (meetings == null || meetings.size() == 0) {
            return 0;
        }

        // sorting the meetings O(NlgN)
        meetings.sort(Comparator.comparingInt(a -> a.start));

        int minRooms = 0;
        PriorityQueue<Interval> minHeap = new PriorityQueue<>(meetings.size(), Comparator.comparingInt(a -> a.end));

        for (Interval meeting : meetings) {

            while (!minHeap.isEmpty() && meeting.start >= minHeap.peek().end) {
                minHeap.poll();
            }
            minHeap.offer(meeting);
            minRooms = Integer.max(minRooms, minHeap.size());
        }

        return minRooms;
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>(Arrays.asList(new Interval(4, 5), new Interval(2, 3),
                new Interval(2, 4), new Interval(3, 5)));
        int rooms = MinimumMeetingRooms.findMin(intervals);
        System.out.println("Meeting Rooms : " + rooms);
    }

}
