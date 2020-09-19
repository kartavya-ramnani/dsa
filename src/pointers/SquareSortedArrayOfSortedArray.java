package pointers;

import java.util.ArrayList;
import java.util.Arrays;

// Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.
public class SquareSortedArrayOfSortedArray {

    public static ArrayList<Integer> squareIt(ArrayList<Integer> input) {
        int negative = -1;
        int positive = 0;
        int positiveLeft;

        ArrayList<Integer> squaredArray = new ArrayList<>();
        for (Integer integer : input) {
            if (integer >= 0) {
                break;
            }
            positive++;
            negative++;
        }

        positiveLeft = input.size() - positive - 1;
        while (negative >= 0 || positiveLeft >= 0) {
            if (negative >= 0) {
                if (positive < input.size()) {
                    if (input.get(negative) * (-1) < input.get(positive)) {
                        squaredArray.add(input.get(negative) * input.get(negative));
                        negative--;
                    } else {
                        squaredArray.add(input.get(positive) * input.get(positive));
                        positive++;
                        positiveLeft--;
                    }
                } else {
                    squaredArray.add(input.get(negative) * input.get(negative));
                    negative--;
                }
            } else {
                squaredArray.add(input.get(positive) * input.get(positive));
                positive++;
                positiveLeft--;
            }
        }

        return squaredArray;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(-2, -1, 0, 2, 3));
        ArrayList<Integer> response = SquareSortedArrayOfSortedArray.squareIt(input);
        System.out.println("Response : " + response.toString());
        input = new ArrayList<>(Arrays.asList(-3, -1, 0, 1, 2));
        response = SquareSortedArrayOfSortedArray.squareIt(input);
        System.out.println("Response : " + response.toString());
        input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        response = SquareSortedArrayOfSortedArray.squareIt(input);
        System.out.println("Response : " + response.toString());
        input = new ArrayList<>(Arrays.asList(-5, -4, -3, -2, -1));
        response = SquareSortedArrayOfSortedArray.squareIt(input);
        System.out.println("Response : " + response.toString());
    }

}
