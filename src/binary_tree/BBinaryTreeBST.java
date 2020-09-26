package binary_tree;

// A program to check if a binary tree is BST or not
public class BBinaryTreeBST {

    private static int min = Integer.MIN_VALUE;
    private static int max = Integer.MAX_VALUE;

    private static boolean isBST(ABinaryTreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.data < min || root.data > max) {
            return false;
        }
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }

    public static boolean checkBST(ABinaryTreeNode root) {
        return isBST(root, min, max);
    }

    public static void main(String[] args) {
        ABinaryTreeNode root = new ABinaryTreeNode(4);
        root.left = new ABinaryTreeNode(2);
        root.right = new ABinaryTreeNode(5);
        root.left.left = new ABinaryTreeNode(1);
        root.left.right = new ABinaryTreeNode(3);
        System.out.println("Response : " + BBinaryTreeBST.checkBST(root));
        root.right.data = 6;
        root.left.right.data = 5;
        System.out.println("Response : " + BBinaryTreeBST.checkBST(root));
    }

}
