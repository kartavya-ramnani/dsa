package binary_tree.dfs;

import binary_tree.ABinaryTreeNode;

// Given a binary tree and a number ‘S’,
// find if the tree has a path from root-to-leaf such that the sum of all the node values of that path equals ‘S’.
public class ABinaryTreePathSum {

    public static boolean hasPath(ABinaryTreeNode root, int sum) {

        if (root == null) {
            return false;
        }

        // leaf node and the sum is equals to the value of the leaf node, return true.
        if (root.data == sum && root.left == null && root.right == null) {
            return true;
        }

        // recursively calling the left and right of the subtree.
        // Because we just need to find a path which might exist in the left subtree or the right subtree, we do an or operation here.
        // If a path does not exist from both sides, we return false.
        return hasPath(root.left, sum - root.data) || hasPath(root.right, sum - root.data);
    }

    public static void main(String[] args) {
        ABinaryTreeNode root = new ABinaryTreeNode(12);
        root.left = new ABinaryTreeNode(7);
        root.right = new ABinaryTreeNode(1);
        root.left.left = new ABinaryTreeNode(9);
        root.right.left = new ABinaryTreeNode(10);
        root.right.right = new ABinaryTreeNode(5);

        System.out.println("Has Path : " + ABinaryTreePathSum.hasPath(root, 23));
        System.out.println("Has Path : " + ABinaryTreePathSum.hasPath(root, 16));
    }

}
