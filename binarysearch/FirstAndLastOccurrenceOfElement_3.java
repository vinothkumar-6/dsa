package com.binarysearch;

public class FirstAndLastOccurrenceOfElement_3 {

    /*
     * 1. low =0;
     * 2. high = array.length-1;
     * 3. increase mid with key value greater or higher.
     * 4. mid = low + (high-low)/2;
     * if the element is found in mid, to check the occurrence of first left shift the high and store the result variable.
     * if the element is found in mid, to check the occurrence of last right shift the low and store the result variable.
     * */

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 6, 7, 87, 555, 555, 666, 777, 888, 999, 1000, 1000, 1000};
        int key = 1000;
        int low = 0;
        int high = a.length - 1;
        int firstOccurrence = firstOccurrence(a, key, low, high);
        System.out.println("firstOccurrence: "+firstOccurrence);
        int lastOccurrence = lastOccurrence(a, key, low, high);
        System.out.println("lastOccurrence: "+lastOccurrence);

    }

    public static int firstOccurrence(int[] a, int key,int low, int high) {
        int result =-1;
        while(low<=high){
            int mid= low +(high-low)/2;
            if(a[mid] == key){
                result = mid;
                high= mid-1;
            } else if(a[mid] < key){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
 return result;
    }

    public static int lastOccurrence(int[] a, int key,int low, int high) {
        int result =-1;
        while(low<=high){
            int mid= low +(high-low)/2;
            if(a[mid] == key){
                result = mid;
                low= mid+1;
            } else if(a[mid] < key){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        return result;
    }
}
