package array_misc;

// A non-empty array A consisting of N integers is given. The array contains an odd number of elements,
// and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.
// Example : [9, 3, 9, 3, 9, 7, 9] , Output : 7
public class BFindUnpairedOddNumber {

    // Approach #1 : Create a HashMap with Number and frequency and populate it,
    // the number with Odd frequency is unpaired lone number.
    // Will be O(N) with a high constant and Take O(N) space as well.
    //
    // More efficient approach is using XOR operator.
    // Assuming non-null array with at least 3 odd numbers
    // constant space and efficient linear Time Complexity
    public static int findUnpaired(int[] A) {

        int result = 0;

        for (int num : A) {
            result = result ^ num;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Unpaired : " + BFindUnpairedOddNumber.findUnpaired(new int[]{1, 3, 1}));
        System.out.println("Unpaired : " + BFindUnpairedOddNumber.findUnpaired(new int[]{9, 3, 9, 3, 9, 7, 9}));
    }

}
