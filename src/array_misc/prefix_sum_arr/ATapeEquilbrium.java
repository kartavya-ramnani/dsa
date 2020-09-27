package array_misc.prefix_sum_arr;

import java.util.ArrayList;
import java.util.Arrays;

// A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.
//
//Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
//
//The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
//
//In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
// Return the minimum difference.
// Example :
// [3, 1, 2, 4, 3] -> [(3, 10) -> 7], [(4, 9) -> 5], [(6, 7) -> 1], [(10, 3) -> 7] Min : 1
public class ATapeEquilbrium {

    public static int minSumDifference(ArrayList<Integer> input) {

        if (input == null || input.size() == 0) {
            return Integer.MAX_VALUE;
        }

        if (input.size() == 1) {
            return input.get(0);
        }

        // prefix sum
        for (int i = 1; i < input.size(); i++) {
            input.set(i, input.get(i) + input.get(i - 1));
        }

        int leftSum = input.get(0);
        int rightSum = input.get(input.size() - 1) - input.get(0);
        int minDiff = Math.abs(leftSum - rightSum);
        for (int i = 1; i < input.size() - 1; i++) {
            leftSum = input.get(i);
            rightSum = input.get(input.size() - 1) - input.get(i);
            int diff = Math.abs(leftSum - rightSum);
            if (minDiff > diff) {
                minDiff = diff;
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        System.out.println("Min Diff : " + ATapeEquilbrium.minSumDifference(new ArrayList<>(Arrays.asList(3, 1, 2, 4, 3))));
        // expected : 1
        System.out.println("Min Diff : " + ATapeEquilbrium.minSumDifference(new ArrayList<>(Arrays.asList(10, 10, -20))));
        // expected : 20
        System.out.println("Min Diff : " + ATapeEquilbrium.minSumDifference(new ArrayList<>(Arrays.asList(1, 1, 3))));
        // expected : 1
    }


}
