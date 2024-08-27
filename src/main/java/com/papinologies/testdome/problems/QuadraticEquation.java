package com.papinologies.testdome.problems;

public class QuadraticEquation {
    public static Roots findRoots(double a, double b, double c) {

        // Calculate the discriminant
        double discriminant = b * b - 4 * a * c;

        // Check the nature of the roots based on the discriminant
        if (discriminant > 0) {
            // Two distinct real roots
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return new Roots(root1, root2);
        } else if (discriminant == 0) {
            // One real root (repeated)
            double root = -b / (2 * a);
            return new Roots(root, root);
        } else {
            // Discriminant is negative; in this case we assume there are no real roots.
            // Since problem statement does not mention complex numbers, handle it as needed
            // by the application's context. For this case, let's return NaN to indicate no
            // real roots.
            return new Roots(Double.NaN, Double.NaN);
        }
    }

    public static void main(String[] args) {
        Roots roots = QuadraticEquation.findRoots(2, 10, 8);
        System.out.println("Roots: " + roots.x1 + ", " + roots.x2);
    }
}

class Roots {
    public final double x1, x2;

    public Roots(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}