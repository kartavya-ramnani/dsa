package cyclic_sort;

import java.util.ArrayList;
import java.util.Arrays;

// We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
// The array originally contained all the numbers from 1 to ‘n’, but due to a data error,
// one of the numbers got duplicated which also resulted in one number going missing. Find both these numbers.
public class FFindCorruptPair {

    public static ArrayList<Integer> find(ArrayList<Integer> input) {
        int i = 1;
        ArrayList<Integer> answers = new ArrayList<>();
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
                answers.add(input.get(i));
                answers.add(i + 1);
                return answers;
            }
        }

        return answers;
    }

    public static void main(String[] args) {
        System.out.println("Response : " + FFindCorruptPair.find(new ArrayList<>(Arrays.asList(3, 1, 2, 5, 2))));
        System.out.println("Response : " + FFindCorruptPair.find(new ArrayList<>(Arrays.asList(3, 1, 2, 3, 6, 4))));
    }

}
