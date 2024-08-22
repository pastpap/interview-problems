package com.papinologies.testdome.problems;

public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        return lower_bound(sortedArray, 0, sortedArray.length, lessThan);
    }

    static int lower_bound(int arr[], int start,
            int end, int x) {
        while (start < end) {
            int mid = (start + end) >> 1;
            if (arr[mid] >= x)
                end = mid;
            else
                start = mid + 1;
        }

        return start;
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4));
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 8));
        System.out.println(SortedSearch.countNumbers(new int[] { 8 }, 8));
    }
}