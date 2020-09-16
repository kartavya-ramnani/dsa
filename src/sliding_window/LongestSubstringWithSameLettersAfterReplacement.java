package sliding_window;

import java.util.HashMap;

// Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter,
// find the length of the longest substring having the same letters after replacement.
public class LongestSubstringWithSameLettersAfterReplacement {

    public static int calculateLongest(String input, int k) {
        if (input.length() == 0) {
            return 0;
        }

        int windowStart = 0, maxRepeatedChar = 0, firstLength = 0, maxLength = 0;
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < input.length(); windowEnd++) {
            firstLength++;
            Character rightChar = input.charAt(windowEnd);
            int frequencyRightChar = frequencyMap.getOrDefault(rightChar, 0) + 1;
            frequencyMap.put(rightChar, frequencyRightChar);
            if (maxRepeatedChar < frequencyRightChar) {
                maxRepeatedChar = frequencyRightChar;
            }

            if (firstLength - maxRepeatedChar > k) {
                Character leftChar = input.charAt(windowStart);
                frequencyMap.put(leftChar, frequencyMap.get(leftChar) - 1);
                windowStart++;
                firstLength--;
            }

            if (maxLength < firstLength) {
                maxLength = firstLength;
            }
        }

        return  maxLength;
    }

    public static void main(String[] args) {
        String input = "aabccbb";
        int k = 2;
        int response = LongestSubstringWithSameLettersAfterReplacement.calculateLongest(input, k);
        System.out.println("response : " + response);
        input = "abbcb";
        k = 1;
        response = LongestSubstringWithSameLettersAfterReplacement.calculateLongest(input, k);
        System.out.println("response : " + response);
        input = "abccde";
        k = 1;
        response = LongestSubstringWithSameLettersAfterReplacement.calculateLongest(input, k);
        System.out.println("response : " + response);
    }

}
