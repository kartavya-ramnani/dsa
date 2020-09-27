package array_misc;

import java.util.HashMap;

// In an even word, each letter occurs an even number of times.
//
//Write a function solution that, given a string S consisting of N characters, returns the min number of letters that must be deleted to obtain an even word.
public class DFindEvenWords {
    public static int solution(String S) {
        HashMap<Character, Integer> charFrequency = new HashMap<>();

        // populating frequencies
        for(int i = 0; i < S.length(); i++) {
            charFrequency.put(S.charAt(i), charFrequency.getOrDefault(S.charAt(i), 0) + 1);
        }
        int[] ordinal = {0};

        charFrequency.forEach((key, value) -> {
            if((value % 2) != 0) {
                ordinal[0]++;
            }
        });

        return ordinal[0];
    }

    public static void main(String[] args) {
        System.out.println("delete : " + DFindEvenWords.solution("acbcbba"));
        System.out.println("delete : " + DFindEvenWords.solution("axxaxa"));
        System.out.println("delete : " + DFindEvenWords.solution("aaaa"));
        System.out.println("delete : " + DFindEvenWords.solution(""));
    }

}
