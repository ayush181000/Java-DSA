package Sorting;

import java.util.*;

public class RadixSort {

    public static int max(int arr[], int n) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(arr[i], max);
        }

        return max;
    }

    public static void countSort(int[] arr, int n, int exp) {
        int[] output = new int[n];
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (i = 0; i < n; i++)
            arr[i] = output[i];

    }

    public static void printArray(int[] arr, int n) {
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = new int[] { 123, 456, 678, 789, 34, 56, 78, 12, 89, 45, 67, 23, 78, 56 };
        int n = arr.length;

        int m = max(arr, n);
        for (int exp = 1; m / exp > 0; exp++) {
            countSort(arr, n, exp);
        }

        printArray(arr, n);
    }
}
