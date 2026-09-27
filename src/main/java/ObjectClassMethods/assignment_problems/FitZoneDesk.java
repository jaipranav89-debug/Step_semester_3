package ObjectClassMethods.assignment_problems;

interface PlanType {
    double calculateFee();
    int getMonths();
}

class MonthlyPlan implements PlanType {
    public double calculateFee() {
        return 1000;
    }

    public int getMonths() {
        return 1;
    }
}

class QuarterlyPlan implements PlanType {
    public double calculateFee() {
        return 1000 * 3 * 0.90;
    }

    public int getMonths() {
        return 3;
    }
}

class AnnualPlan implements PlanType {
    public double calculateFee() {
        return 1000 * 12 * 0.75;
    }

    public int getMonths() {
        return 12;
    }
}

class GymMember {
    String name;

    public GymMember(String name) {
        this.name = name;
    }
}

class GymMembership {
    GymMember member;
    PlanType plan;
    String status;

    public GymMembership(GymMember member, PlanType plan) {
        this.member = member;
        this.plan = plan;
        status = "Active";

        System.out.println(plan.getMonths()
                + "-month membership created for "
                + member.name + ".");

        System.out.printf("Fee: ₹%.2f%n", plan.calculateFee());
        System.out.println("Status: " + status);
    }

    public void checkIn() {
        if (status.equals("Active")) {
            System.out.println(member.name
                    + " checked in successfully.");
        } else {
            System.out.println("Check-in denied: "
                    + member.name + "'s membership is "
                    + status + ".");
        }
    }

    public void freeze() {
        if (status.equals("Active")) {
            status = "Frozen";
            System.out.println(member.name
                    + "'s membership frozen.");
            System.out.println("Status: " + status);
        } else {
            System.out.println("Cannot freeze an "
                    + status + " membership.");
        }
    }

    public void unfreeze() {
        if (status.equals("Frozen")) {
            status = "Active";
            System.out.println(member.name
                    + "'s membership unfrozen.");
        } else {
            System.out.println("Cannot unfreeze an "
                    + status + " membership.");
        }
    }

    public void expire() {
        status = "Expired";
        System.out.println(member.name
                + "'s membership expired.");
        System.out.println("Status: " + status);
    }
}

public class FitZoneDesk {
    public static void main(String[] args) {

        GymMember asha = new GymMember("Asha");
        GymMember ravi = new GymMember("Ravi");

        GymMembership m1 =
                new GymMembership(asha, new QuarterlyPlan());

        GymMembership m2 =
                new GymMembership(ravi, new MonthlyPlan());

        m1.checkIn();
        m1.freeze();
        m1.checkIn();

        m2.expire();
        m2.freeze();
    }
}