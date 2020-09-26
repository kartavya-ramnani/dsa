package binary_tree.dfs;

import binary_tree.ABinaryTreeNode;

import java.util.ArrayList;
import java.util.Arrays;

// Given a binary tree and a number sequence, find if the sequence is present as a root-to-leaf path in the given tree.
public class DPathWithGivenSequence {

    // this is creating a new sequence at every level and is not desirable because using extra space
    public static boolean hasSequence(ABinaryTreeNode root, ArrayList<Integer> sequence) {
        if (root == null || sequence.size() == 0) {
            return false;
        }

        if (root.data != sequence.get(0)) {
            return false;
        }

        ArrayList<Integer> newSequence = new ArrayList<>(sequence);
        newSequence.remove(0);

        // if leaf node,
        if (root.left == null && root.right == null) {
            return newSequence.size() == 0;
        }

        return hasSequence(root.left, newSequence) || hasSequence(root.right, newSequence);
    }

    // not using extra space.
    public static boolean hasSequence(ABinaryTreeNode root, ArrayList<Integer> sequence, int sequenceIndex) {
        if (root == null) {
            return false;
        }

        if (sequenceIndex > sequence.size() - 1 || root.data != sequence.get(sequenceIndex)) {
            return false;
        }

        // if leaf node
        if (root.left == null && root.right == null) {
            return sequenceIndex == (sequence.size() - 1);
        }

        return hasSequence(root.left, sequence, sequenceIndex + 1) || hasSequence(root.right, sequence, sequenceIndex + 1);
    }

    public static void main(String[] args) {
        // test case :          1
        //                    0  |   1
        //                  1 |  | 6 |  5
        // Sum : (101 + 116 + 115 = ) 332
        ABinaryTreeNode root = new ABinaryTreeNode(1);
        root.left = new ABinaryTreeNode(0);
        root.right = new ABinaryTreeNode(1);
        root.left.left = new ABinaryTreeNode(1);
        root.right.left = new ABinaryTreeNode(6);
        root.right.right = new ABinaryTreeNode(5);
        ArrayList<Integer> sequence = new ArrayList<>(Arrays.asList(1, 1, 6));
        System.out.println("Has seq : " + DPathWithGivenSequence.hasSequence(root, sequence)); // expected true
        sequence = new ArrayList<>(Arrays.asList(1, 1, 7));
        System.out.println("Has seq : " + DPathWithGivenSequence.hasSequence(root, sequence)); // expected false
        sequence = new ArrayList<>(Arrays.asList(1, 0, 1));
        System.out.println("Has seq : " + DPathWithGivenSequence.hasSequence(root, sequence, 0)); // expected true
        sequence = new ArrayList<>(Arrays.asList(1, 0, 2));
        System.out.println("Has seq : " + DPathWithGivenSequence.hasSequence(root, sequence, 0)); // expected false

    }

}
