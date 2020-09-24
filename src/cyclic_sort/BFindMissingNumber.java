package cyclic_sort;

import java.util.ArrayList;
import java.util.Arrays;

// We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’.
// Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.
public class BFindMissingNumber {

    public static int find(ArrayList<Integer> input) {
        int i = 0;
        while (i < input.size()) {
            if (input.get(i) < input.size() && !input.get(i).equals(input.get(input.get(i)))) {
                int temp = input.get(i);
                input.set(i, input.get(temp));
                input.set(temp, temp);
            } else {
                i++;
            }
        }

        for (i = 0; i < input.size(); i++) {
            if (input.get(i) != i) {
                return i;
            }
        }

        return input.size();
    }

    public static void main(String[] args) {
        System.out.println("Response  : " + BFindMissingNumber.find(new ArrayList<>(Arrays.asList(4, 0, 3, 1))));
        System.out.println("Response  : " + BFindMissingNumber.find(new ArrayList<>(Arrays.asList(8, 3, 5, 2, 4, 6, 0, 1))));
    }

}
