package Oop.assignment_problems;

class Employees {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    Employees(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        Employees e1 = new Employees("Divya", 65000);
        Employees e2 = new Employees("Arjun", 50000);
        Employees e3 = new Employees("Ravi", 55000);

        Employees.printCompanyInfo();
    }
}