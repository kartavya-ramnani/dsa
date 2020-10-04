package binary_search;

import java.util.ArrayList;
import java.util.Arrays;

// Given an array of numbers sorted in ascending order, find the range of a given number ‘key’.
// The range of the ‘key’ will be the first and last position of the ‘key’ in the array.
//
// Write a function to return the range of the ‘key’. If the ‘key’ is not present return [-1, -1].
public class DNumberRange {

    public static ArrayList<Integer> get(ArrayList<Integer> input, int key) {
        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(-1, -1));
        if (input == null || input.size() == 0) {
            return result;
        }
        result.set(0, getRange(input, key, false));
        if (result.get(0) == -1) {
            return result;
        }
        result.set(1, getRange(input, key, true));
        return result;
    }


    private static Integer getRange(ArrayList<Integer> input, int key, boolean findMax) {
        int start = 0, end = input.size() - 1;
        int index = -1;
        while (start <= end) {
            // Doing int mid = (lo + hi) / 2; is prone to overflow. Instead int mid = lo + (hi - lo) / 2
            int middle = start + (end - start) / 2;
            if (input.get(middle) > key) {
                end = middle - 1;
            } else if (input.get(middle) < key) {
                start = middle + 1;
            } else {
                index = middle;
                if (findMax)
                    start = middle + 1;
                else end = middle - 1;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        System.out.println("Response : " + DNumberRange.get(new ArrayList<>(Arrays.asList(4, 6, 6, 6, 9)), 6));
        System.out.println("Response : " + DNumberRange.get(new ArrayList<>(Arrays.asList(1, 3, 8, 10, 15)), 10));
        System.out.println("Response : " + DNumberRange.get(new ArrayList<>(Arrays.asList(1, 3, 8, 10, 15)), 12));
    }

}
