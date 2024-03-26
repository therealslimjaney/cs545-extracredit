// Given the root of a binary tree, invert the tree, and return its root.
class InvertBinaryTree {

    private static class Node {
        int data;
        Node left;
        Node right;

        private Node(int x) {
            data = x;
        }
    }

    private static class CustomQueue {
        private Node[] array;
        private int size;
        private int capacity;
        private int front;
        private int end;

        public CustomQueue(int capacity) {
            this.capacity = capacity;
            this.array = new Node[capacity];
            this.size = 0;
            this.front = 0;
            this.end = -1;
        }

        public void add(Node node) {
            end = (end + 1) % capacity;
            array[end] = node;
            size++;
        }

        public Node poll() {
            Node node = array[front];
            front = (front + 1) % capacity;
            size--;
            return node;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    private static void printTree(Node root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.data + " ");
            printTree(root.right);
        }
    }

    public static Node invertBinaryTree(Node root) {
        if (root == null) return null;
        CustomQueue queue = new CustomQueue(50); // I'm just setting to 50 because task wasn't about Queues
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            Node temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }

    public static void main(String[] args) {
        // Creating a simple binary tree.
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Original Tree:");
        printTree(root);

        root = invertBinaryTree(root);

        System.out.println("\nInverted Tree:");
        printTree(root);
    }
}