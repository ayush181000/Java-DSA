package com.ayush;

public class ManmohanLovesPattern2 {

    public static void main(String[] args) {
        int n = 5;

        if (n <= 0) return;

        System.out.println("1");
        if (n == 1) return;

        int i = 1;
        while (i < n) {

            int j = 1;
            while (j <= i+1) {
                if (j == 1 || j == i+1) System.out.print(i + " ");
                else System.out.print("0 ");
                j++;
            }
            System.out.println();
            i++;
        }

    }
}
