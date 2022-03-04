package com.ayush;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();

            int[] arr = new int[n];

            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }

            int[] count = new int[101];

            for (int j = 0; j < arr.length; j++) {
                count[arr[j]]++;
            }

            for (int j = 0; j < 101; j++) {
                if (count[j] > 0) {
                    System.out.print(j + " ");
                    count[j]--;
                }
            }

            for (int j = 0; j < 101; j++) {
                for (int k = 0; k < count[j]; k++)
                    System.out.print(j + " ");
            }
            System.out.println(" ");


        }
    }

//    public static void printArray(int[] intArray) {
//        System.out.println(" ");
//        for (int i = 0; i < intArray.length; i++) {
//            System.out.print(intArray[i] + " ");
//        }
//    }
}
