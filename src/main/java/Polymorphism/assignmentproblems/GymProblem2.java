package Polymorphism.assignmentproblems;

class GymMemberA2 {
    int sessionsAttended;

    GymMemberA2(String memberId, int monthlyFee) {
    }

    void attendSession() {
        sessionsAttended++;
    }

    int getSessionsAttended() {
        return sessionsAttended;
    }

    void displayInfo() {
        System.out.println("Standard Member | Sessions: " + sessionsAttended);
    }
}

class PremiumMemberA2 extends GymMemberA2 {
    String trainerName;

    PremiumMemberA2(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    void displayInfo() {
        System.out.println("Premium Member | Trainer: " +
                trainerName + " | Sessions: " + sessionsAttended);
    }
}

class EliteMemberA2 extends PremiumMemberA2 {
    String lockerNumber;

    EliteMemberA2(String memberId, int monthlyFee,
                  String trainerName, String lockerNumber) {
        super(memberId, monthlyFee, trainerName);
        this.lockerNumber = lockerNumber;
    }

    void displayInfo() {
        System.out.println("Elite Member | Trainer: " +
                trainerName + " | Locker: " +
                lockerNumber + " | Sessions: " +
                sessionsAttended);
    }
}

class GroupClassMemberA2 extends GymMemberA2 {
    String className;

    GroupClassMemberA2(String memberId, int monthlyFee, String className) {
        super(memberId, monthlyFee);
        this.className = className;
    }

    void displayInfo() {
        System.out.println("Group Class Member | Class: " +
                className + " | Sessions: " +
                sessionsAttended);
    }
}

public class GymProblem2 {

    static String classifyGeneration(GymMemberA2 member) {
        if (member instanceof EliteMemberA2)
            return "Multilevel descendant (3 generations deep)";

        if (member instanceof GroupClassMemberA2)
            return "Hierarchical sibling (independent branch)";

        return "Other member";
    }

    static int getTotalSessionsAttended(GymMemberA2[] members) {
        int total = 0;

        for (GymMemberA2 member : members)
            total += member.getSessionsAttended();

        return total;
    }

    public static void main(String[] args) {
        GymMemberA2 standard =
                new GymMemberA2("MEM1", 1000);

        PremiumMemberA2 premium =
                new PremiumMemberA2("MEM2", 2000, "Coach Riya");

        EliteMemberA2 elite =
                new EliteMemberA2("MEM3", 3000, "Coach Arjun", "L12");

        GroupClassMemberA2 group =
                new GroupClassMemberA2("MEM4", 1500, "Zumba");

        standard.displayInfo();
        premium.displayInfo();
        elite.displayInfo();
        group.displayInfo();

        System.out.println(classifyGeneration(elite));
        System.out.println(classifyGeneration(group));

        premium.attendSession();
        premium.attendSession();
        premium.attendSession();

        elite.attendSession();
        elite.attendSession();

        group.attendSession();
        group.attendSession();
        group.attendSession();
        group.attendSession();

        GymMemberA2[] members = {premium, elite, group};

        System.out.println(getTotalSessionsAttended(members));
    }
}