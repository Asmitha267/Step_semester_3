package main.java.week9.assignment_problems;
// File name: CityCabFareMeter.java

import java.util.Scanner;

abstract class Cab {
    protected static final double MINIMUM_FARE = 100.0;
    protected double distance;

    public Cab(double distance) {
        this.distance = distance;
    }

    abstract double getRate();

    public double getFare(boolean night) {
        double fare = Math.max(MINIMUM_FARE, distance * getRate());

        if (night) {
            fare = fare + fare * 0.20;
        }

        return fare;
    }
}

interface NightService {
}

class MiniCab extends Cab {
    public MiniCab(double distance) {
        super(distance);
    }

    double getRate() {
        return 10.0;
    }
}

class SedanCab extends Cab implements NightService {
    public SedanCab(double distance) {
        super(distance);
    }

    double getRate() {
        return 14.0;
    }
}

class SUVCab extends Cab implements NightService {
    public SUVCab(double distance) {
        super(distance);
    }

    double getRate() {
        return 18.0;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double km = sc.nextDouble();
            String time = sc.next().toUpperCase();

            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new MiniCab(km);
                    break;
                case "SEDAN":
                    cab = new SedanCab(km);
                    break;
                case "SUV":
                    cab = new SUVCab(km);
                    break;
                default:
                    continue;
            }

            boolean night = time.equals("NIGHT");

            if (night && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = cab.getFare(night);

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
