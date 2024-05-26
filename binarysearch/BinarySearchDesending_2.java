package com.binarysearch;

public class BinarySearchDesending_2 {

    /*
     * 1. low =0;
     * 2. high = array.length-1;
     * 3. increase mid with key value greater or higher. reserve the logic as its a desending array.
     * a[mid] >key
     * low = mid + 1
     * else
     *  high = mid - 1

     * 4. mid = low + (high-low)/2;
     *
     * */

    public static void main(String[] args) {
        int a[] = {20, 15, 10, 5, 4, 3, 2};
        int key = 4;
        System.out.println(binarySearchDesending(a, key));
    }

    public static int binarySearchDesending(int[] a, int key) {

        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] >key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
