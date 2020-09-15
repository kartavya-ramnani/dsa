package sliding_window;

import java.util.HashSet;

// Given a string, find the length of the longest substring which has no repeating characters.
public class LongestSubstringWithNoRepeats {

    public static int calculateMax(String input) {
        int windowStart = 0, maxLength = 0, firstLength = 0;
        HashSet<Character> charSet = new HashSet<>();

        for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            while (charSet.contains(input.charAt(windowEnd))) {
                charSet.remove(input.charAt(windowStart));
                windowStart++;
                firstLength--;
            }
            charSet.add(input.charAt(windowEnd));
            firstLength++;
            if (maxLength < firstLength) {
                maxLength = firstLength;
            }
        }

        return maxLength;
    }

    public static void main(String args[]) {
        String input = "ABDEFGABEF";
        int response = LongestSubstringWithNoRepeats.calculateMax(input);
        System.out.println("response : " + response);
        input = "BBBB";
        response = LongestSubstringWithNoRepeats.calculateMax(input);
        System.out.println("response : " + response);
        input = "GEEKSFORGEEKS";
        response = LongestSubstringWithNoRepeats.calculateMax(input);
        System.out.println("response : " + response);
    }

}
