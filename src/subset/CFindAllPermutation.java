package subset;

import java.util.ArrayList;
import java.util.Arrays;

// Given a set of distinct numbers, find all of its permutations.
public class CFindAllPermutation {

    public static ArrayList<ArrayList<Integer>> findAll(ArrayList<Integer> input) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

        for (Integer integer : input) {
            if (answer.size() == 0) {
                answer.add(new ArrayList<>(Arrays.asList(integer)));
                continue;
            }
            int n = answer.size();
            for (int j = 0; j < n; j++) {
                int newSize = answer.get(j).size();

                for (int k = 0; k < newSize; k++) {
                    ArrayList<Integer> temp = new ArrayList<>(answer.get(j));
                    temp.add(k, integer);
                    answer.add(temp);
                }
                answer.get(j).add(integer);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("All permutations : " + CFindAllPermutation.findAll(new ArrayList<>(Arrays.asList(1, 3, 5))));
        // Expected : All permutations : [[1, 3, 5], [3, 1, 5], [5, 1, 3], [1, 5, 3], [5, 3, 1], [3, 5, 1]]
    }

}
