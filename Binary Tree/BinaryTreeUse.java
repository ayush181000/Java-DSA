import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class BinaryTreeUse {

    public static void changeToDepthTreeHelper(BinaryTreeNode<Integer> root, int level) {
        if (root == null) {
            return;
        }

        root.data = level;

        changeToDepthTreeHelper(root.left, level + 1);
        changeToDepthTreeHelper(root.right, level + 1);
    }

    public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
        changeToDepthTreeHelper(root, 0);
    }

    public static int numberOfLeaves(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return numberOfLeaves(root.left) + numberOfLeaves(root.right);
    }

    public static int heightTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = heightTree(root.left);
        int rightHeight = heightTree(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            return 0;
        }

        int count = root.data > x ? 1 : 0;

        count += countNodesGreaterThanX(root.left, x);
        count += countNodesGreaterThanX(root.right, x);

        return count;

    }

    public static int largestNode(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return -1;
        }

        int leftLargest = largestNode(root.left);
        int rightLargest = largestNode(root.right);

        return Math.max(root.data, Math.max(leftLargest, rightLargest));

    }

    public static int numberOfNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }

        return numberOfNodes(root.left) + numberOfNodes(root.right) + 1;
    }

    public static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot, int parentData, boolean isLeft) {
        if (isRoot) {
            System.out.println("Enter root data : ");
        } else {
            if (isLeft) {
                System.out.println("Enter left child of " + parentData + " : ");
            } else {
                System.out.println("Enter right child of " + parentData + " : ");
            }
        }

        Scanner s = new Scanner(System.in);
        int rootData = s.nextInt();

        if (rootData == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        BinaryTreeNode<Integer> leftChild = takeTreeInputBetter(false, rootData, true);
        BinaryTreeNode<Integer> rightChild = takeTreeInputBetter(false, rootData, false);

        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    public static BinaryTreeNode<Integer> takeTreeInput() {
        System.out.println("Enter root data : ");
        Scanner s = new Scanner(System.in);
        int rootData = s.nextInt();

        if (rootData == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        BinaryTreeNode<Integer> leftChild = takeTreeInput();
        BinaryTreeNode<Integer> rightChild = takeTreeInput();

        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

    public static void printTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + ":");
        // printTree(root.left);
        // printTree(root.right);

        if (root.left != null)
            System.out.print("L " + root.left.data + ",");

        if (root.right != null)
            System.out.print("R " + root.right.data + ",");

        System.out.println();

        printTree(root.left);
        printTree(root.right);
    }

    public static void printTreeAtDepthK(BinaryTreeNode<Integer> root, int k) {
        if (root == null) {
            return;
        }

        if (k == 0) {
            System.out.println(root.data);
            return;
        }

        printTreeAtDepthK(root.left, k - 1);
        printTreeAtDepthK(root.right, k - 1);
    }

    public static BinaryTreeNode<Integer> removeLeafNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return null;
        }

        root.left = removeLeafNodes(root.left);
        root.right = removeLeafNodes(root.right);

        return root;
    }

    public static void mirrorTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        mirrorTree(root.left);
        mirrorTree(root.right);

        BinaryTreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static boolean isBalanced(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return true;
        }

        int leftHeight = heightTree(root.left);
        int rightHeight = heightTree(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        boolean isLeftBalanced = isBalanced(root.left);
        boolean isRightBalanced = isBalanced(root.right);

        return isLeftBalanced && isRightBalanced;

    }

    public static BalanceTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new BalanceTreeReturn(0, true);
        }

        BalanceTreeReturn leftOutput = isBalancedBetter(root.left);
        BalanceTreeReturn rightOutput = isBalancedBetter(root.right);

        boolean isBal = true;
        int height = 1 + Math.max(leftOutput.height, rightOutput.height);

        if (Math.abs(leftOutput.height - rightOutput.height) > 1) {
            isBal = false;
        }

        if (!leftOutput.isBalanced || !rightOutput.isBalanced) {
            isBal = false;
        }

        return new BalanceTreeReturn(height, isBal);
    }

    public static Pair diameterHelper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair leftPair = diameterHelper(root.left);
        Pair rightPair = diameterHelper(root.right);

        int leftDiameter = leftPair.diameter;
        int rightDiameter = rightPair.diameter;

        /**
         * 'dist' denotes the longest distance between deepest
         * node of the left subtree and deepest node of the right subtree
         */

        int dist = leftPair.height + rightPair.height + 1;

        int diameter = Math.max(leftDiameter, Math.max(rightDiameter, dist));
        int height = Math.max(leftPair.height, rightPair.height) + 1;

        return new Pair(diameter, height);
    }

    public static int diameter(BinaryTreeNode<Integer> root) {
        Pair pair = diameterHelper(root);
        return pair.diameter;
    }

    public static BinaryTreeNode<Integer> takeInputLevelWise() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter root data : ");
        int rootData = s.nextInt();

        if (rootData == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<BinaryTreeNode<Integer>>();
        pendingChildren.add(root);

        while (!pendingChildren.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingChildren.poll();

            System.out.println("Enter left child of " + front.data);
            int left = s.nextInt();
            if (left != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(left);
                front.left = leftChild;
                pendingChildren.add(leftChild);
            }

            System.out.println("Enter right child of " + front.data);
            int right = s.nextInt();
            if (right != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(right);
                front.right = rightChild;
                pendingChildren.add(rightChild);
            }

        }

        return root;
    }

    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode<Integer>> pendingNode = new LinkedList<BinaryTreeNode<Integer>>();
        pendingNode.add(root);

        while (!pendingNode.isEmpty()) {
            BinaryTreeNode<Integer> frontNode = pendingNode.poll();

            if (frontNode == null) {
                System.out.println();

                if (!pendingNode.isEmpty()) {
                    pendingNode.add(null);
                }
            } else {
                System.out.println(frontNode.data + ":L:");

                if (frontNode.left != null) {
                    pendingNode.add(frontNode.left);
                    System.out.println(frontNode.left.data + ",R:");
                } else {
                    System.out.println(-1 + ",R:");
                }

                if (frontNode.right != null) {
                    pendingNode.add(frontNode.right);
                    System.out.println(frontNode.right.data + ",R:");
                } else {
                    System.out.println(-1 + ",R:");
                }
            }
        }
    }

    public static BinaryTreeNode<Integer> buildTreeHelper(int[] preOrder, int preStart, int preEnd, int[] inOrder,
            int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = preOrder[preStart];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootVal);

        // Find root element index from inOrder array
        int k = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (rootVal == inOrder[i]) {
                k = i;
                break;
            }
        }

        root.left = buildTreeHelper(preOrder, preStart + 1, (k - inStart), inOrder, inStart, k - 1);
        root.right = buildTreeHelper(preOrder, preStart + (k - inStart), preEnd, inOrder, k + 1, inEnd);

        return root;
    }

    public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
        int n = preOrder.length;

        int preStart = 0;
        int preEnd = n - 1;
        int inStart = 0;
        int inEnd = n - 1;

        return buildTreeHelper(preOrder, preStart, preEnd, inOrder, inStart, inEnd);
    }

    public static boolean searchBST(BinaryTreeNode<Integer> root, int val) {
        if (root == null) {
            return false;
        }

        if (root.data == val) {
            return true;
        }

        if (root.data < val) {
            return searchBST(root.right, val);
        }

        return searchBST(root.left, val);

    }

    public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            elementsInRangeK1K2(root.left, k1, k2);
            System.out.println(root.data + " ");
            elementsInRangeK1K2(root.right, k1, k2);
        } else if (root.data < k1) {
            elementsInRangeK1K2(root.right, k1, k2);
        } else if (root.data > k1) {
            elementsInRangeK1K2(root.left, k1, k2);
        }
    }

    public static BinaryTreeNode<Integer> SortedArrayToBSTHelper(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;

        BinaryTreeNode<Integer> temp = new BinaryTreeNode<Integer>(arr[mid]);
        temp.left = SortedArrayToBSTHelper(arr, start, mid - 1);
        temp.right = SortedArrayToBSTHelper(arr, mid + 1, end);
        return temp;

    }

    public static BinaryTreeNode<Integer> sortedArrayToBST(int[] arr, int n) {
        return SortedArrayToBSTHelper(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        /**
         * recursion input
         */
        // BinaryTreeNode<Integer> root = takeTreeInputBetter(true, 0, true);

        /**
         * level wise input
         */
        BinaryTreeNode<Integer> root = takeInputLevelWise();

        System.out.println("Tree : ");
        // printTree(root);
        printLevelWise(root);
        System.out.println("___________________ ");

        System.out.println("Number of nodes : " + numberOfNodes(root));

        System.out.println("Largest node in tree : " + largestNode(root));

        System.out.println("Number of nodes greater than x" + countNodesGreaterThanX(root, 20));

        System.out.println("Height of tree" + heightTree(root));

        System.out.println("Number of leaves" + numberOfLeaves(root));

        // System.out.println("Tree printed at level K");
        // printTreeAtDepthK(root, 2);

        // changeToDepthTree(root);

        // BinaryTreeNode<Integer> newRoot = removeLeafNodes(root);

        // mirrorTree(root);

        System.out.println("Is Balanced : " + isBalanced(root));
        System.out.println("Tree : ");
        printTree(root);
        System.out.println("___________________ ");

        System.out.println("Diameter : " + diameter(root));

        /**
         * used to make tree from preorder and inorder traversal string
         */
        // int in[] = { 4, 2, 5, 1, 3 };
        // int pre[] = { 1, 2, 4, 5, 3 };
        // BinaryTreeNode<Integer> newRoot = buildTree(pre, in);
        // printTree(newRoot);

        /**
         * used to make binary tree from sorted array
         */
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        BinaryTreeNode<Integer> newRoot = sortedArrayToBST(arr, arr.length);
        printTree(newRoot);

    }
}
// 1 2 3 4 5 6 7 -1 -1 -1 -1 8 9 -1 -1 -1 -1 -1 -1
