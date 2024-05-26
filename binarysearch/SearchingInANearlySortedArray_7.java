package com.binarysearch;

public class SearchingInANearlySortedArray_7 {
    //modified binary search
/*
1. The key which we are trying to find in the nearly sorted array can be in ith index or i-1 index or i+1 index.
2. so, while checking for mid we have to check for mid+1 condition and mid-1 condition.
3. To avoid negative array size we have to check condition a[mid-1] >=start
4. To avoid exceeding array size we have to check condition a[mid+1] <=end.
5. If the key not found in mid, mid+-1, we have to change the low to mid+2, else high to mid-2.
*/
    public static void main(String[] args) {
        int[] a = {10, 3, 40, 20, 50, 80, 70};
        int key = 20;
        int result = modifiedBinarySearch(a, key);
        System.out.println(result);
    }

    public static int modifiedBinarySearch(int[] a, int key) {

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (a[mid] == key) {
                return mid;
            } else if (mid - 1 >= low && a[mid - 1] == key) {
                return mid - 1;
            } else if (mid + 1 <= high && a[mid + 1] == key) {
                return mid + 1;
            }

            if (a[mid] < key) {
                low = mid + 2;
            } else {
                high = mid - 2;
            }

        }
        return -1;
    }

}
