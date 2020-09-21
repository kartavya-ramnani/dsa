package dynamic_programming;

import sliding_window.MaxSumOfContiguousSubArray;

import java.util.ArrayList;
import java.util.Arrays;

// Given an array A of non-negative integers, return the maximum sum of elements in two non-overlapping (contiguous) subarrays,
// which have lengths L and M.  (For clarification, the L-length subarray could occur before or after the M-length subarray.)
// Input: A = [0,6,5,2,2,5,1,9,4], L = 1, M = 2
//Output: 20
//Explanation: One choice of subarrays is [9] with length 1, and [6,5] with length 2.

// https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/
public class MaxSumOfTwoNonOverlappingSubArrays {

    // This is my understanding of the problem :
    // In the first step we calculate cumulative sum or prefix array :
    // this is because we are playing with sum of elements here.
    // Now :
    // lMax is first l elements (this is the first subarray), mMax is the first m elements (this is second subarray)
    // and result is the first l + m elements (this is the sum of the two subarrays)
    // Dynamic Programming Begins :
    // We take the next set of l elements and check if sum of that l Elements is greater than lMax
    // We take the next set of m elements and check if sum of that m elements is greater than mMax
    // Then we compare results with the following :
    // a.) value of current result
    // b.) value of lMax + the sum of latest m elements
    // c.) value of mMax + the sum of latest l elements
    //
    // Now, what this does is : it checks the max l subarray with the non-overlapping m subarray with which it hasnt checked before
    // and it checks with the max m subarray with the non-overlapping l subarray with which it has not checked before,
    public static int getMaxSum(ArrayList<Integer> input, int l, int m) {
        if (input == null || input.size() == 0 || input.size() < l + m) {
            return 0;
        }

        // cumulative sum (prefix array)
        for (int i = 1; i < input.size(); i++) {
            input.set(i, input.get(i) + input.get(i - 1));
        }

        int lMax = input.get(l - 1);
        int mMax = input.get(m - 1);
        int result = input.get(input.size() - l - m - 1);

        for (int i = l + m; i < input.size(); i++) {
            lMax = Integer.max(lMax, input.get(i - m) - input.get(i - m - l));
            mMax = Integer.max(mMax, input.get(i - l) - input.get(i - m - l));
            result = Integer.max(result, Integer.max(lMax + input.get(i) - input.get(i - m), mMax + input.get(i) - input.get(i - l)));
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Response : " + MaxSumOfTwoNonOverlappingSubArrays.getMaxSum(new ArrayList<>(Arrays.asList(0, 6, 5, 2, 2, 5, 1, 9, 4)), 1, 2));
        System.out.println("Response : " + MaxSumOfTwoNonOverlappingSubArrays.getMaxSum(new ArrayList<>(Arrays.asList(3, 8, 1, 3, 2, 1, 8, 9, 0)), 3, 2));
        System.out.println("Response : " + MaxSumOfTwoNonOverlappingSubArrays.getMaxSum(new ArrayList<>(Arrays.asList(2, 1, 5, 6, 0, 9, 5, 0, 3, 8)), 4, 3));
        System.out.println("Response : " + MaxSumOfTwoNonOverlappingSubArrays.getMaxSum(new ArrayList<>(Arrays.asList(0, 2, 3, 3, 2, 0)), 2, 2));
    }

}
