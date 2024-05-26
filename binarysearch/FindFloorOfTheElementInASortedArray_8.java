package com.binarysearch;

public class FindFloorOfTheElementInASortedArray_8 {
// return the nearest element to key not the index.
    /*
     1. The floor of the element is key or the nearest element to the key.
     2. If key is present return the key, else nearest element.
     3. We have to store the result if the mid is less than key.

    */

    public static int binarySearchFloor(int[] a, int key){
        int result=-1;
        int low=0;
        int high=a.length-1;
        while(low<=high){
          int mid = low +(high-low)/2;
            if(a[mid] == key){
                return a[mid];
            }
            if(a[mid] < key){
                result = a[mid];
                low = mid+1;
            } else if(a[mid] > key){
                high = mid-1;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] a={1, 2, 8, 10, 10, 12, 19};
        int key = 5;
        int result = binarySearchFloor(a,key);
        System.out.println(result);
    }

}
