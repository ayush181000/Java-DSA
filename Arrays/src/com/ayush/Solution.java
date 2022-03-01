package com.ayush;

import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int layers;
        int[] cake;
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            cake = new int[scanner.nextInt()];
            for (int j = 0; j < cake.length; j++) {
                cake[j] = scanner.nextInt();
            }
//            printArray(cake);
            int temp = cake[cake.length - 1];
            for (int var = cake.length - 1; var >= 0; var--) {
                temp = max(temp, cake[var]);
                if (temp >= 1) {

                    cake[var] = 1;
                    temp--;
                }
            }
            printArray(cake);

        }

    }

    public static void printArray(int[] intArray) {
        System.out.println(" ");
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(+intArray[i] + " ");
        }
    }

    public static int max(int a, int b) {
        if (a > b) return a;
        return b;
    }
}
