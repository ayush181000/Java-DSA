package com.ayush;

public class Pattern8 {

    public static void main(String[] args) {

        int n = 4;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j > 0; j--) {
                System.out.print((char) ('A' + n - j) + " ");
            }
            System.out.println();
        }
    }
}
