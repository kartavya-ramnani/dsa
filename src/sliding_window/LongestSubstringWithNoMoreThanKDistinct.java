package sliding_window;

import java.util.HashSet;

// Given a string, find the length of the longest substring in it with no more than K distinct characters
public class LongestSubstringWithNoMoreThanKDistinct {

    public static int calculateLongest(String input, int k) {

        if (input == null || input.length() == 0 || k == 0) {
            return 0;
        }

        int maxSize = 0, firstSize = 0, windowStart = 0;
        HashSet<Character> charSet = new HashSet<>();

        for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            charSet.add(input.charAt(windowEnd));
            firstSize++;
            while (charSet.size() > k) {
                charSet.remove(input.charAt(windowStart));
                windowStart++;
                firstSize--;
            }
            if (maxSize < firstSize) {
                maxSize = firstSize;
            }
        }

        return maxSize;
    }

    public static void main(String args[]) {
        String input = "araaci";
        int k = 2;
        int response = LongestSubstringWithNoMoreThanKDistinct.calculateLongest(input, k);
        System.out.println("response : " + response);
        k = 1;
        response = LongestSubstringWithNoMoreThanKDistinct.calculateLongest(input, k);
        System.out.println("response : " + response);
        input = "cbbebi";
        k = 3;
        response = LongestSubstringWithNoMoreThanKDistinct.calculateLongest(input, k);
        System.out.println("response : " + response);
    }
}
