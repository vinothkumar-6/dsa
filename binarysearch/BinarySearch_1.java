package com.binarysearch;

public class BinarySearch_1 {
    /*
    * 1. low =0;
    * 2. high = array.length-1;
    * 3. increase mid with key value greater or higher.
    * 4. mid = low + (high-low)/2;
    * */

    public static void main(String[] args) {

        int[] a = {1, 4, 5, 6, 7, 8, 23, 67, 89, 423};
        int key = 67;
        int low = 0;
        int high = a.length-1;
        int result = binarySearch(a, key);
        if (result != -1) {
            System.out.println("Key found on index: " + result);
        } else {
            System.out.println("Key not found");
        }
      int recursive =  binarySerachRecursive(low,high,89,a);
        System.out.println("Key found on index: " + recursive);
    }
    public static int binarySearch(int[] a, int key){
        int low = 0;
        int high = a.length-1;
        while(low<=high){
            int mid= low + (high-low)/2;
            if(a[mid] == key){
                return mid;
            } else if(a[mid] < key){
                low = mid +1;
            } else {
                high = mid -1;
            }
        }
        return -1;
    }

    public static int binarySerachRecursive(int low, int high, int key, int[] a){

        if(low>high){
            return -1;
        }

        int mid= low +(high-low)/2;

        if(a[mid] == key){
            return mid;
        } else if (a[mid] < key){
          return  binarySerachRecursive(mid+1,high,key,a);
        } else{
          return  binarySerachRecursive(low,mid-1,key,a);
        }

    }

}
