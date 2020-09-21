package array_misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

// Given an unsorted array, find the length of longest subarray of consecutive numbers
// O(n) and O(n) space.
public class UnsortedLongestConsecutive {

    public static int longestConsecutiveSubArray(ArrayList<Integer> input) {
        int longestSubArray = 0;

        HashSet<Integer> inputSet = new HashSet<>(input);

        for (Integer num : inputSet) {
            if (!inputSet.contains(num - 1)) {
                int newStreak = 1;
                int newNum = num + 1;

                while (inputSet.contains(newNum)) {
                    newStreak++;
                    newNum++;
                }

                if (longestSubArray < newStreak) {
                    longestSubArray = newStreak;
                }

            }
        }

        return longestSubArray;
    }

    public static void main(String[] args) {
        System.out.println("Response : " + UnsortedLongestConsecutive.longestConsecutiveSubArray(new ArrayList<>(Arrays.asList(100, 4, 200, 1, 3, 2))));
    }

}
