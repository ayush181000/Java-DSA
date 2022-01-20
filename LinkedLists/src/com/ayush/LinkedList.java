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
        LinkedList llist = new LinkedList();

        llist.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        llist.head.next = second;
        second.next = third;
        llist.push(6);
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
        Node temp = head, prev = null;

        if ((temp != null) && (temp.data == key)) {
            head = temp.next;
            return;
        }

        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            return;
        }

        prev.next = temp.next;
    }
}
