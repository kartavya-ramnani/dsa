package array_misc.prefix_sum_arr;

import java.util.ArrayList;
import java.util.Comparator;

// You are given an array A of N Positive integers and an integer K.
//Find the largest possible even sum of K elements at different positions in A.
//
//For example, given A = [4, 9, 8, 2, 6] and K = 3, the latest even sum of three elements is 18, the three selected elements are A[0] = 4, A[2] = 8, A[4] = 6
//
//That, given an array A of N positive integers and positive integer K, returns the largest even sum of K elements. If there are no such K elements, return -1
public class BFindMaxEvenSum {

    public static int findMaxEven(int[] A, int K) {

        if(A == null || A.length == 0 || K > A.length || K == 0 ) {
            return -1;
        }

        // odd and even array lists
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();

        // populating them
        for (int num : A) {
            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        }

        // sorting them
        odd.sort(Comparator.comparingInt(a -> a));
        even.sort(Comparator.comparingInt(a -> a));

        // prefix sum
        ArrayList<Integer> suffixOdd = new ArrayList<>();
        int temp = 0;
        suffixOdd.add(temp);
        for (int i = odd.size() - 1; i >= 0; i--) {
            suffixOdd.add(temp + odd.get(i));
            temp += odd.get(i);
        }

        ArrayList<Integer> suffixEven = new ArrayList<>();
        temp = 0;
        suffixEven.add(temp);
        for (int i = even.size() - 1; i >= 0; i--) {
            suffixEven.add(temp + even.get(i));
            temp += even.get(i);
        }

        int sum = -1;

        for (int i = 0; i <= K; i = i + 2) {
            if (i < suffixOdd.size() && (K - i) < suffixEven.size()) {
                sum = Math.max(sum, suffixOdd.get(i) + suffixEven.get(K - i));
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Sum : " + BFindMaxEvenSum.findMaxEven(new int[]{4, 9, 8, 2, 6}, 3));
        System.out.println("Sum : " + BFindMaxEvenSum.findMaxEven(new int[]{5, 6, 3, 4, 2}, 5));
        System.out.println("Sum : " + BFindMaxEvenSum.findMaxEven(new int[]{}, 1));
    }

}
