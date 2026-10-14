package main.java.week6.assignment_problems;
public class employe {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        Employee emp1 = new employe("Divya", 65000);
        Employee emp2 = new employe("Arjun", 30000);
        Employee emp3 = new employe("Priya", 45000);

        Employee.printCompanyInfo();
    }
}