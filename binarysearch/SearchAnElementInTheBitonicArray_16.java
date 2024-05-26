package com.binarysearch;

public class SearchAnElementInTheBitonicArray_16 {

    /*
    1. Find the peak element.
    2. After finding the peak element divide the array into two parts.
    3, Part 1: low =0 upto high= peak-1. Apply normal binary search and find if the key is present.
    4. Part 4: low = peak and high = a.length -1. Apply desc binary search and find if the key is present.
    5. If key is present in either, return key else display key not found.
    */

    public static void main(String[] args) {

        int[] a = {-3, 9, 8, 20, 17, 5, 1};
        int low =0;
        int high =a.length-1;
        int key =20;

        int peak = binarySearchPeakElement(a,low,high);
        if(peak !=-1){
            int ascBS = binarySearchASC(a,0,peak-1,key);
            if(ascBS!=-1){
                System.out.println("key found on ASC Index: "+ascBS);
            } else{
                int dscBS = binarySearchDESC(a, peak,a.length-1,key);
                if(dscBS!=-1){
                    System.out.println("key found on DESC Index: "+dscBS);
                } else{
                    System.out.println("key not found on both ASC and DESC Indexes");
                }
            }

        } else {
            System.out.println("Peak element not found, So key cannot be found!");
        }
    }

    public static int binarySearchPeakElement(int[] a, int low, int high){

        while(low<=high){
            int mid = low + (high-low)/2;
            if(mid > 0 && mid < a.length-1){
                if(a[mid] > a[mid+1] && a[mid] > a[mid-1]){
                    return mid;
                } else if( a[mid] < a[mid-1]){
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            } else if (mid ==0 ){
                if(a[mid] > a[mid+1]){
                    return mid;
                } else {
                    return mid+1;
                }
            } else if (mid == a.length-1){
                if(a[mid] > a[mid-1]){
                     return mid;
                } else{
                    return mid-1;
                }
            }
        }
        return -1;
    }

    public static int binarySearchASC(int[] a, int low, int high, int key){
        while(low<=high){
            int mid= low + (high-low)/2;
            if(a[mid] == key){
                return mid;
            } else if (a[mid] < key){
                low = mid +1;
            } else {
                high = mid -1;
            }
        }
        return -1;
    }

    public static int binarySearchDESC(int[] a, int low, int high, int key){
        while(low<=high){
            int mid= low + (high-low)/2;
            if(a[mid] == key){
                return mid;
            } else if (a[mid] < key){
                high = mid -1;
            } else {
                low = mid +1;
            }
        }
        return -1;
    }


}
