package com.binarysearch;

public class CountOfAnElementInASortedArray_4 {
// O(log n)
/*
 * 1. low =0;
 * 2. high = array.length-1;
 * 3. increase mid with key value greater or higher.
 * 4. mid = low + (high-low)/2;
 * if the element is found in mid, to check the occurrence of first left shift the high and store the result variable.
 * if the element is found in mid, to check the occurrence of last right shift the low and store the result variable.
 * the count will be lastOccurrence-firstOccurrence +1.
 * */
    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8, 9, 10, 11, 12, 23};
        int low = 0;
        int high = a.length - 1;
        int key = 7;
        int initialCountIndex = binarySearchInCount(a, low, high, key);
        int lastCountIndex = binarySearchLastCount(a, low, high, key);
        if (initialCountIndex != -1 && lastCountIndex != -1) {
            int totalcount = lastCountIndex - initialCountIndex + 1;
            System.out.println("Total Count of the element is: " + totalcount);
        }

    }

    public static int binarySearchInCount(int[] a, int low, int high, int key) {
        int result = -1;
        while (low <= high) {

            int mid = low + (high - low) / 2;
            if (a[mid] == key) {
                result = mid;
                high = mid - 1;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static int binarySearchLastCount(int[] a, int low, int high, int key) {
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == key) {
                result = mid;
                low = mid + 1;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}
