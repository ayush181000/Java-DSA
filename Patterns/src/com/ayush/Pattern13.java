package com.ayush;

public class Pattern13 {
    public static void main(String[] args) {

        int n = 4;
        int currRow = 1;

        while (currRow <= n) {

            int spaces = 1;
            while (spaces <= n - currRow) {
                System.out.print(" ");
                spaces++;
            }

            int currCol = 1;
            int valToPrint = currRow;
            while (currCol <= currRow) {
                System.out.print(valToPrint);
                valToPrint++;
                currCol++;
            }

            currCol = 1;
            valToPrint = 2 * currRow - 2;
            while (currCol <= currRow - 1) {
                System.out.print(valToPrint);
                valToPrint -= 1;
                currCol += 1;
            }

            System.out.println();
            currRow++;
        }

    }
}
