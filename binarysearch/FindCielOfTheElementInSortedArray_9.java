package com.binarysearch;

public class FindCielOfTheElementInSortedArray_9 {
    // return the next greatest element of key, not the index.
    /*
     1. The ciel of the element is the same element or next largest element to the key.
     2. If key is present return the key, else next largest element.
     3. We have to store the result if the mid is greater than key.

    */

    public static int binarySearchCiel(int[] a, int key){

        int low=0;
        int high=a.length-1;
        int result =-1;
        while(low<=high){
            int mid= low + (high-low)/2;

            if(a[mid] == key){
                return a[mid];
            }

            if(a[mid] < key){
                low = mid+1;
            } else if(a[mid] > key){
                result = a[mid];
                high = mid -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a={1,3,5,6};
        int key=7;

        int result = binarySearchCiel(a,key);
        System.out.println(result);
    }
}
