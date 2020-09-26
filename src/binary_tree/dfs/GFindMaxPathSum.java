package binary_tree.dfs;

import binary_tree.ABinaryTreeNode;

// Find the path with the maximum sum in a given binary tree. Write a function that returns the maximum sum.
// A path can be defined as a sequence of nodes between any two nodes and doesn’t necessarily pass through the root.
public class GFindMaxPathSum {

    private static int maxSum;

    private static int findMax(ABinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = findMax(root.left);
        leftSum = Math.max(leftSum, 0);
        int rightSum = findMax(root.right);
        rightSum = Math.max(rightSum, 0);

        int sum = leftSum + rightSum + root.data;

        maxSum = Math.max(maxSum, sum);

        return Math.max(leftSum, rightSum) + root.data;

    }

    public static int findMaxSum(ABinaryTreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMax(root);
        return maxSum;
    }

    public static void main(String[] args) {
        // test case :          1
        //                    2  |   3
        // Max Sum Path : 6 (2 -> 1 -> 3)

        ABinaryTreeNode root = new ABinaryTreeNode(1);
        root.left = new ABinaryTreeNode(2);
        root.right = new ABinaryTreeNode(3);

        System.out.println("Max Sum Path : " + GFindMaxPathSum.findMaxSum(root));

        // test case :          1
        //                    2  |   3
        //                  1      5   6
        //                       7  8 |  9
        // MaxDiam : 31 (8  -> 5 -> 3 -> 6 ->9)

        root.left.left = new ABinaryTreeNode(1);
        root.left.right = new ABinaryTreeNode(3);
        root.right.left = new ABinaryTreeNode(5);
        root.right.right = new ABinaryTreeNode(6);
        root.right.left.left = new ABinaryTreeNode(7);
        root.right.left.right = new ABinaryTreeNode(8);
        root.right.right.left = new ABinaryTreeNode(9);

        System.out.println("Max Sum Path : " + GFindMaxPathSum.findMaxSum(root));

        // test case :          -3
        //                    -1
        // MaxDiam : -1 ( -1 )

        root = new ABinaryTreeNode(-3);
        root.left = new ABinaryTreeNode(-1);
        System.out.println("Max Sum Path : " + GFindMaxPathSum.findMaxSum(root));
    }
}
