package subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// Given a set of numbers that might contain duplicates, find all of its distinct subsets.
public class BFindAllSubsetsWithDuplicates {

    public static ArrayList<ArrayList<Integer>> findSubsets(ArrayList<Integer> input) {

        // sorting
        input.sort(Comparator.comparingInt(a -> a));

        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());

        for (int i = 0; i < input.size(); i++) {
            ArrayList<ArrayList<Integer>> newAnswer = new ArrayList<>();
            for (ArrayList<Integer> subset : answer) {
                ArrayList<Integer> temp = new ArrayList<>(subset);
                temp.add(input.get(i));
                newAnswer.add(temp);
            }

            // handling duplicates
            while (i < input.size() - 1 && input.get(i).equals(input.get(i + 1))) {
                int n = newAnswer.size();
                for (int j = 0; j < n; j++) {
                    ArrayList<Integer> temp = new ArrayList<>(newAnswer.get(j));
                    temp.add(input.get(i));
                    newAnswer.add(temp);
                }
                i++;
            }

            answer.addAll(newAnswer);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("All subsets : " + BFindAllSubsetsWithDuplicates.findSubsets(new ArrayList<>(Arrays.asList(1, 5, 3, 3))));
        // Expected : All subsets : [[], [1], [3], [1, 3], [3, 3], [1, 3, 3], [5], [1, 5], [3, 5], [1, 3, 5], [3, 3, 5], [1, 3, 3, 5]]
        // see that all the subsets are distinct, with the previous approach, this would not have been possible.
    }

}
