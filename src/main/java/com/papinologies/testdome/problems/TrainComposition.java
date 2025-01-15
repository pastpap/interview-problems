package com.papinologies.testdome.problems;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Data Structure:
 * 
 * A Deque (double-ended queue) is used to store the wagons because it supports
 * efficient operations at both ends.
 * Attach Methods:
 * 
 * attachWagonFromLeft(int wagonId): Adds the wagon to the front of the deque
 * using addFirst().
 * attachWagonFromRight(int wagonId): Adds the wagon to the end of the deque
 * using addLast().
 * Detach Methods:
 * 
 * detachWagonFromLeft(): Removes and returns the wagon from the front of the
 * deque using removeFirst().
 * detachWagonFromRight(): Removes and returns the wagon from the end of the
 * deque using removeLast().
 * Error Handling:
 * 
 * If the deque is empty, detaching operations throw an IllegalStateException to
 * indicate that no wagons are available.
 */

public class TrainComposition {
    private Deque<Integer> wagons;

    public TrainComposition() {
        wagons = new LinkedList<>();
    }

    public void attachWagonFromLeft(int wagonId) {
        wagons.addFirst(wagonId);
    }

    public void attachWagonFromRight(int wagonId) {
        wagons.addLast(wagonId);
    }

    public int detachWagonFromLeft() {
        if (wagons.isEmpty()) {
            throw new IllegalStateException("No wagons to detach from the left.");
        }
        return wagons.removeFirst();
    }

    public int detachWagonFromRight() {
        if (wagons.isEmpty()) {
            throw new IllegalStateException("No wagons to detach from the right.");
        }
        return wagons.removeLast();
    }

    public static void main(String[] args) {
        TrainComposition train = new TrainComposition();
        train.attachWagonFromLeft(7);
        train.attachWagonFromLeft(13);
        System.out.println(train.detachWagonFromRight()); // 7
        System.out.println(train.detachWagonFromLeft()); // 13
    }
}