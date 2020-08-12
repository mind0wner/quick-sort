package com.sorting.quicksort;

import java.util.Random;

public class QuickSort {
    private static final int ARRAY_LENGTH = 30;
    private static final int[] ARRAY = new int[ARRAY_LENGTH];
    private static final Random GENERATOR = new Random();

    private static void init() {
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            ARRAY[i] = GENERATOR.nextInt(100);
        }
    }

    private static void printArray() {
        for (int i = 0; i < ARRAY_LENGTH - 1; i++) {
            System.out.print(ARRAY[i] + ", ");
        }
        System.out.println(ARRAY[ARRAY_LENGTH - 1]);
    }

    public static void main(String[] args) {
        init();
        quickSort(ARRAY, 0, ARRAY_LENGTH - 1);
        printArray();
    }

    private static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;

        return i + 1;
    }
}