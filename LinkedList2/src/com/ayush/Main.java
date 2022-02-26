package com.ayush;

public class Main {

    public static void main(String[] args) {

        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 456);
        Employee marySmith = new Employee("Mary", "Smith", 789);
        Employee mikeWilson = new Employee("Mike", "Wilson", 256);

        EmployeeLinkedList list = new EmployeeLinkedList();

        System.out.println(list.isEmpty());


        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);
        list.addToFront(mikeWilson);

        System.out.println(list.getSize());

        list.printList();

        list.removeFromFront();
        System.out.println(list.getSize());
        list.printList();

    }
}
