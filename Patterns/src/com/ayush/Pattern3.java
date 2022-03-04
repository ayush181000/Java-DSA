package com.ayush;

public class Pattern3 {
    public static void main(String[] args) {

        int n = 4;

        for (int i = 1; i <= n; i++) {
            int counter = i;
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            for (int j = i; j > 0; j--) {
                System.out.print(counter++ + " ");
            }
            System.out.println(" ");
        }
    }
}
