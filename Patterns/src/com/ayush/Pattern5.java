package com.ayush;

public class Pattern5 {
    public static void main(String[] args) {
        int n = 4;
        int i = 1;

        while (i <= n) {
            int j = 1;
            while (j <= n) {
                System.out.print((n - j + 1) + " ");
                j++;
            }
            System.out.println();
            i++;
        }
    }

}
