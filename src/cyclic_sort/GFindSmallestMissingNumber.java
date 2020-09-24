package cyclic_sort;

// Given an unsorted integer array, find the smallest missing positive integer.
//
//Example 1:
//
//Input: [1,2,0]
//Output: 3
//Example 2:
//
//Input: [3,4,-1,1]
//Output: 2
//Example 3:
//
//Input: [7,8,9,11,12]
//Output: 1
public class GFindSmallestMissingNumber {

    public static int firstMissingPositive(int[] input) {
        // Solving using the cyclic sort pattern
        int i = 0;

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
            if (input[i] != i + 1) {
                return i + 1;
            }
        }

        return input.length + 1;
    }

    public static void main(String[] args) {
        System.out.println("Response : " + GFindSmallestMissingNumber.firstMissingPositive(new int[]{1, 2, 0})); // expected : 3
        System.out.println("Response : " + GFindSmallestMissingNumber.firstMissingPositive(new int[]{3, 4, -1, 1})); // expected : 2
        System.out.println("Response : " + GFindSmallestMissingNumber.firstMissingPositive(new int[]{7, 8, 9, 11, 12})); // expected : 1
    }

}
