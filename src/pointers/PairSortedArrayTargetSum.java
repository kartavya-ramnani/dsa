package pointers;

import sliding_window.AverageOfContiguousSubArray;

import java.util.ArrayList;
import java.util.Arrays;

// Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
public class PairSortedArrayTargetSum {

    public static ArrayList<Integer> findPair(ArrayList<Double> input, double targetSum) {
        int first = 0, last = input.size() - 1;

        ArrayList<Integer> result = new ArrayList<>();

        while (first < last) {
            if (input.get(first) + input.get(last) == targetSum) {
                result.add(first);
                result.add(last);
                break;
            }
            if (input.get(first) + input.get(last) > targetSum) {
                last--;
            } else {
                first++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Double> input = new ArrayList<Double>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 6.0));
        ArrayList<Integer> response = PairSortedArrayTargetSum.findPair(input, 6);
        System.out.println(response);
    }
}
