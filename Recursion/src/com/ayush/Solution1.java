// package com.ayush;

import java.util.Scanner;

public class Solution1 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        for (int i = 0; i < t; i++) {

            int n = s.nextInt();
            int k = s.nextInt();

            int[] arr = new int[n * k];

            for (int j = 0; j < n; j++) {
                arr[j] = s.nextInt();
            }

            // main logic here
            for (int l = n; l < k * n; l++) {
                arr[l] = arr[l - n];
            }

            // printArray(arr);

            int maxSoFar = arr[0];
            int maxEndingHere = 0;

            printArray(arr);
            for (int z = 0; z < arr.length; z++) {
                maxEndingHere = maxSoFar + arr[z];
                if (maxSoFar < maxEndingHere) {
                    maxSoFar = maxEndingHere;
                }
                if (maxEndingHere < 0) {
                    maxEndingHere = 0;
                }

            }

            System.out.println(maxSoFar - arr[0] + " ");

        }

    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
