package pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
public class TripletsWithZeroSum {

    public static List<List<Integer>> findTriplets(int[] input) {

        // sort the array
        Arrays.sort(input);
        List<List<Integer>> tripletList = new ArrayList<>();

        // iterate over the array
        for (int i = 0; i < input.length; i++) {
            if (i > 0 && input[i] == input[i - 1]) {
                continue;
            }
            searchPair(input, -input[i], i + 1, tripletList);
        }

        return tripletList;

    }

    private static void searchPair(int[] input, int targetSum, int left, List<List<Integer>> tripletList) {
        int right = input.length - 1;
        while (left < right) {
            if (input[left] + input[right] == targetSum) {
                tripletList.add(Arrays.asList(-targetSum, input[left], input[right]));
                left++;
                right--;
                while (left < right && input[left] == input[left - 1]) {
                    left++;
                }
                while (left < right && input[right] == input[right + 1]) {
                    right--;
                }
            } else if (input[left] + input[right] > targetSum) {
                right--;
            } else {
                left++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("response : " + TripletsWithZeroSum.findTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        System.out.println("response : " + TripletsWithZeroSum.findTriplets(new int[]{-5, 2, -1, -2, -3}));
        System.out.println("response : " + TripletsWithZeroSum.findTriplets(new int[]{1, -2, 1, 0, 5}));
    }

}
