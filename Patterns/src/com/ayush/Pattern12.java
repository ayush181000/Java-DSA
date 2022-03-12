package com.ayush;

public class Pattern12 {
    public static void main(String[] args) {

        int n = 4;
        int counter = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = n - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = counter; j > 0; j--) {
                System.out.print("*");
            }
            counter += 2;
            for (int j = n - i; j > 0; j--) {
                System.out.print(" ");
            }
            System.out.println();
        }

    }
}
