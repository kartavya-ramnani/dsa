package pointers;

import java.util.Arrays;

/**
 * Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
 * <p>
 * A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
 * <p>
 * 0 <= i, j < nums.length
 * i != j
 * a <= b
 * b - a == k
 * <p>
 * Input: nums = [3,1,4,1,5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * <p>
 * Input: nums = [1,2,3,4,5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * <p>
 * Input: nums = [3, 1, 4, 1, 5], k = 0
 * Output: 1
 * Explanation : 1-1 = 0, therefore, do not remove duplicates.
 */
public class PairSortedArrayTargetDifference {

    // Approach : Sort the array and use the two pointer approach.
    // Here, the two pointer approach will be slightly different, because :
    // we will have start and end with a difference of 1 and start + k = end
    // Using sorting and then two pointer approach
    // On leetcode : Faster than 99% submissions
    public int findPairs(int[] nums, int k) {
        if (nums.length == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int pairs = 0;
        int start = 0, end = 1;
        boolean increaseStart = false;
        boolean increaseEnd = false;

        while (end < nums.length) {
            int startValue = nums[start];
            int endValue = nums[end];
            if (startValue + k == endValue) {
                pairs++;
                start++;
                end++;
                increaseStart = true;
                increaseEnd = true;
            } else if (startValue + k > endValue) {
                end++;
                increaseEnd = true;
            } else {
                start++;
                increaseStart = true;
            }
            // browsing through duplicates
            if (increaseStart) {
                while (start < nums.length && nums[start] == startValue)
                    start++;
                increaseStart = false;
            }
            // browsing through duplicates
            if (increaseEnd) {
                while (end < nums.length && nums[end] == endValue)
                    end++;
                increaseEnd = false;
            }
            // it is possible that browsing through duplicates lead them to the same position,
            // this is to ensure the lead.
            if (start == end)
                end++;
        }

        return pairs;
    }

}
