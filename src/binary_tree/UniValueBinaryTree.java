package binary_tree;

// Given a binary tree, write a program to count the number of Single Valued Subtrees.
// A Single Valued Subtree is one in which all the nodes have same value.
// Expected time complexity is O(n).
public class UniValueBinaryTree {

    private static int countOfSingleValuedSubTrees;

    private static boolean uniValueBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = uniValueBinaryTree(root.left);
        boolean right = uniValueBinaryTree(root.right);

        if (!left || !right) {
            return false;
        }

        if (root.left != null && root.data != root.left.data) {
            return false;
        }

        if (root.right != null && root.data != root.right.data) {
            return false;
        }

        countOfSingleValuedSubTrees++;
        return true;
    }

    public static int countSubtrees(BinaryTreeNode root) {
        countOfSingleValuedSubTrees = 0;
        uniValueBinaryTree(root);
        return countOfSingleValuedSubTrees;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.left = new BinaryTreeNode(4);
        root.right = new BinaryTreeNode(5);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(4);
        root.right.right = new BinaryTreeNode(5);

        System.out.println("The count of single valued sub trees is : "
                + UniValueBinaryTree.countSubtrees(root));
    }

}
