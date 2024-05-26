package com.binarysearch;

public class NextAlphabeticalElement_10 {

    /*
     1. The NextAlphabeticalElement is the next largest element to the key.
     2. Even If key is present return next largest element.
     3. We have to store the result if the mid is greater than key.

    * */

    public static char binarySearchNextAlphabet(char[] a, char key){
        int low=0;
        int high= a.length-1;
        char result = 0;
        while(low<=high){
            int mid= low + (high - low)/2;
            if(a[mid] == key){
                low=mid+1;
            } else if(a[mid] < key){
                low=mid+1;
            } else if(a[mid] > key){
                result = a[mid];
                high = mid -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[] a = {'a','b','d','e'};
        char key ='b';
        char result = binarySearchNextAlphabet(a,key);
        System.out.println(result);
    }
}
