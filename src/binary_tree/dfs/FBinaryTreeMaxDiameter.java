package binary_tree.dfs;

import binary_tree.ABinaryTreeNode;

// Given a binary tree, find the length of its diameter.
// The diameter of a tree is the number of nodes on the longest path between any two leaf nodes.
// The diameter of a tree may or may not pass through the root.
public class FBinaryTreeMaxDiameter {
    private static int maxDiam = 0;

    public static int calculateHeight(ABinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);
        int diameter = leftHeight + rightHeight + 1;

        maxDiam = Integer.max(maxDiam, diameter);
        return Integer.max(leftHeight, rightHeight) + 1;
    }

    public static int getMaxDiam(ABinaryTreeNode root) {
        maxDiam = 0;
        calculateHeight(root);
        return maxDiam;
    }

    public static void main(String[] args) {
        // test case :          1
        //                    2  |   3
        //                  4 |  | 5 |  6
        // MaxDiam : 5 (4 -> 2 -> 1 -> 3 -> 6)
        ABinaryTreeNode root = new ABinaryTreeNode(1);
        root.left = new ABinaryTreeNode(2);
        root.right = new ABinaryTreeNode(3);
        root.left.left = new ABinaryTreeNode(4);
        root.right.left = new ABinaryTreeNode(5);
        root.right.right = new ABinaryTreeNode(6);

        System.out.println("MaxDiam : " + FBinaryTreeMaxDiameter.getMaxDiam(root));

        // test case#2 :          1
        //                    2  |    3
        //                    |  | 5  |  6
        //                      7   8|   9
        //                        10 |  11
        // MaxDiam : 7 (10 -> 8 -> 5 -> 3 -> 6 -> 9 -> 11)

        root.left.left = null;
        root.right.left.left = new ABinaryTreeNode(7);
        root.right.left.right = new ABinaryTreeNode(8);
        root.right.right.left = new ABinaryTreeNode(9);
        root.right.left.right.left = new ABinaryTreeNode(10);
        root.right.right.left.left = new ABinaryTreeNode(11);
        System.out.println("MaxDiam : " + FBinaryTreeMaxDiameter.getMaxDiam(root));


    }

}
