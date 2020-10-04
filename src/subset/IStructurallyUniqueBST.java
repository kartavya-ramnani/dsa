package subset;

import mathematical.BCatalanNumber;

import java.util.ArrayList;

// Given a number ‘n’, write a function to return all structurally unique Binary Search Trees (BST) that can store values 1 to ‘n’?
public class IStructurallyUniqueBST {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // Approach :
    // Divide and Conquer and then merging it together.
    // we can iterate from 1 to ‘n’ and consider each number as the root of a tree.
    // All smaller numbers will make up the left sub-tree and bigger numbers will make up the right sub-tree.
    // We will make recursive calls for the left and right sub-trees
    public static ArrayList<TreeNode> getTrees(int left, int right) {
        ArrayList<TreeNode> result = new ArrayList<>();
        if (right < left) {
            result.add(null);
            return result;
        }
        if (right == 0) {
            return result;
        }

        for (int i = left; i <= right; i++) {
            ArrayList<TreeNode> leftTree = getTrees(left, i - 1);
            ArrayList<TreeNode> rightTree = getTrees(i + 1, right);
            for (TreeNode treeNode : leftTree) {
                for (TreeNode node : rightTree) {
                    TreeNode headNode = new TreeNode(i);
                    headNode.left = treeNode;
                    headNode.right = node;
                    result.add(headNode);
                }
            }
        }

        return result;
    }

    // this approach is just to get the count of structurally unique trees
    // the answer is something called as Catalan's Number ( https://www.geeksforgeeks.org/program-nth-catalan-number/ )
    public static int getCount(int n) {
        if (n == 0) {
            return  0;
        }
        return BCatalanNumber.get(n);
    }

    public static void main(String[] args) {
        System.out.println("Response : " + IStructurallyUniqueBST.getTrees(1, 2).size());
        System.out.println("Response : " + IStructurallyUniqueBST.getTrees(1, 3).size());
        System.out.println("Response : " + IStructurallyUniqueBST.getTrees(1, 4).size());

        System.out.println("Response from count : " + IStructurallyUniqueBST.getCount(2));
        System.out.println("Response from count : " + IStructurallyUniqueBST.getCount(3));
        System.out.println("Response from count : " + IStructurallyUniqueBST.getCount(4));
    }

}
