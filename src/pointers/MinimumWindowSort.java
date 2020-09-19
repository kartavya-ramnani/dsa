package pointers;

import java.util.ArrayList;
import java.util.Arrays;

// Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.
public class MinimumWindowSort {

    public static int minWindow(ArrayList<Integer> input) {
        int low = 0, high = input.size() - 1;
        boolean lowSorted = true, highSorted = true;

        while ((low < high) && (lowSorted || highSorted)) {
            if (lowSorted && (input.get(low + 1) > input.get(low))) {
                low++;
            } else {
                lowSorted = false;
            }

            if (highSorted && (input.get(high) > input.get(high - 1))) {
                high--;
            } else {
                highSorted = false;
            }
        }

        // found the low and the high, now to check the min and max in the subarray.
        int minSub = Integer.MAX_VALUE;
        int maxSub = Integer.MIN_VALUE;
        for (int i = low; i <= high; i++) {
            if (minSub > input.get(i)) {
                minSub = input.get(i);
            }
            if (maxSub < input.get(i)) {
                maxSub = input.get(i);
            }
        }

        // readjust low and high
        for (int i = 0; i <= low; i++) {
            if (minSub < input.get(i)) {
                low = i;
            }
        }
        for (int i = high; i < input.size() - 1; i++) {
            if (maxSub > input.get(i)) {
                high = i;
            }
        }

        return high == low ? 0 : high - low + 1;
    }

    public static void main(String[] args) {
        System.out.println("Response : " + MinimumWindowSort.minWindow(new ArrayList<>(Arrays.asList(1, 2, 5, 3, 7, 10, 9, 12))));
        System.out.println("Response : " + MinimumWindowSort.minWindow(new ArrayList<>(Arrays.asList(1, 3, 2, 0, -1, 7, 10))));
        System.out.println("Response : " + MinimumWindowSort.minWindow(new ArrayList<>(Arrays.asList(1, 2, 3))));
        System.out.println("Response : " + MinimumWindowSort.minWindow(new ArrayList<>(Arrays.asList(3, 2, 1))));
    }
}
