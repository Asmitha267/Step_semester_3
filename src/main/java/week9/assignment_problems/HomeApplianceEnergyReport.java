package main.java.week9.assignment_problems;
// File name: HomeApplianceEnergyReport.java

import java.util.Scanner;

abstract class Appliance {
    protected double hours;
    protected static final double COST_PER_UNIT = 8.0;

    public Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    boolean supportsSaver() {
        return false;
    }

    public double getUnits(boolean saver) {
        double units = getPower() * hours / 1000.0;

        if (saver && supportsSaver()) {
            units *= 0.75;
        }

        return units;
    }

    public double getCost(boolean saver) {
        return getUnits(saver) * COST_PER_UNIT;
    }
}

class Fridge extends Appliance {
    public Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150.0;
    }
}

class AC extends Appliance {
    public AC(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500.0;
    }

    @Override
    boolean supportsSaver() {
        return true;
    }
}

class TV extends Appliance {
    public TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100.0;
    }
}

class Washer extends Appliance {
    public Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500.0;
    }

    @Override
    boolean supportsSaver() {
        return true;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNext("SAVER")) {
                sc.next();
                saver = true;
            }

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;
                case "AC":
                    appliance = new AC(hours);
                    break;
                case "TV":
                    appliance = new TV(hours);
                    break;
                case "WASHER":
                    appliance = new Washer(hours);
                    break;
                default:
                    continue;
            }

            if (saver && !appliance.supportsSaver()) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliance.getUnits(saver);
            double cost = appliance.getCost(saver);

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);

        sc.close();
    }
}
