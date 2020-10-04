package subset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// For a given number ‘N’, write a function to generate all combination of ‘N’ pairs of balanced parentheses.
public class EGenerateBalancedParentheses {
    static class paranthesis {
        String value;
        int openCount;
        int closeCount;

        paranthesis(String value, int openCount, int closeCount) {
            this.value = value;
            this.openCount = openCount;
            this.closeCount = closeCount;
        }
    }

    // Approach :
    // use BFS and tree out, at every stage add "(" and ")" and once open and close counts are equal to n
    // add answer to the result.
    public static ArrayList<String> generateBalanced(int n) {
        ArrayList<String> answer = new ArrayList<>();
        Queue<paranthesis> queue = new LinkedList<>();
        queue.add(new paranthesis("", 0, 0));
        while (!queue.isEmpty()) {
            paranthesis ps = queue.poll();
            if (ps.openCount == n && ps.closeCount == n) {
                answer.add(ps.value);
            } else {
                if (ps.openCount < n) {
                    queue.add(new paranthesis(ps.value + "(", ps.openCount + 1, ps.closeCount));
                }
                if (ps.openCount > ps.closeCount) {
                    queue.add(new paranthesis(ps.value + ")", ps.openCount, ps.closeCount + 1));

                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        System.out.println("Brackets Approach : " + EGenerateBalancedParentheses.generateBalanced(0));
        System.out.println("Brackets Approach : " + EGenerateBalancedParentheses.generateBalanced(1));
        System.out.println("Brackets Approach : " + EGenerateBalancedParentheses.generateBalanced(2));
        System.out.println("Brackets Approach : " + EGenerateBalancedParentheses.generateBalanced(3));
        System.out.println("Brackets Approach : " + EGenerateBalancedParentheses.generateBalanced(4));
    }

}
