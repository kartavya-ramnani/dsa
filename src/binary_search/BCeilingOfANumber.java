package binary_search;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.ArrayList;
import java.util.Arrays;

// Given an array of numbers sorted in an ascending order, find the ceiling of a given number ‘key’.
// The ceiling of the ‘key’ will be the smallest element in the given array greater than or equal to the ‘key’.
//
// Write a function to return the index of the ceiling of the ‘key’. If there isn’t any ceiling return -1.
public class BCeilingOfANumber {

    public static int findCeiling(ArrayList<Integer> input, int key) {
        if (input == null || input.size() == 0) {
            return -1;
        }
        int start = 0, end = input.size() - 1;
        int ceilingIndex = end;

        while (start <= end) {
            // Doing int mid = (lo + hi) / 2; is prone to overflow. Instead int mid = lo + (hi - lo) / 2
            int middle = start + (end - start) / 2;
            if (input.get(middle) == key) {
                ceilingIndex = middle;
                break;
            }
            if (input.get(middle) > key) {
                if (input.get(ceilingIndex) > input.get(middle)) {
                    ceilingIndex = middle;
                }
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        return input.get(ceilingIndex) >= key ? ceilingIndex : -1;
    }

    public static void main(String[] args) {
        System.out.println("Response : " + BCeilingOfANumber.findCeiling(new ArrayList<>(Arrays.asList(4, 6, 10)), 6));
        System.out.println("Response : " + BCeilingOfANumber.findCeiling(new ArrayList<>(Arrays.asList(1, 3, 8, 10, 15)), 12));
        System.out.println("Response : " + BCeilingOfANumber.findCeiling(new ArrayList<>(Arrays.asList(4, 6, 10)), 17));
        System.out.println("Response : " + BCeilingOfANumber.findCeiling(new ArrayList<>(Arrays.asList(4, 6, 10)), -1));

    }

    // Similar Problem :
    // Given an array of numbers sorted in ascending order, find the floor of a given number ‘key’.
    // The floor of the ‘key’ will be the biggest element in the given array smaller than or equal to the ‘key’

}
