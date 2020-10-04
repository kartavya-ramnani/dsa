package subset;

import java.util.ArrayList;
import java.util.Arrays;

// Given an expression containing digits and operations (+, -, *),
// find all possible ways in which the expression can be evaluated by grouping the numbers and operators using parentheses.
// "1+2*3" -> 7, 9 -> 1 + (2*3) = 7 and (1+2)*3 = 9
public class HEvaluateExpression {
    private static final Character[] operators = {'+', '-', '*'};

    public static ArrayList<Integer> evaluate(String toEvaluate) {
        ArrayList<Integer> result = new ArrayList<>();
        if (!toEvaluate.contains("-") && !toEvaluate.contains("+") && !toEvaluate.contains("*")) {
            result.add(Integer.parseInt(toEvaluate));
            return result;
        } else {
            for (int i = 0; i < toEvaluate.length(); i++) {
                char chr = toEvaluate.charAt(i);
                if (Arrays.asList(operators).contains(chr)) {
                    ArrayList<Integer> left = evaluate(toEvaluate.substring(0, i));
                    ArrayList<Integer> right = evaluate(toEvaluate.substring(i + 1));
                    for (Integer num : left) {
                        for (Integer num2 : right) {
                            if (chr == '+') {
                                result.add(num + num2);
                            }
                            if (chr == '-') {
                                result.add(num - num2);
                            }
                            if (chr == '*') {
                                result.add(num * num2);
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Response : " + HEvaluateExpression.evaluate("1+2*3"));
        System.out.println("Response : " + HEvaluateExpression.evaluate("2*3-4-5"));

    }

}
