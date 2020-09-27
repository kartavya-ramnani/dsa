package array_misc;

import java.util.ArrayList;
import java.util.Arrays;

// Write a function which rotates array input by K.
// [1,2,3,4,5] , 1 rotation : [5,1,2,3,4], 2 rotations : [4,5,1,2,3], 3 rotations : [3,4,5,1,2]
public class CRotateArrayByK {

    // Approach 1 : Use a temp array and store the values there and return
    // Linear Time Complexity and Linear Space
    public static ArrayList<Integer> rotate(ArrayList<Integer> input, int k) {
        if (input == null || input.size() <= 1) {
            return input;
        }

        if (k > input.size()) {
            k = k % input.size();
            if (k == 0) {
                return input;
            }
        }

        ArrayList<Integer> temp = new ArrayList<>();
        int newFirst = input.size() - k;
        int i;
        for (i = 0; i < input.size() - newFirst; i++) {
            temp.add(input.get(newFirst + i));
        }

        for (int j = i; j < input.size(); j++) {
            temp.add(input.get(j - i));
        }

        return temp;
    }

    // Approach 2 : This is the efficient juggling solution
    // ToDO

    public static void main(String[] args) {
        System.out.println("After rotation : " + CRotateArrayByK.rotate(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)), 3));
    }

}
