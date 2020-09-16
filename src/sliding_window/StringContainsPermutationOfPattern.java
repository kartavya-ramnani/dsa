package sliding_window;

import java.util.HashMap;
import java.util.HashSet;

// Given a string and a pattern, find out if the string contains any permutation of the pattern.
// This can also be used to find all the permutation in the string.
public class StringContainsPermutationOfPattern {

    public static boolean isContain(String input, String pattern) {
        if (input.length() == 0) {
            return false;
        }
        if (input.length() < pattern.length()) {
            return false;
        }

        boolean isThere = false;
        int patternLength = pattern.length();
        HashMap<Character, Integer> elemCharacter = new HashMap<>();
        int match = 0;

        for (int i = 0; i < patternLength; i++) {
            elemCharacter.put(pattern.charAt(i), elemCharacter.getOrDefault(pattern.charAt(i), 0) + 1);
        }

        for (int i = 0; i < input.length(); i++) {
            if (elemCharacter.containsKey(input.charAt(i))) {
                elemCharacter.put(input.charAt(i), elemCharacter.get(input.charAt(i)) - 1);
                if (elemCharacter.get(input.charAt(i)) == 0)
                    match++;
            }

            if (i >= patternLength) {
                // shifting the window
                if (elemCharacter.containsKey(input.charAt(i - patternLength))) {
                    elemCharacter.put(input.charAt(i - patternLength), elemCharacter.get(input.charAt(i - patternLength)) + 1);
                    if (elemCharacter.get(input.charAt(i - patternLength)) > 0)
                        match--;
                }
            }

            if (match == elemCharacter.size()) {
                isThere = true;
                System.out.println(i - patternLength + 1);
            }
        }

        return isThere;
    }

    public static void main(String[] args) {
        String input = "oidbcaf";
        String pattern = "abc";
        boolean res = StringContainsPermutationOfPattern.isContain(input, pattern);
        System.out.println("Response : " + res);
        input = "odicf";
        pattern = "dc";
        res = StringContainsPermutationOfPattern.isContain(input, pattern);
        System.out.println("Response : " + res);
        input = "bcdxabcdy";
        pattern = "bcdyabcdx";
        res = StringContainsPermutationOfPattern.isContain(input, pattern);
        System.out.println("Response : " + res);
        input = "BACDGABCDA";
        pattern = "ABCD";
        res = StringContainsPermutationOfPattern.isContain(input, pattern);
        System.out.println("Response : " + res);
    }
}
