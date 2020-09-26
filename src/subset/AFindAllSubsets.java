package subset;

import java.util.ArrayList;
import java.util.Arrays;

// Given a set with distinct elements, find all of its distinct subsets.
public class AFindAllSubsets {

    public static ArrayList<ArrayList<Integer>> findAll(ArrayList<Integer> input) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());

        for (Integer num : input) {
            int n = answer.size();
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> temp = new ArrayList<>(answer.get(i));
                temp.add(num);
                answer.add(temp);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("All subsets : " + AFindAllSubsets.findAll(new ArrayList<>(Arrays.asList(1, 5, 3))));
        // expected : All subsets : [[], [1], [5], [1, 5], [3], [1, 3], [5, 3], [1, 5, 3]]
    }

}
