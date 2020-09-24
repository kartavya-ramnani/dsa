package cyclic_sort;

import java.util.ArrayList;
import java.util.Arrays;

// Write a function to sort the objects in-place on their creation sequence number in O(n)O(n) and without any extra space.

public class Sort1ToN {

    public static ArrayList<Integer> sort(ArrayList<Integer> input) {
        int i = 0;
        while (i < input.size()) {
            if (input.get(i) != i + 1) {
                int temp = input.get(i);
                input.set(i, input.get(temp - 1));
                input.set(temp - 1, temp);
            } else {
                i++;
            }
        }

        return input;
    }

    public static void main(String[] args) {
        System.out.println("Response  : " + Sort1ToN.sort(new ArrayList<>(Arrays.asList(3, 1, 5, 4, 2))));
        System.out.println("Response  : " + Sort1ToN.sort(new ArrayList<>(Arrays.asList(1, 5, 6, 3, 4, 2))));
        System.out.println("Response  : " + Sort1ToN.sort(new ArrayList<>(Arrays.asList(2, 6, 4, 3, 1, 5))));
    }
}
