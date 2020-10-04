package binary_search;

import java.util.ArrayList;
import java.util.Arrays;

// Given an array of lowercase letters sorted in ascending order,
// find the smallest letter in the given array greater than a given ‘key’.
// Assume the given array is a circular list, which means that the last letter is assumed to be connected with the first letter.
// This also means that the smallest letter in the given array is greater than the last letter of the array and is also the first letter of the array.
//
// Write a function to return the next letter of the given ‘key’.
public class CNextLetter {

    public static Character findNext(ArrayList<Character> input, Character key) {
        if (input == null || input.size() == 0) {
            return ' ';
        }
        int start = 0, end = input.size() - 1;
        int nextNumberIndex = end;

        while (start <= end) {
            // Doing int mid = (lo + hi) / 2; is prone to overflow. Instead int mid = lo + (hi - lo) / 2
            int middle = start + (end - start) / 2;
            if (input.get(middle) > key) {
                if (input.get(nextNumberIndex) > input.get(middle)) {
                    nextNumberIndex = middle;
                }
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        return input.get(nextNumberIndex) > key ? input.get(nextNumberIndex) : input.get(0);
    }

    public static void main(String[] args) {
        System.out.println("Next Letter : " + CNextLetter.findNext(new ArrayList<>(Arrays.asList('a', 'c', 'f', 'h')), 'f'));
        System.out.println("Next Letter : " + CNextLetter.findNext(new ArrayList<>(Arrays.asList('a', 'c', 'f', 'h')), 'b'));
        System.out.println("Next Letter : " + CNextLetter.findNext(new ArrayList<>(Arrays.asList('a', 'c', 'f', 'h')), 'm'));
        System.out.println("Next Letter : " + CNextLetter.findNext(new ArrayList<>(Arrays.asList('a', 'c', 'f', 'h')), 'h'));
    }

}
