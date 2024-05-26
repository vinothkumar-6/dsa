package com.binarysearch;

public class FirstIndexOfFirstOneInAInfiniteSortedArray_12 {

    // Find First Index Of First 1 In Infinite Sorted Array.
    /*
    1.  As this is an infinte array we will not be knowing the high.
    2. First we have to find the high. To do that, first iteration high = 1.
    3. If key is greater than arr[high] then increase the low to high, high to high*2
    4. Do this in a while until key > arr[high]. Once key is low,
    then give the low, high and key to binary search which find the first index of an element.

    */

    public static void main(String[] args) {

        int[] a = {0, 0, 1, 1, 1, 1};
        int low = 0;
        int high = 1;
        int key = 1;
        while (key > a[high]) {
            low = high;
            high = high * 2;
        }
        int result = binarySearch(low, high, key, a);
        if (result != -1) {
            System.out.println("The First Index of the First 1 in an infinite sorted array is: " + result);
        }
    }

    public static int binarySearch(int low, int high, int key, int[] a) {
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == key) {
                result = mid;
                high = mid-1;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}
