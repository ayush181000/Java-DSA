package com.ayush;

public class MergeSort {

    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        mergeSort(intArray, 0, intArray.length);

        System.out.println(" ");
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(+intArray[i] + " ");
        }


    }

    public static void mergeSort(int[] input, int start, int end) {

        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        // for left array
        mergeSort(input, start, mid);
        // for right array
        mergeSort(input, mid, end);
        merge(input, start, mid, end);

    }

    public static void merge(int[] input, int start, int mid, int end) {

        if (input[mid - 1] <= input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        // copy left over array elements in left array (logically right will be over)
        System.arraycopy(input, i, input, start + tempIndex, mid - i);

        // copy whole temp array
        System.arraycopy(temp, 0, input, start, tempIndex);
    }
}
