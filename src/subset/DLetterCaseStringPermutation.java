package subset;

import java.util.ArrayList;
import java.util.Arrays;

// Given a string, find all of its permutations preserving the character sequence but changing case.
// Example 1:
//
//Input: "ad52"
//Output: "ad52", "Ad52", "aD52", "AD52"
//Example 2:
//
//Input: "ab7c"
//Output: "ab7c", "Ab7c", "aB7c", "AB7c", "ab7C", "Ab7C", "aB7C", "AB7C"
public class DLetterCaseStringPermutation {

    public static ArrayList<String> getPermutations(String input) {
        ArrayList<String> answer = new ArrayList<>();
        answer.add(input);

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                continue;
            }
            if (Character.isLetter(input.charAt(i))) {
                // assuming all lowercase characters
                int n = answer.size();
                for (int j = 0; j < n; j++) {
                    StringBuilder temp = new StringBuilder(answer.get(j));
                    temp.setCharAt(i, Character.toUpperCase(input.charAt(i)));
                    answer.add(temp.toString());
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("All permutations : " + DLetterCaseStringPermutation.getPermutations("ad52"));
        // expected : All permutations : [ad52, Ad52, aD52, AD52]
        System.out.println("All permutations : " + DLetterCaseStringPermutation.getPermutations("ab7c"));
        // expected : All permutations : [ab7c, Ab7c, aB7c, AB7c, ab7C, Ab7C, aB7C, AB7C]
    }

}
