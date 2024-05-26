package com.binarysearch;

public class FindTheMaximumElementInABitonicArray_15 {
    /*
Monotonic array is an array in which a(i) will not be same as a(I+1)

Bitonic array is an array in which the array will increase upto peak and decrease.
Note: There will be only one peak element in a bitonic array

So, the peak element will be the maximum element.

 Steps to find the peak element index
      1.  if mid > mid+1 and mid < mid-1, then return mid. else go to left or right.
      2. To go to left or right we have to check which side is greater than mid element.
       if left is greater, then consider mid -1 as mid and compare. Else mid +1 as mid and compare.
       //edge condition
      3. At last we have to check if the peak is in low or high.
       1. If Low > low +1.
       2. if high > high -1.
     */

    public static void main(String[] args) {
        int a[] = {1,3,5,6,7,5,4,3,2,1};
        int low =0;
        int high  = a.length-1;
        int result = binarySearchPeakElement(a,low,high);
        if(result!=-1){
            System.out.println("The peak element is: "+result);
        } else{
            System.out.println("issue in code. Peak element not found");
        }
    }

    public static int binarySearchPeakElement(int[] a, int low, int high){

        while(low<=high){

            int mid= low + (high-low)/2;
            if(mid > 0 && mid < a.length-1){
                if(a[mid] > a[mid+1] && a[mid] > a[mid-1]){
                    return mid;
                } else if(a[mid] < a[mid-1]){
                    low = mid +1;
                } else{
                    high = mid -1;
                }

            } else if (mid ==0 ){
                if(a[mid] > a[mid+1]){
                    return mid;
                } else {
                    return mid+1;
                }
            } else if(mid == a.length-1){
                if(a[mid] > a[mid-1]){
                    return mid;
                } else {
                    return mid-1;
                }
            }
        }
        return -1;
    }
}
