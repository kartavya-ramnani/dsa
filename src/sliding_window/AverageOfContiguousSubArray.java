package sliding_window;

import java.util.ArrayList;
import java.util.Arrays;

// Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
public class AverageOfContiguousSubArray {

    /**
     * @param arr          : Input Array
     * @param subArraySize : 'K'
     * @return : Array of average of all contiguous subarrays of size 'K'
     */
    public static ArrayList<Double> calculateAverage(ArrayList<Double> arr, int subArraySize) {

        // subArraySize must be less than arr size
        if (arr.size() < subArraySize) {
            // returning an empty list
            return new ArrayList<>();
        }

        ArrayList<Double> averageList = new ArrayList<>();

        Double firstSum = 0.0;

        // calculating sum of the first K elements
        for (int i = 0; i < subArraySize; i++) {
            firstSum += arr.get(i);
        }

        double firstAverage = firstSum / subArraySize;
        averageList.add(firstAverage);

        // sliding window arrives
        for (int i = subArraySize; i < arr.size(); i++) {
            firstSum = firstSum - arr.get(i - subArraySize) + arr.get(i);
            firstAverage = firstSum / subArraySize;
            averageList.add(firstAverage);
        }

        return averageList;
    }

    public static void main(String[] args) {
        // Running Average Contiguous
        ArrayList<Double> input = new ArrayList<Double>(Arrays.asList(1.0, 3.0, 2.0, 6.0, -1.0, 4.0, 1.0, 8.0, 2.0));
        ArrayList<Double> response = AverageOfContiguousSubArray.calculateAverage(input, 5);
        System.out.println(response);
    }
}
