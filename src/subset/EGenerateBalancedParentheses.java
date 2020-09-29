package subset;

import java.util.ArrayList;

// For a given number ‘N’, write a function to generate all combination of ‘N’ pairs of balanced parentheses.
public class EGenerateBalancedParentheses {

    // Approach :
    // Now, there can be different approaches to this one, but you can not do best or worse time complexity than this :P
    // for n = 1,  answer [()]
    // for n = 2, we have 2 scenarios
    //        - the two brackets surround the existing entries in the array (())
    //        - the two brackets come as individual open-shut and then get placed at either the start or the end of the sequence. ()()
    public static ArrayList<String> generate(int n) {
        ArrayList<String> answer = new ArrayList<>();
        answer.add("");
        if (n == 0) {
            return answer;
        }
        // base answer
        answer.set(0, "()");

        for (int i = 1; i < n; i++) {
            ArrayList<String> newTemp = new ArrayList<>();
            int newLength = answer.size();

            // surround the existing brackets
            for (String s : answer) {
                newTemp.add('(' + s + ')');
            }

            // locate and place the individual brackets
            int j;
            for (j = 0; j < newLength - 1; j++) {
                newTemp.add("()" + answer.get(j));
                newTemp.add(answer.get(j) + "()");
            }
            newTemp.add(answer.get(j) + "()");

            answer = newTemp;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("Brackets : " + EGenerateBalancedParentheses.generate(0));
        System.out.println("Brackets : " + EGenerateBalancedParentheses.generate(1));
        System.out.println("Brackets : " + EGenerateBalancedParentheses.generate(2));
        System.out.println("Brackets : " + EGenerateBalancedParentheses.generate(3));
        System.out.println("Brackets : " + EGenerateBalancedParentheses.generate(4));
    }

}
