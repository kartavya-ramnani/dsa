package sliding_window;

import java.util.ArrayList;
import java.util.Arrays;

// Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray
// whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
// This uses sliding window technique without fixed size of the window.
public class MinSizeSubArraySum {

    public static int calculateMinSize(ArrayList<Double> arr, double sum) {

        // if it is an empty array and the sum is zero as positive numbers are given
        if (arr.size() == 0 || sum == 0) {
            return 0;
        }

        int windowStart = 0, minSize = arr.size() + 1;
        double windowSum = 0.0;
        for (int windowEnd = 0; windowEnd < arr.size(); windowEnd++) {
            windowSum += arr.get(windowEnd);
            while (windowSum >= sum) {
                if (minSize > (windowEnd - windowStart + 1)) {
                    minSize = (windowEnd - windowStart + 1);
                }
                windowSum -= arr.get(windowStart);
                windowStart++;
            }
        }

        if (minSize > arr.size() + 1) {
            return 0;
        }

        return minSize;
    }

    public static void main(String args[]) {
        // Running Average Contiguous
        ArrayList<Double> input = new ArrayList<Double>(Arrays.asList(2.0, 1.0, 5.0, 2.0, 3.0, 2.0));
        int response = MinSizeSubArraySum.calculateMinSize(input, 7);
        System.out.println("response : " + response);
        input = new ArrayList<Double>(Arrays.asList(2.0, 1.0, 5.0, 2.0, 8.0));
        response = MinSizeSubArraySum.calculateMinSize(input, 7);
        System.out.println("response : " + response);
    }

}
