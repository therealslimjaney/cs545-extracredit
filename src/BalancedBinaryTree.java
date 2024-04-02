// Given a binary tree, determine if it is height-balanced
// In a height balanced binary tree the left and right subtrees of every node differ in height by no more than 1
// Recursively check the height difference between left and right subtrees at each node

public class BalancedBinaryTree {

    private static class BSTNode {
        int data;
        BalancedBinaryTree.BSTNode left;
        BalancedBinaryTree.BSTNode right;

        private BSTNode(int x) {
            data = x;
        }
    }

    private BSTNode root;

    public static boolean isBalanced(BSTNode root) {
        return getHeight(root) != -1;
    }

    private static int getHeight(BSTNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = getHeight(node.right);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        // Creating a simple binary tree.
        BalancedBinaryTree tree = new BalancedBinaryTree();
        BSTNode newRoot = new BSTNode(1);
        tree.root = newRoot;
        newRoot.left = new BSTNode(2);
        newRoot.right = new BSTNode(3);
        newRoot.left.left = new BSTNode(4);
        newRoot.left.right = new BSTNode(5);

        if (isBalanced(newRoot)) {
            System.out.println("The tree is height balanced.");
        }
    }
}
