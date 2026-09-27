package ObjectClassMethods.class_problems;

abstract class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public abstract boolean checkLeave(int days);
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name) {
        super(name);
    }

    public boolean checkLeave(int days) {
        return days <= 20;
    }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name) {
        super(name);
    }

    public boolean checkLeave(int days) {
        return days <= 10;
    }
}

class LeaveRequest {
    private Employee employee;
    private String dates;
    private String status;

    public LeaveRequest(Employee employee, String dates, int days) {
        this.employee = employee;
        this.dates = dates;
        status = "Pending";
    }

    public void approve() {
        if (status.equals("Pending")) {
            status = "Approved";
            System.out.println(employee.name + "'s leave request (" + dates + ") approved.");
            System.out.println("Status: " + status);
        }
    }

    public void reject() {
        if (status.equals("Pending")) {
            status = "Rejected";
            System.out.println(employee.name + "'s leave request (" + dates + ") rejected.");
            System.out.println("Status: " + status);
        }
    }

    public void changeToPending() {
        if (!status.equals("Pending")) {
            System.out.println("Cannot change leave request status from "
                    + status + " to Pending.");
        }
    }
}

public class LeaveSystem {
    public static void main(String[] args) {

        Employee john = new FullTimeEmployee("John");
        Employee jane = new PartTimeEmployee("Jane");

        LeaveRequest r1 = new LeaveRequest(john, "Jan 1-5", 5);
        System.out.println("Leave request submitted for John (Jan 1-5).");
        System.out.println("Status: Pending");

        r1.approve();
        r1.changeToPending();

        System.out.println();

        LeaveRequest r2 = new LeaveRequest(jane, "Feb 10-11", 2);
        System.out.println("Leave request submitted for Jane (Feb 10-11).");
        System.out.println("Status: Pending");

        r2.reject();
    }
}