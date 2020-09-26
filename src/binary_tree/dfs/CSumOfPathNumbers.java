package binary_tree.dfs;

import binary_tree.ABinaryTreeNode;

// Given a binary tree where each node can only have a digit (0-9) value, each root-to-leaf path will represent a number.
// Find the total sum of all the numbers represented by all paths.
// Example :      1           Sum = 17 + 192 + 199 = 408
//              7   9
//                 2 9
public class CSumOfPathNumbers {

    private static int sumOfPathNumbers(ABinaryTreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        sum = 10 * sum + root.data;

        if (root.left == null && root.right == null) {
            return sum;
        }

        return sumOfPathNumbers(root.left, sum) + sumOfPathNumbers(root.right, sum);
    }

    public static int getSum(ABinaryTreeNode root) {
        return sumOfPathNumbers(root, 0);
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

        System.out.println("Sum : " + CSumOfPathNumbers.getSum(root));
    }

}
