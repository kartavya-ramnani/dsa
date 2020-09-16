package sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

// Given an array of characters where each character represents a fruit tree, you are given two baskets and
// your goal is to put maximum number of fruits in each basket.
// The only restriction is that each basket can have only one type of fruit.
//You can start with any tree, but once you have started you can’t skip a tree.
// You will pick one fruit from each tree until you cannot, i.e.,
// you will stop when you have to pick from a third fruit type.
public class TwoFruitBasket {

    public static int calculateMaximum(ArrayList<Character> arr) {
        int maxSum = 0, b1 = 0, b2 = 0;
        HashSet<Character> charSet = new HashSet<>();
        Character b1Char = arr.get(0), b2Char = arr.get(0);
        boolean isB1 = false;

        for (Character character : arr) {
            charSet.add(character);
            if (charSet.size() > 2) {
                if (!isB1) {
                    charSet.remove(b1Char);
                    b1 = 0;
                    b1Char = character;
                } else {
                    charSet.remove(b2Char);
                    b2 = 0;
                    b2Char = character;
                }
            }
            if (character == b1Char) {
                b1++;
                isB1 = true;
            } else {
                b2++;
                isB1 = false;
                b2Char = character;
            }
            if (maxSum < b1 + b2) {
                maxSum = b1 + b2;
            }
        }

        return maxSum;

    }

    public static void main(String[] args) {
        ArrayList<Character> input = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'A', 'C'));
        int response = TwoFruitBasket.calculateMaximum(input);
        System.out.println("response : " + response);

        input = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'B', 'B', 'C'));
        response = TwoFruitBasket.calculateMaximum(input);
        System.out.println("response : " + response);
    }
}
