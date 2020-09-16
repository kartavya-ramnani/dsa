package sliding_window;

import java.util.ArrayList;
import java.util.Arrays;

// Given an array of positive numbers and a positive number ‘k’,
// find the maximum sum of any contiguous subarray of size ‘k’.
public class MaxSumOfContiguousSubArray {

    /**
     * @param arr          : Input Array
     * @param subArraySize : subarray of size ‘k’
     * @return : maximum sum of any contiguous subarray of size ‘k’
     */
    public static Double calculateMaxSum(ArrayList<Double> arr, int subArraySize) {

        // subArraySize must be less than arr size
        if (arr.size() < subArraySize) {
            // returning an empty list
            return (double) 0;
        }

        Double firstSum = 0.0;
        double maxSum = 0.0;

        // calculating sum of the first K elements
        for (int i = 0; i < subArraySize; i++) {
            firstSum += arr.get(i);
        }
        maxSum = firstSum;

        // sliding window arrives
        for (int i = subArraySize; i < arr.size(); i++) {
            firstSum = firstSum - arr.get(i - subArraySize) + arr.get(i);
            if (maxSum < firstSum) {
                maxSum = firstSum;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        // Running Average Contiguous
        ArrayList<Double> input = new ArrayList<Double>(Arrays.asList(2.0, 1.0, 5.0, 1.0, 3.0, 2.0));
        Double response = MaxSumOfContiguousSubArray.calculateMaxSum(input, 3);
        System.out.println(response);
    }
}
