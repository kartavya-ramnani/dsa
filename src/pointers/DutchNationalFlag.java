package pointers;

import java.util.ArrayList;
import java.util.Arrays;

// Given an array containing 0s, 1s and 2s, sort the array in-place.
// You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.
public class DutchNationalFlag {

    public static ArrayList<Integer> sortDNF(ArrayList<Integer> input) {
        int low = 0, high = input.size() - 1;
        int i = 0;
        while (i <= high) {
            if (input.get(i) == 0) {
                int temp = input.get(low);
                input.set(low, 0);
                input.set(i, temp);
                low++;
                i++;
            } else if (input.get(i) == 1) {
                i++;
            } else {
                int temp = input.get(high);
                input.set(high, 2);
                input.set(i, temp);
                high--;
            }
        }

        return input;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 0, 2, 1, 0));
        System.out.println("Response : " + DutchNationalFlag.sortDNF(input));
        input = new ArrayList<>(Arrays.asList(2, 2, 0, 1, 2, 0));
        System.out.println("Response : " + DutchNationalFlag.sortDNF(input));
    }


}
