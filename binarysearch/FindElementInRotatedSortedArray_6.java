package com.binarysearch;

public class FindElementInRotatedSortedArray_6 {

    // 1. we have to find the minimum element's index
    // (if the element is smaller than both previous and next element then it is the minimum element.)
    //2. Divide the arr into two arrays and apply binary search individually.
    //array 1: low =0, high= indexofMinimumelement-1.
    //array 2: low= indexofMinimumelement; high = n-1;
    //3. Any one array should give me the key index. other -1.

    public static void main(String[] args) {
        int[] a = {3,4,5,6,1,2};
        int key = 0;
        int low = 0;
        int high = a.length - 1;
        int n = a.length;
        int indexOfMinElement = binarySearchSortedArray(a, low, high, n);
        if (indexOfMinElement != -1) {
            int sorted = binarySearch(a, key, indexOfMinElement, high);
            if (sorted != -1) {
                System.out.println("Key element found in index: " + sorted);
            } else {
                int unSorted = binarySearch(a, key, low, indexOfMinElement - 1);
                if (unSorted != -1) {
                    System.out.println("Key element found in index: " + unSorted);
                }
            }
        } else {
            System.out.println("Array is not rotated");
        }
    }

    public static int binarySearch(int[] a, int key, int low, int high) {

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchSortedArray(int[] a, int low, int high, int n) {

        while (low <= high) {
            if (a[low] <= a[high]) {
                return low;
            }
            int mid = low + (high - low) / 2;
            int next = a[(mid + 1) % n];
            int prev = a[(mid - 1 + n) % n];

            if ((a[mid] <= a[prev]) && a[mid] <= a[next]) {
                return mid;
            }
            if (a[low] <= a[mid]) {
                low = mid + 1;
            } else if (a[mid] <= a[high]) {
                high = mid - 1;
            }
        }
        return -1;
    }


}

