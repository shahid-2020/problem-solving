package main.sorting;

import java.util.Arrays;

public class Main {

    /**
     * Time Complexity: O(n*n)
     * Space Complexity: O(1)
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int lstIdx = arr.length - i;
            int maxIdx = 0;
            for (int j = 1; j < lstIdx; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }

            int temp = arr[lstIdx - 1];
            arr[lstIdx - 1] = arr[maxIdx];
            arr[maxIdx] = temp;
        }
    }

    /**
     * Time Complexity: O(n*n)
     * Space Complexity: O(1)
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * Time Complexity: O(n*n)
     * Space Complexity: O(n) (Considering space of method stack)
     */
    public static void bubbleSortRecursive(int[] arr, int n) {
        if (n == 1) return;

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                int temp = arr[i - 1];
                arr[i - 1] = arr[i];
                arr[i] = temp;
            }
        }

        bubbleSortRecursive(arr, n - 1);
    }

    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(" " + i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] orgArr = {15, 54, 73, 2, 32, 54, 31, 0, -4, -7, -93};
        int[] arr = Arrays.copyOf(orgArr, orgArr.length);
        print(arr);
//        selectionSort(arr);
//        bubbleSort(arr);
        bubbleSortRecursive(arr, arr.length);
        print(arr);
        Arrays.sort(orgArr);
        System.out.println("Is sorted: " + Arrays.equals(orgArr, arr));

    }
}
