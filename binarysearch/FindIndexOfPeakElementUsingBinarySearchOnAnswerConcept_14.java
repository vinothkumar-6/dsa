package com.binarysearch;

public class FindIndexOfPeakElementUsingBinarySearchOnAnswerConcept_14 {
//    A peak element is an element that is greater than its neighbors.
//    Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
//    The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
//    You may imagine that nums[-1] = nums[n] = -∞.
    /*
    Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
     */

    // Finding the peak element on an array using Binary Search on Answer method in an unsorted array.
    // Peak element is an element which should be greater than its neighbours. In a monatonic array,
   /*

   I will try to explain it more simply.

What we are essentially doing is going in the direction of the rising slope
   (by choosing the element which is greater than current).
How does that guarantee the result? Think about it, there are 2 possibilities.
   a) Rising slope has to keep rising till end of the array
   b) rising slope will encounter a lesser element and go down.

In both scenarios, we will have an answer.

a) the answer is the end element because we take the boundary as -INFINITY
b) the answer is the largest element before the slope falls. Hope this makes things clearer.

1. BinarySearch on Answer:
        "Binary search on answer" is a powerful technique commonly used in various computational problems, including optimization,
         search, and decision-making tasks. It offers a more efficient approach compared to exhaustive search methods,
         especially when dealing with large search spaces.

2. Criteria
      Checking if mid is peak element or not.
       1. if mid > mid+1 and mid < mid-1, then return mid. else go to left or right.
       2. To go to left or right we have to check which side is greater than mid element.
       if left is greater, then consider mid -1 as mid and compare. Else mid +1 as mid and compare.
      //edge condition
      3. At last we have to check if the peak is in low or high.
       1. If Low > low +1.
       2. if high > high -1.
   */

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1};
        int low = 0;
        int high = a.length - 1;
        int result = findPeakElement(a, low, high);
          if(result!=-1){
              System.out.println("Peak Element is: "+result);
          } else{
              System.out.println("element not found"+result);
          }
    }

    public static int findPeakElement(int[] a, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid > 0 && mid < a.length - 1) {
                if ((a[mid] > a[mid- 1] ) && (a[mid] > a[mid + 1] )) {
                    return mid;
                } else if (a[mid + 1] > a[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else if (mid == 0) {
                if (a[mid] > a[mid + 1]) {
                    return mid;
                } else {
                    return mid + 1;
                }
            } else if (mid == a.length - 1) {
                if (a[a.length - 1] > a[a.length - 2]) {
                    return mid;
                } else {
                    return mid - 1;
                }
            }


        }
        return -1;
    }
}
