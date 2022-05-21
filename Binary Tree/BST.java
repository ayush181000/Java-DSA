// 14

public class BST {
    private BinaryTreeNode<Integer> root;
    private int size;

    private static boolean isPresentHelper(BinaryTreeNode<Integer> node, int x) {
        if (node == null) {
            return false;
        }

        if (node.data == x) {
            return true;
        }

        if (x < node.data) {
            // call on left side
            return isPresentHelper(node.left, x);
        } else {
            // call on right side
            return isPresentHelper(node.right, x);
        }
    }

    public boolean isPresent(int x) {
        return isPresentHelper(this.root, x);
    }

    public void insert(int data) {
        root = insert(data, root);
    }

    private BinaryTreeNode<Integer> insert(int data, BinaryTreeNode<Integer> root) {
        if (root == null) {
            BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(data);
            return newNode;
        }

        if (root.data >= data) {
            root.left = insert(data, root.left);
        } else {
            root.right = insert(data, root.right);
        }

        return root;
    }

    public boolean delete(int data) {
        root = remove(data, root);
        return root == null ? false : true;
    }

    private BinaryTreeNode<Integer> remove(int data, BinaryTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }

        if (data < root.data) {
            root.left = remove(data, root.left);
            return root;
        } else if (data > root.data) {
            root.left = remove(data, root.left);
            return root;
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                BinaryTreeNode<Integer> minNode = root.right;
                while (minNode.left != null) {
                    minNode = minNode.left;

                }
                root.data = minNode.data;
                root.right = remove(minNode.data, root.right);
                return root;
            }
        }
    }

    public int size() {
        return size;
    }

    private static void printTreeHelper(BinaryTreeNode<Integer> node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + ":");

        if (node.left != null)
            System.out.print("L " + node.left.data + ",");

        if (node.right != null)
            System.out.print("R " + node.right.data + ",");

        System.out.println();

        printTreeHelper(node.left);
        printTreeHelper(node.right);
    }

    public void printTree() {
        printTreeHelper(this.root);
    }
}
