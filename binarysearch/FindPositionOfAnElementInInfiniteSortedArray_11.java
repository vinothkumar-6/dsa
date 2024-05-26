package com.binarysearch;

public class FindPositionOfAnElementInInfiniteSortedArray_11 {
// Find Position Of An Element In Infinite Sorted Array.
    /*
    1.  As this is an infinte array we will not be knowing the high.
    2. First we have to find the high. To do that, first iteration high = 1.
    3. If key is greater than arr[high] then increase the low to high, high to high*2
    4. Do this in a while until key > arr[high]. Once key is low,
    then give the low, high and key to normal binary search.

    */

    public static void main(String[] args) {

        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,15,16,17,18};
        int key = 9;
        int low = 0;
        int high = 1;
        while (key > a[high]){
            low = high;
            high = high *2;
            System.out.println("Low: "+low);
            System.out.println("High: "+high);
        }
        System.out.println("Final low, high: "+low+", "+high);
        int result = binarySearch(a, low, high, key);
        if(result !=-1)
            System.out.println(result);
        else
            System.out.println("Element not found");
    }

    public static int binarySearch(int[] a, int low, int high, int key){

        System.out.println("Key: "+key);
        while(low<=high){
            int mid = low + (high-low)/ 2;
            System.out.println("Low: "+low);
            System.out.println("mid: "+mid);
            System.out.println("High: "+high);
            if(key == a[mid]){
                System.out.println("returning mid: "+mid);
                return mid;
             } else if (key > a[mid]){
                low = mid +1;
            } else {
                high = mid -1;
            }

        }
        return -1;
    }


}
