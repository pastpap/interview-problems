package com.papinologies.testdome.problems;

public class GamePlatform {
    public static double calculateFinalSpeed(double initialSpeed, int[] inclinations) {
        // given oringial speed
        // for each value in the array
        // change speed according to value in array
        // if speed is <= 0 break and return 0
        //
        //
        double finalSpeed = initialSpeed;
        for (int i : inclinations) {
            finalSpeed += -i;
            if (finalSpeed <= 0d) {
                return 0d;
            }
        }
        return finalSpeed;

    }

    public static void main(String[] args) {
        System.out.println(calculateFinalSpeed(60.0, new int[] { 0, 30, 0, -45, 0 }));
    }
}