package cyclic_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

// We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
// The array has some duplicates, find all the duplicate numbers without using any extra space.
public class EFindAllDuplicates {

    public static HashSet<Integer> findAll(ArrayList<Integer> input) {
        int i = 1;
        HashSet<Integer> answer = new HashSet();
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
                answer.add(input.get(i));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("Response : " + EFindAllDuplicates.findAll(new ArrayList<>(Arrays.asList(3, 4, 4, 5, 5))));
        System.out.println("Response : " + EFindAllDuplicates.findAll(new ArrayList<>(Arrays.asList(5, 4, 7, 2, 3, 5, 3))));
        System.out.println("Response : " + EFindAllDuplicates.findAll(new ArrayList<>(Arrays.asList(5, 4, 5, 2, 3, 5, 3))));
    }

}
