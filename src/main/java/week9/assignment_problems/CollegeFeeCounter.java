package main.java.week9.assignment_problems;
// File name: CollegeFeeCounter.java

import java.util.Scanner;

abstract class Student {
    protected String name;
    protected static final double TRANSPORT_FEE = 12000.0;

    public Student(String name) {
        this.name = name;
    }

    abstract double getTuitionFee();

    abstract boolean usesBus();

    public double getTotalFee() {
        double total = getTuitionFee();

        if (usesBus()) {
            total += TRANSPORT_FEE;
        }

        return total;
    }
}

class DayScholar extends Student {
    public DayScholar(String name) {
        super(name);
    }

    double getTuitionFee() {
        return 40000.0;
    }

    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    public Hosteller(String name) {
        super(name);
    }

    double getTuitionFee() {
        return 40000.0 + 60000.0;
    }

    boolean usesBus() {
        return false;
    }
}

class ScholarshipStudent extends Student {
    public ScholarshipStudent(String name) {
        super(name);
    }

    double getTuitionFee() {
        return 20000.0;
    }

    boolean usesBus() {
        return true;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();

            Student student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    student = new ScholarshipStudent(name);
                    break;
                default:
                    continue;
            }

            double fee = student.getTotalFee();

            System.out.printf("%s: %.2f%n", name, fee);
            totalCollected += fee;
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);

        sc.close();
    }
}
