package cyclic_sort;

import java.util.ArrayList;
import java.util.HashSet;

// Given an unsorted array containing numbers and a number ‘k’, find the first ‘k’ missing positive numbers in the array.
public class HFindKSmallestMissingNumbers {

    public static ArrayList<Integer> firstKMissingPositive(int[] input, int k) {
        // Solving using the cyclic sort pattern
        int i = 0;
        ArrayList<Integer> answer = new ArrayList<>();
        HashSet<Integer> missing = new HashSet<>();

        while (i < input.length) {
            if (input[i] > 0 && input[i] <= input.length && input[i] != input[input[i] - 1]) {
                int temp = input[i];
                input[i] = input[temp - 1];
                input[temp - 1] = temp;
            } else {
                i++;
            }
        }

        for (i = 0; i < input.length; i++) {
            if (input[i] != i + 1 && k > 0) {
                answer.add(i + 1);
                k--;
                missing.add(input[i]);
            }
        }

        int candidate = input.length + 1;
        while (k > 0) {
            if (!missing.contains(candidate)) {
                answer.add(candidate);
                k--;
            }
            candidate++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("Response : " + HFindKSmallestMissingNumbers.firstKMissingPositive(new int[]{3, -1, 4, 5, 5}, 3));
        // expected : [1,2,6]
        System.out.println("Response : " + HFindKSmallestMissingNumbers.firstKMissingPositive(new int[]{2, 3, 4}, 3));
        // expected : [1,5,6]
        System.out.println("Response : " + HFindKSmallestMissingNumbers.firstKMissingPositive(new int[]{-2, -3, 4}, 2));
        // expected : [1,2]
    }

}
