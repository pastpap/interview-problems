package com.papinologies.testdome.problems;

public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        int start = 0;
        int end = sortedArray.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (lessThan <= sortedArray[mid])
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