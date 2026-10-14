package main.java.week9.assignment_problems;
// File name: ParcelShippingDesk.java

import java.util.Scanner;

interface Insurable {
    double getInsurance(double declaredValue);
}

abstract class Parcel {
    protected double weightKg;
    protected double declaredValue;

    public Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    abstract double getCharge();

    double getInsurance() {
        return 0.0;
    }

    double getTotal() {
        return getCharge() + getInsurance();
    }
}

class StandardParcel extends Parcel {
    public StandardParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    double getCharge() {
        return 40 + 10 * weightKg;
    }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    double getCharge() {
        return 80 + 15 * weightKg;
    }

    public double getInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }

    @Override
    double getInsurance() {
        return getInsurance(declaredValue);
    }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }

    double getCharge() {
        return 40 + 10 * weightKg + 50;
    }

    public double getInsurance(double declaredValue) {
        return declaredValue * 0.02;
    }

    @Override
    double getInsurance() {
        return getInsurance(declaredValue);
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            Parcel parcel;

            switch (type) {
                case "STANDARD":
                    parcel = new StandardParcel(weight, value);
                    break;
                case "EXPRESS":
                    parcel = new ExpressParcel(weight, value);
                    break;
                case "FRAGILE":
                    parcel = new FragileParcel(weight, value);
                    break;
                default:
                    continue;
            }

            double charge = parcel.getCharge();
            double insurance = parcel.getInsurance();
            double total = parcel.getTotal();

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}