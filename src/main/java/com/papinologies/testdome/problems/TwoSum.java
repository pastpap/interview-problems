package com.papinologies.testdome.problems;

import java.util.HashMap;

public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {

        // using a hash map allows to only pass through the list once and is therefor
        // more efficient than 2 for loops

        HashMap<Integer, Integer> complements = new HashMap<>();
        for (int i = 0; i < list.length; i++) {

            int complement = sum - list[i];
            if (complements.containsKey(complement)) {
                return new int[] { complements.get(complement), i };
            }
            complements.put(list[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);
        if (indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}