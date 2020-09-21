package binary_tree;


class BinaryTreeNode {
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}


// A program to check if a binary tree is BST or not
public class BinaryTreeBST {

    private static int min = Integer.MIN_VALUE;
    private static int max = Integer.MAX_VALUE;

    private static boolean isBST(BinaryTreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.data < min || root.data > max) {
            return false;
        }
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }

    public static boolean checkBST(BinaryTreeNode root) {
        return isBST(root, min, max);
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(4);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(5);
        root.left.left = new BinaryTreeNode(1);
        root.left.right = new BinaryTreeNode(3);
        System.out.println("Response : " + BinaryTreeBST.checkBST(root));
        root.right.data = 6;
        root.left.right.data = 5;
        System.out.println("Response : " + BinaryTreeBST.checkBST(root));
    }

}
