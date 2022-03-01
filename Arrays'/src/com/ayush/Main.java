package com.ayush;

public class Main {

    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        rotateArray3(intArray, 3);

        printArray(intArray);

    }


    /* ROTATION OF ARRAY */
    public static void rotateArray1(int[] array, int d) {

        // Using temp array
        int[] temp = new int[array.length];
        System.arraycopy(array, d, temp, 0, array.length - d);
        System.arraycopy(array, 0, temp, array.length - d, d);

    }

    public static void rotateArray2(int[] array, int d) {

        // By shifting elements one by one
        for (int i = 0; i < d; i++) {
            int temp = array[0];
            int j;
            for (j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[j] = temp;
        }

    }

    public static void rotateArray3(int[] array, int d) {

        // Juggling algorithm
        int n = array.length;
        int j, k;

        int gcd = findGCD(n, d);
        System.out.println(gcd);


        for (int i = 0; i < gcd; i++) {
            int temp = array[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n) {
                    k = k - n;
                }
                if (k == i) {
                    break;
                }
                array[j] = array[k];
                j = k;
            }
            array[j] = temp;

        }

    }

    /* UTILITY FUNCTIONS */

    public static void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    public static int findGCD(int a, int b) {
        if (b == 0) return a;

        return findGCD(b, a % b);
    }

}
