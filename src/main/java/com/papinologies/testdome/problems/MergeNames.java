package com.papinologies.testdome.problems;

import java.util.HashSet;
import java.util.Set;

public class MergeNames {
    public static String[] uniqueNames(String[] names1, String[] names2) {
        // Use a Set to store unique names
        Set<String> uniqueSet = new HashSet<>();

        // Add all names from the first array
        for (String name : names1) {
            uniqueSet.add(name);
        }

        // Add all names from the second array
        for (String name : names2) {
            uniqueSet.add(name);
        }

        // Convert the set to an array and return
        return uniqueSet.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] names1 = new String[] { "Ava", "Emma", "Olivia" };
        String[] names2 = new String[] { "Olivia", "Sophia", "Emma" };
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma,
                                                                                       // Olivia, Sophia
    }
}
