package binary_search;

import java.util.ArrayList;
import java.util.Arrays;

// Given a sorted array of numbers, find if a given number ‘key’ is present in the array.
// Though we know that the array is sorted, we don’t know if it’s sorted in ascending or descending order.
// You should assume that the array can have duplicates.
//
//Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1.
public class AOrderAgnosticSearch {

    // Approach : Checking if
    public static int search(ArrayList<Integer> input, int key) {
        if (input == null || input.size() == 0) {
            return -1;
        }
        boolean isAscending = true;
        int start = 0, end = input.size() - 1;
        if (input.get(end) < input.get(start)) {
            isAscending = false;
        }

        while (start <= end) {
            // Doing int mid = (lo + hi) / 2; is prone to overflow. Instead int mid = lo + (hi - lo) / 2
            int middle = start + (end - start) / 2;

            if (input.get(middle) == key) {
                return middle;
            }

            if (isAscending) {
                if (input.get(middle) > key) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            } else {
                if (input.get(middle) > key) {
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        System.out.println("Key : " + AOrderAgnosticSearch.search(new ArrayList<>(Arrays.asList(4, 6, 10)), 10));
        System.out.println("Key : " + AOrderAgnosticSearch.search(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)), 5));
        System.out.println("Key : " + AOrderAgnosticSearch.search(new ArrayList<>(Arrays.asList(10, 6, 4)), 10));
        System.out.println("Key : " + AOrderAgnosticSearch.search(new ArrayList<>(Arrays.asList(4, 6, 10)), 11));
    }


}
