package com.ayush;

public class Pattern13 {
    public static void main(String[] args) {

        int n = 4;
        int counter = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = n - i; j > 0; j--) {
                System.out.print(" ");
            }
            //////////////////////////////////

            for (int j = i; j > i - 1; j--) {
                System.out.print(j + " ");
            }

            if (counter != 1)
                System.out.print(counter + " ");

            for (int j = 0; j < i - 1; j++) {
                System.out.print(counter - i + " ");
            }

            ////////////
            counter += 2;

            System.out.println();
        }

    }
}
