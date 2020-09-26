package binary_tree.dfs;

import binary_tree.ABinaryTreeNode;

import java.util.ArrayList;

// Given a binary tree and a number ‘S’,
// find all paths in the tree such that the sum of all the node values of each path equals ‘S’.
public class ECountAllPathsSum {

    private static int countAllPaths(ABinaryTreeNode root, int sum, ArrayList<Integer> currentPath) {
        if (root == null) {
            return 0;
        }
        currentPath.add(root.data);
        int countLeft = countAllPaths(root.left, sum, currentPath);
        int countRight = countAllPaths(root.right, sum, currentPath);
        int count = countLeft + countRight;
        int tempSum = 0;
        for (int i = currentPath.size() - 1; i >= 0; i--) {
            tempSum += currentPath.get(i);
            if (tempSum == sum) {
                count++;
            }
        }

        currentPath.remove(currentPath.size() - 1);
        return count;
    }

    public static int countAllPaths(ABinaryTreeNode root, int sum) {
        return countAllPaths(root, sum, new ArrayList<>());
    }

    public static void main(String[] args) {
        // test case :          12
        //                    7  |   1
        //                  4 |  | 10 |  5
        // Answer for sum = 11 : Count : 2 (7->4, 1->10)
        ABinaryTreeNode root = new ABinaryTreeNode(12);
        root.left = new ABinaryTreeNode(7);
        root.right = new ABinaryTreeNode(1);
        root.left.left = new ABinaryTreeNode(4);
        root.right.left = new ABinaryTreeNode(10);
        root.right.right = new ABinaryTreeNode(5);

        System.out.println("Count : " + ECountAllPathsSum.countAllPaths(root, 11));
    }

}
