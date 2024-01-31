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
     * Space Complexity: O(n) (Considering method stack space)
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

    /**
     * Time Complexity: O(n*n)
     * Space Complexity: O(1)
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int k = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > k) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[++j] = k;
        }
    }

    /**
     * Time Complexity: O(n*n)
     * Space Complexity: O(n) (Considering method stack space)
     */
    public static void insertionSortRecursive(int[] arr, int idx) {
        if (arr.length == idx) return;

        int k = arr[idx];
        int i = idx - 1;
        while (i >= 0 && arr[i] > k) {
            arr[i + 1] = arr[i];
            i--;
        }
        arr[++i] = k;
        insertionSortRecursive(arr, idx + 1);
    }

    /**
     * Time Complexity: O(n * Log n)
     * Space Complexity: O(n)
     */
    public static void mergeSort(int[] arr, int l, int h) {
        if (l == h) return;

        int m = l + ((h - l) / 2);
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, h);
        merge(arr, l, m, h);
    }

    public static void merge(int[] arr, int l, int m, int h) {
        int[] tArr = new int[(h - l) + 1];
        int l1 = l;
        int l2 = m + 1;
        int i = 0;
        while (l1 <= m && l2 <= h) {
            if (arr[l1] < arr[l2]) {
                tArr[i++] = arr[l1++];
            } else {
                tArr[i++] = arr[l2++];
            }
        }

        while (l1 <= m) {
            tArr[i++] = arr[l1++];
        }

        while (l2 <= h) {
            tArr[i++] = arr[l2++];
        }
        i = 0;
        while (l <= h) {
            arr[l++] = tArr[i++];
        }
    }

    public static void main(String[] args) {
        int[] orgArr = {15, 54, 73, 2, 32, 54, 31, 0, -4, -7, -93};
        int[] arr = Arrays.copyOf(orgArr, orgArr.length);
        System.out.println(Arrays.toString(arr));
//        selectionSort(arr);
//        bubbleSort(arr);
//        bubbleSortRecursive(arr, arr.length);
//        insertionSort(arr);
//        insertionSortRecursive(arr, 1);
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(orgArr));
        Arrays.sort(orgArr);
        System.out.println("Is sorted: " + Arrays.equals(orgArr, arr));

    }
}
