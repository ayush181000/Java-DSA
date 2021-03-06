package com.ayush;

public class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next = null;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
//        LinkedList llist = new LinkedList();
//
//        llist.head = new Node(1);
//        Node second = new Node(2);
//        Node third = new Node(3);
//
//        llist.head.next = second;
//        second.next = third;
//        llist.push(6);
//        llist.printList();

        LinkedList llist = new LinkedList();

        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("\nCreated Linked list is: ");
        llist.printList();

        llist.deleteNodePosition(4); // Delete node at position 4

        System.out.println("\nLinked List after Deletion at position 4: ");
        llist.printList();

        // recursive count
        System.out.println("Count of nodes is " + llist.getCountRec(llist.head));

        // iterative count
        System.out.println("Count of nodes is " + llist.getCount());

        /* Check the count function recursive */
        System.out.printf("\nElement at index 3 is %d", llist.getNthRec(llist.head, 3));

        /* Check the count function iterative */
        System.out.printf("\nElement at index 2 is %d", llist.getNth(2));

        llist.swapNodes(4, 3);

//        llist.pairWiseSwap();

//        llist.pairWiseSwapRec(llist.head);

        System.out.print("\n Linked list after calling swapNodes() \n");
        llist.printList();
    }

    public void printList() {
        // copying head to iterate
        Node n = head;

        // loop till node is null
        while (n != null) {
            // printing out values of linked list
            System.out.println(n.data + " ");
            n = n.next;
        }
    }

    public void push(int data) {
        // allocate a new node and assign data
        Node newNode = new Node(data);

        // make the next of new node as head;
        newNode.next = head;

        // move head to new node
        head = newNode;
    }

    public void insertAfter(Node prev_node, int new_data) {
        // check if the previous node is null
        if (prev_node == null) {
            return;
        }

        // allocate the node and put in the data
        Node new_node = new Node(new_data);

        // make next of new node as next of prev_node
        new_node.next = prev_node.next;

        // make next of prev_node as new_node
        prev_node.next = new_node;
    }

    public void append(int new_data) {
        // 1. Allocate the Node,Put in the data, Set next as null
        Node new_node = new Node(new_data);

        //If the Linked List is empty, then make the new node as head
        if (head == null) {
            head = new Node(new_data);
            return;
        }

        //This new node is going to be the last node, so make next of it as null
        new_node.next = null;

        // 5. Else traverse till the last node
        Node last = head;
        while (last.next != null) last = last.next;

        // 6. Change the next of last node
        last.next = new_node;
    }

    public void deleteNode(int key) {
        // store head node
        Node temp = head, prev = null;

        // if head node itself holds the key to be deleted
        if ((temp != null) && (temp.data == key)) {
            head = temp.next;
            return;
        }

        // Search for the key to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null) {
            return;
        }

        // Unlink the node from linked list
        prev.next = temp.next;
    }

    void deleteNodePosition(int position) {

        // If linked list is empty
        if (head == null) {
            System.out.println("Empty linked list");
        }

        // Store head node
        Node temp = head;

        // If head needs to be removed
        if (position == 0) {
            head = head.next;   // Change head
            return;
        }

        int i = 0;
        Node prev = null;
        while (temp.next != null && position != i) {
            prev = temp;
            temp = temp.next;
            i++;
        }

        prev.next = temp.next;

    }

    void deleteNodePositionAlternative(int position) {
        // If linked list is empty
        if (head == null) return;

        // Store head node
        Node temp = head;

        // If head needs to be removed
        if (position == 0) {
            head = temp.next; // Change head
            return;
        }

        // Find previous node of the node to be deleted
        for (int i = 0; temp != null && i < position - 1; i++)
            temp = temp.next;

        // If position is more than number of nodes
        if (temp == null || temp.next == null) return;

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;

        temp.next = next; // Unlink the deleted node from list
    }

    void deleteList() {
        // automatically deletes the whole list because of java garbage collector
        head = null;
    }

    int getCount() {
        Node temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    int getCountRec(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + getCountRec(node.next);
        }
    }

    boolean search(Node head, int x) {
        Node temp = head;   //Initialize current or temp
        while (temp != null) {
            if (temp.data == x) {
                return true;    //data found
            }
            temp = temp.next;
        }
        return false;   //data not found
    }

    boolean searchRec(Node head, int x) {
        // Base case
        if (head == null) {
            return false;
        }

        // If key is present in current node,
        // return true
        if (head.data == x) {
            return true;
        }

        // Recur for remaining list
        return searchRec(head.next, x);
    }

    int getNth(int index) {
        if (head == null) {
            return -1;
        }

        Node temp = head;
        int count = 0;

        while (temp != null) {
            if (count == index) {
                return temp.data;
            }
            temp = temp.next;
            count++;
        }

        /* if we get to this line, the caller was asking
        for a non-existent element so we assert fail */
        assert (false);
        return 0;
    }

    int getNthRec(Node head, int index) {
        int count = 0;
        if (head == null) {
            return -1;
        }
        if (count == index) {
            return head.data;
        } else return getNthRec(head.next, index - 1);
    }

    void swapNodes(int x, int y) {
        // Nothing to do if x and y are same
        if (x == y) return;

        // Search for x (keep track of prevX and CurrX)
        Node prevX = null, currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        // Search for y (keep track of prevY and currY)
        Node prevY = null, currY = head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        // If either x or y is not present, nothing to do
        if (currX == null || currY == null) return;

        // If x is not head of linked list
        if (prevX != null) prevX.next = currY;
        else // make y the new head
            head = currY;

        // If y is not head of linked list
        if (prevY != null) prevY.next = currX;
        else // make x the new head
            head = currX;

        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    void pairWiseSwap() {
        Node temp = head;

        /* Traverse only till there are atleast 2 nodes left */
        while (temp != null && temp.next != null) {

            /* Swap the data */
            int k = temp.data;
            temp.data = temp.next.data;
            temp.next.data = k;
            temp = temp.next.next;
        }
    }

    void pairWiseSwapRec(Node head) {
        /* There must be at-least two nodes in the list */
        if (head != null && head.next != null) {

            /* Swap the node's data with data of next node */
            int temp = head.data;
            head.data = head.next.data;
            head.next.data = temp;

            /* Call pairWiseSwap() for rest of the list */
            pairWiseSwapRec(head.next.next);
        }
    }

    Node pairWiseSwapChangingLinks(Node node) {

        // If linked list is empty or there is only one node in list
        if (node == null || node.next == null) {
            return node;
        }

        // Initialize previous and current pointers
        Node prev = node;
        Node curr = node.next;

        // Traverse the list
        while (true) {
            Node next = curr.next;
            curr.next = prev;   // Change next of current as previous node

            // If next NULL or next is the last node
            if (next == null || next.next == null) {
                prev.next = next;
                break;
            }

            // Change next of previous to next next
            prev.next = next.next;

            // Update previous and curr
            prev = next;
            curr = prev.next;
        }
        return node;
    }

    Node pairWiseSwapChangingLinksRec(Node node) {

        // Base Case: The list is empty or has only one node
        if (node == null || node.next == null) {
            return node;
        }

        // Store head of list after two nodes
        Node remaining = node.next.next;

        // Change head
        Node newHead = node.next;

        // Change next of second node
        node.next.next = node;

        // Recur for remaining list and change next of head
        node.next = pairWiseSwapChangingLinksRec(remaining);

        // Return new head of modified list
        return newHead;
    }
}
