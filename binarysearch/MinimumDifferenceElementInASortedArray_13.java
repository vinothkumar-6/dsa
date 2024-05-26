package com.binarysearch;

public class MinimumDifferenceElementInASortedArray_13 {
    // Given a sorted array, find the element in the array which has minimum difference with the given number.
    /*
    1.  If the key itself found return the key.
    2.  If the key is not found, then have to get the least
    minimum absolute(Its called as the + value. even if the difference is -1, we have to consider it as 1, not as -1.)
    difference value.
    3. If key is found in mid. return the mid
    4. If the key is not found, keep iterating the array until you find the low and high.
    5. Then compare the absolute difference between a[low] - key and a[high] - key. Whichever is the lowest should be the answer.
    */

    public static void main(String[] args) {

        int[] a = {1,2,3,4,5,6,7,10,12,13};
        int key = 9;
        int low = 0;
        int high = a.length-1;
        int minDiffElement = binarySearch(a,low,high,key);
        System.out.println("minDiffElement: "+minDiffElement);


    }

    public static int binarySearch(int[] a, int low, int high, int key){

        while(low<=high){
            int mid=low+(high-low)/2;
            if(a[mid] == key){
                return a[mid];
            } else if(a[mid]> key){
                 high = mid-1;
            } else {
                low = mid+1;
            }
        }
        System.out.println("Low: "+low);
        System.out.println("High: "+high);
        System.out.println("Key: "+key);
        System.out.println("a[low]-key : "+(a[low] - key));
        System.out.println("a[high]-key : "+(a[high] - key));

        if(Math.abs(a[low] - key) < Math.abs(a[high] - key)){
            System.out.println("Absolute a[low]-key: "+Math.abs(a[low] - key));
            return Math.abs(a[low] - key);
        } else{
            System.out.println("Absolute a[high]-key: "+Math.abs(a[high] - key));
            return Math.abs(a[high] - key);
        }

    }

}
