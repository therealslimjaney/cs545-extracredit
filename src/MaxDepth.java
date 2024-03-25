public class MaxDepth {


    private class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
        }
    }

    private static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return java.lang.Math.max(left_height, right_height) + 1;
        }
    }

    public static void main(String args[]) {

        MaxDepth tree = new MaxDepth();

        Node root = tree.new Node(1);
        root.left = tree.new Node(2);
        root.right = tree.new Node(3);
        root.left.left = tree.new Node(4);
        root.left.right = tree.new Node(5);

        int depth = maxDepth(root);
        System.out.println("Max depth: " + depth);
    }
}