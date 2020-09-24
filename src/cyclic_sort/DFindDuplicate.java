package cyclic_sort;

import java.util.ArrayList;
import java.util.Arrays;

// We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’.
// The array has only one duplicate but it can be repeated multiple times.
// Find that duplicate number without using any extra space. You are, however, allowed to modify the input array.
public class DFindDuplicate {

    public static int find(ArrayList<Integer> input) {
        int i = 1;
        while (i <= input.size()) {
            if (!input.get(i - 1).equals(input.get(input.get(i - 1) - 1))) {
                int temp = input.get(i - 1);
                input.set(i - 1, input.get(input.get(i - 1) - 1));
                input.set(temp - 1, temp);
            } else {
                i++;
            }
        }

        for (i = 0; i < input.size(); i++) {
            if (input.get(i) != i + 1) {
                return input.get(i);
            }
        }

        return input.size();
    }

    public static void main(String[] args) {
        System.out.println("Response : " + DFindDuplicate.find(new ArrayList<>(Arrays.asList(1, 4, 4, 3, 2))));
        System.out.println("Response : " + DFindDuplicate.find(new ArrayList<>(Arrays.asList(2, 1, 3, 3, 5, 4))));
        System.out.println("Response : " + DFindDuplicate.find(new ArrayList<>(Arrays.asList(2, 4, 1, 4, 4))));
    }

}
