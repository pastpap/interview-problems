package com.papinologies.testdome.problems;

public class MegaStore {

    public enum DiscountType {
        Standard,
        Seasonal,
        Weight;
    }

    public static double getDiscountedPrice(double cartWeight,
            double totalPrice,
            DiscountType discountType) {
        // Standard -> 6%
        // Seasonal -> 12%
        // Weight -> weight <=10 then 6%
        // >10 then 18%

        double discount;

        switch (discountType) {
            case Standard:
                discount = 6d;
                break;
            case Seasonal:
                discount = 12d;
                break;
            case Weight:
                if (cartWeight <= 10) {
                    discount = 6d;
                } else {
                    discount = 18d;
                }
                break;
            default:
                discount = 100d;
                break;
        }

        return totalPrice - (totalPrice * discount / 100);
    }

    public static void main(String[] args) {
        System.out.println(getDiscountedPrice(12, 100, DiscountType.Weight));
    }
}