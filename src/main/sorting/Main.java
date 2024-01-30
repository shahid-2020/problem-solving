package main.sorting;

public class Main {

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int lstIdx = arr.length - i;
            int maxIdx = 0;
            for (int j = 1; j < lstIdx; j++) {
                if(arr[j] > arr[maxIdx]){
                    maxIdx = j;
                }
            }

            int temp = arr[lstIdx-1];
            arr[lstIdx-1] = arr[maxIdx];
            arr[maxIdx] =temp;
        }
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(" " + i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {15, 54, 73, 2, 32, 54, 31, 0, -4, -7, -93};
        print(arr);
        selectionSort(arr);
        print(arr);
    }
}
