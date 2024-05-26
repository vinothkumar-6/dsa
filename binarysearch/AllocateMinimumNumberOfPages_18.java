package com.binarysearch;

import java.util.Arrays;
import java.util.Vector;

public class AllocateMinimumNumberOfPages_18 {

    /*
    ALLOCATE MINIMUM NUMBER OF PAGES:

Given number of pages in n different books and m students.
The books are arranged in ascending order of number of pages.
Every student is assigned to read some consecutive books.
The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum.

Example :

Input : pages[] = {12, 34, 67, 90}
        m = 2
Output : 113
Explanation:
There are 2 number of students. Books can be distributed
in following fashion :
  1) [12] and [34, 67, 90]
      Max number of pages is allocated to student
      2 with 34 + 67 + 90 = 191 pages
  2) [12, 34] and [67, 90]
      Max number of pages is allocated to student
      2 with 67 + 90 = 157 pages
  3) [12, 34, 67] and [90]
      Max number of pages is allocated to student
      1 with 12 + 34 + 67 = 113 pages

Of the 3 cases, Option 3 has the minimum pages = 113.

Steps:

Problem Description:

We have a set of books, each with a certain number of pages.
The books may not necessarily be arranged in ascending order of the number of pages.
We need to assign these books to a given number of students such that each student gets some consecutive books to read.
Our goal is to minimize the maximum number of pages assigned to any student.

Understanding the Constraints:

We are given an array a representing the number of pages in each book.
We are also given the number of students m.

Approach:

We still want to minimize the maximum number of pages assigned to any student, irrespective of the order of books.
We can use a binary search approach to find the minimum possible value for the maximum number of pages assigned to any student.
We will set the lower bound (low) to 0 (minimum possible value) and the upper bound (high) to the sum of pages in all books.
We will then perform binary search in this range to find the minimum value of the maximum number of pages.

Binary Search Algorithm:

We will calculate the mid-point (mid) between low and high.
We will check if it is possible to assign the books such that no student gets more than mid-pages.
If it is possible, we update the result to mid and reduce the upper bound (high) to search for a smaller value.
If it is not possible, we increase the lower bound (low) to search for a larger value.
We continue this process until low becomes greater than high.

Checking Validity of Assignment:

To check if it is possible to assign the books such that no student gets more than mid pages, we simulate the assignment process.
We iterate through the books, keeping track of the sum of pages read by the current student.
Whenever the sum exceeds mid, we increment the student count and reset the sum.
If the number of students exceeds m, it means it is not possible to assign the books with the given mid.
Otherwise, it is possible, and we continue the binary search.

Conclusion:

Once the binary search completes, we will have the minimum possible value that satisfies a certain condition (in this case, whether it is possible to assign the books such that no student gets more than mid pages).
We return this value as the result.


Related Problems For Practice :

Book Allocation Problem (GFG)
Aggressive cow (spoj)
Prata and roti (spoj)
EKO (spoj)
Google kickstart A Q-3 2020
Painter Partition Problem
1482 Minimum Number of Days to Make m Bouquets
1283 Find the Smallest Divisor Given a Threshold
1231 Divide Chocolate
1011 Capacity To Ship Packages In N Days
875 Koko Eating Bananas
Minimize
774 Max Distance to Gas Station
410 Split Array Largest Sum

    * */


        public static void main(String[] args) {
            int[] a = {12, 34, 67, 90};
            int m = 2;

            int low = Arrays.stream(a).max().getAsInt();
            int high = Arrays.stream(a).sum();
            System.out.println("Low: " + low + " High: " + high);
            int result = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (isValid(a, a.length, m, mid)) {
                    result = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            System.out.println("Minimum number of pages allocated to a student: " + result);
        }

        public static boolean isValid(int[] a, int n, int k, int max) {
            int student = 1;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum = sum + a[i];
                if (sum > max) {
                    student++;
                    sum = a[i];
                }
                if (student > k) {
                    return false;
                }
            }
            return true;
        }
    }

