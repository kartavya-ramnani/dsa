package binary_tree.dfs;

import binary_tree.ABinaryTreeNode;

import java.util.ArrayList;

// Given a binary tree and a number ‘S’,
// find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.
public class BBinaryTreeSumAllPaths {

    // returns the count of the paths found.
    private static int getPathsCount(ABinaryTreeNode root, int sum, int count) {
        if (root == null) {
            return count;
        }

        if (root.data == sum && root.left == null && root.right == null) {
            return count + 1;
        }

        return getPathsCount(root.left, sum - root.data, count) + getPathsCount(root.right, sum - root.data, count);
    }

    // edits the allPaths array with all the paths found
    private static void getAllPaths(ABinaryTreeNode root, int sum, ArrayList<Integer> currentPath, ArrayList<ArrayList<Integer>> allPaths) {
        if (root == null) {
            return;
        }

        currentPath.add(root.data);
        if (root.data == sum && root.left == null && root.right == null) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            getAllPaths(root.left, sum - root.data, currentPath, allPaths);
            getAllPaths(root.right, sum - root.data, currentPath, allPaths);
        }

        currentPath.remove(currentPath.size() - 1);
    }

    // returns the count of the paths found
    public static int getCount(ABinaryTreeNode root, int sum) {
        return getPathsCount(root, sum, 0);
    }

    // returns the list of all paths found.
    public static ArrayList<ArrayList<Integer>> getPaths(ABinaryTreeNode root, int sum) {
        ArrayList<Integer> currentPath = new ArrayList<>();
        ArrayList<ArrayList<Integer>> allPaths = new ArrayList<>();
        getAllPaths(root, sum, currentPath, allPaths);
        return allPaths;
    }

    public static void main(String[] args) {
        ABinaryTreeNode root = new ABinaryTreeNode(1);
        root.left = new ABinaryTreeNode(7);
        root.right = new ABinaryTreeNode(9);
        root.left.left = new ABinaryTreeNode(4);
        root.right.left = new ABinaryTreeNode(2);
        root.left.right = new ABinaryTreeNode(5);
        root.right.right = new ABinaryTreeNode(7);

        System.out.println("Has Path : " + BBinaryTreeSumAllPaths.getCount(root, 12));
        System.out.println("Paths : " + BBinaryTreeSumAllPaths.getPaths(root, 12));
    }


}
