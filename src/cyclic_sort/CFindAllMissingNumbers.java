package cyclic_sort;

import java.util.ArrayList;
import java.util.Arrays;

public class CFindAllMissingNumbers {

    public static ArrayList<Integer> findAll(ArrayList<Integer> input) {
        int i = 1;
        ArrayList<Integer> answer = new ArrayList<>();
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
                answer.add(i + 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("Response : " + CFindAllMissingNumbers.findAll(new ArrayList<>(Arrays.asList(2, 3, 1, 8, 2, 3, 5, 1))));
        System.out.println("Response : " + CFindAllMissingNumbers.findAll(new ArrayList<>(Arrays.asList(2, 4, 1, 2))));
        System.out.println("Response : " + CFindAllMissingNumbers.findAll(new ArrayList<>(Arrays.asList(2, 3, 2, 1))));
        System.out.println("Response : " + CFindAllMissingNumbers.findAll(new ArrayList<>(Arrays.asList(1, 1, 1, 1))));
    }

}
