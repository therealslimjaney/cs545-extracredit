//Given an integer array nums where the elements are sorted in ascending order, convert it to a
// height-balanced binary search tree.
public class ConvertSortedArrayToBST {
    int[] array;
    private class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public Node helper(int left, int right) {
        if (left > right) return null;

        int p = (left + right) / 2;

        Node root = new Node(array[p]);
        root.left = helper(left, p - 1);
        root.right = helper(p + 1, right);
        return root;
    }

    public Node sortedArrayToBST(int[] array) {
        this.array = array;
        return helper(0, array.length - 1);
    }


    public void printTree(Node node) {
        if (node != null) {
            printTree(node.left);
            System.out.print(node.val + " ");
            printTree(node.right);
        }
    }

    public static void main(String args[]) {
        ConvertSortedArrayToBST solution = new ConvertSortedArrayToBST();

        int[] nums = {-10, -3, 0, 5, 9};

        Node root = solution.sortedArrayToBST(nums);

        System.out.println("In-order traversal of the BST:");
        solution.printTree(root);
    }

}
