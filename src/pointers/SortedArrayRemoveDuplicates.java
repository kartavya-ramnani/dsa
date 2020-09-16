package pointers;

import sliding_window.AverageOfContiguousSubArray;

import java.util.ArrayList;
import java.util.Arrays;

//Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space;
// after removing the duplicates in-place return the new length of the array.
public class SortedArrayRemoveDuplicates {

    public static int removeDuplicates(ArrayList<Integer> input) {
        if (input.size() <= 1)
            return input.size();

        int numberOfDuplicates = 0;
        for (int i = 0; i < input.size() - 1; i++) {
            if (input.get(i).equals(input.get(i + 1))) {
                numberOfDuplicates++;
            }
        }

        return input.size() - numberOfDuplicates;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(2, 3, 3, 3, 6, 9, 9));
        int response = SortedArrayRemoveDuplicates.removeDuplicates(input);
        System.out.println(response);
        input = new ArrayList<>(Arrays.asList(2, 2, 2, 11));
        response = SortedArrayRemoveDuplicates.removeDuplicates(input);
        System.out.println(response);
    }

}
