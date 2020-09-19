package pointers.fast_slow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

// We are given an array containing positive and negative numbers. Suppose the array contains a number ‘M’ at a particular index.
// Now, if ‘M’ is positive we will move forward ‘M’ indices and if ‘M’ is negative move backwards ‘M’ indices. You should assume that the array is circular which means two things:
//
//If, while moving forward, we reach the end of the array, we will jump to the first element to continue the movement.
//If, while moving backward, we reach the beginning of the array, we will jump to the last element to continue the movement.
//Write a method to determine if the array has a cycle.
// The cycle should have more than one element and should follow one direction which means the cycle should not contain both forward and backward movements.
public class CycleCircularArray {


    public static boolean hasCycle(ArrayList<Integer> input) {
        if (input.size() == 0) {
            return false;
        }

        HashSet<Integer> visited = new HashSet<>();

        for (int i = 0; i < input.size(); i++) {

            if (visited.contains(i)) {
                continue;
            }

            boolean isForward = input.get(i) >= 0;
            int slow = i, fast = i;
            visited.add(i);

            do {
                slow = getIndex(input, isForward, slow);
                visited.add(slow);
                fast = getIndex(input, isForward, fast);
                visited.add(fast);
                if (fast != -1) {
                    fast = getIndex(input, isForward, fast);
                    visited.add(fast);
                }
            } while (slow != -1 && fast != -1 && fast != slow);

            if (slow != -1 && fast == slow) {
                return true;
            }
        }

        return false;

    }

    private static int getIndex(ArrayList<Integer> input, boolean isForward, int index) {
        boolean direction = input.get(index) >= 0;
        if (isForward != direction) {
            return -1;
        }

        int nextIndex = (index + input.get(index)) % input.size();
        if (nextIndex == index) {
            return -1;
        }

        return nextIndex;
    }

    // Time Complexity : O(N) because we are visiting every node only once.
    // Space Complexity : O(N) because we are using extra space.
    // We can remove extra space to get O(1) but time complexity will become O(N^2)
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, -1, 2, 2));
        System.out.println("has Cycle : " + CycleCircularArray.hasCycle(input));
        input = new ArrayList<>(Arrays.asList(2, 2, -1, 2));
        System.out.println("has Cycle : " + CycleCircularArray.hasCycle(input));
        input = new ArrayList<>(Arrays.asList(2, 1, -1, -2));
        System.out.println("has Cycle : " + CycleCircularArray.hasCycle(input));
    }

}
