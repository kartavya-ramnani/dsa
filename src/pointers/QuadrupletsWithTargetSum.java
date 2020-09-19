package pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Given an array of unsorted numbers and a target number, find all unique quadruplets in it, whose sum is equal to the target number.
public class QuadrupletsWithTargetSum {

    public static List<List<Integer>> findQuad(int[] input, int targetSum) {

        List<List<Integer>> quadruplets = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            int targetSumL1 = targetSum - input[i];
            for (int j = i + 1; j < input.length; j++) {
                int targetSumL2 = targetSumL1 - input[j];
                int left = j + 1;
                int right = input.length - 1;
                while (left < right) {
                    if (input[left] + input[right] == targetSumL2) {
                        quadruplets.add(Arrays.asList(input[i], input[j], input[left], input[right]));
                        left++;
                        right--;
                    } else if (input[left] + input[right] > targetSumL2) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return quadruplets;

    }

    public static void main(String[] args) {
        System.out.println("response : " + QuadrupletsWithTargetSum.findQuad(new int[]{4, 1, 2, -1, 1, -3}, 1));
        System.out.println("response : " + QuadrupletsWithTargetSum.findQuad(new int[]{2, 0, -1, 1, -2, 2}, 2));
    }

}
