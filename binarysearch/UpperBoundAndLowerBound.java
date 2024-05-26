package com.binarysearch;

public class UpperBoundAndLowerBound {

    /*
    Given a sorted array arr[] of N integers and a number K,
    the task is to write the C program to find the upper_bound()
    and lower_bound() of K in the given array.

    input: arr[] = {4, 6, 10, 12, 18, 20}, K = 6
     */


    public static int lowerBound(int[] a, int key){

        int low = 0;
        int high = a.length - 1;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(a[mid] >= key){
                ans = mid;
                high = mid - 1;
            } else{
                low = mid + 1;
            }

        }
        return ans;

    }

    public static int upperBound(int[] a, int key){

        int low = 0;
        int high = a.length - 1;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(a[mid] <= key){
                ans = mid;
                low = mid + 1;
            } else{
                high = mid - 1;
            }

        }
        return ans;

    }


    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,8};
        int key = 7;
        int lower = lowerBound(a,key);
        int upper = upperBound(a,key);

        System.out.println(lower);
        System.out.println(upper);
    }


}
