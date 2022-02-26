package com.ayush;

public class Main {

    public static void main(String[] args) {
        System.out.println(fibbonacci(500));

        System.out.println("done");

    }

    public static int fibbonacci(int n) {

        if (n < 0) {
            return -1;
        }

        if (n == 0 || n == 1) {
            return n;
        }

        return fibbonacci(n - 1) + fibbonacci(n - 2);
    }
}
