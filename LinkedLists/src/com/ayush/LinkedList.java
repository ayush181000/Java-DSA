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
        llist.push(1);
        llist.push(3);
        llist.push(2);
        llist.push(8);

        System.out.println("\nCreated Linked list is: ");
        llist.printList();

        llist.deleteNodePosition(4); // Delete node at position 4

        System.out.println("\nLinked List after Deletion at position 4: ");
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
}
