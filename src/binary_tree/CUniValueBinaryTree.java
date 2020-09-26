package binary_tree;

// Given a binary tree, write a program to count the number of Single Valued Subtrees.
// A Single Valued Subtree is one in which all the nodes have same value.
// Expected time complexity is O(n).
public class CUniValueBinaryTree {

    private static int countOfSingleValuedSubTrees;

    private static boolean uniValueBinaryTree(ABinaryTreeNode root) {
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

    public static int countSubtrees(ABinaryTreeNode root) {
        countOfSingleValuedSubTrees = 0;
        uniValueBinaryTree(root);
        return countOfSingleValuedSubTrees;
    }

    public static void main(String[] args) {
        ABinaryTreeNode root = new ABinaryTreeNode(5);
        root.left = new ABinaryTreeNode(4);
        root.right = new ABinaryTreeNode(5);
        root.left.left = new ABinaryTreeNode(4);
        root.left.right = new ABinaryTreeNode(4);
        root.right.right = new ABinaryTreeNode(5);

        System.out.println("The count of single valued sub trees is : "
                + CUniValueBinaryTree.countSubtrees(root));
    }

}
