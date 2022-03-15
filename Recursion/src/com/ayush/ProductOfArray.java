// package com.ayush;

import java.sql.Array;

public class ProductOfArray {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        System.out.println(productOfArray(arr, arr.length));
    }

    public static int productOfArray(int[] arr, int n) {
        if (n < 0) {
            return -1;
        }

        if (n == 0) {
            return arr[0];
        }

        return arr[n - 1] * productOfArray(arr, n - 1);

    }

}
