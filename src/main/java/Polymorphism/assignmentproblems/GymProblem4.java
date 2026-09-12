package Polymorphism.assignmentproblems;
class GymMemberA4 {
    int sessionsAttended;

    GymMemberA4(String memberId, int monthlyFee) {
    }

    void displayInfo() {
        System.out.print("Standard | Sessions: " + sessionsAttended + " | ");
    }
}

class PremiumMemberA4 extends GymMemberA4 {
    String trainerName;

    PremiumMemberA4(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    void displayInfo() {
        System.out.print("Premium | Trainer: " +
                trainerName + " | Sessions: " +
                sessionsAttended + " | ");
    }
}

public class GymProblem4 {

    static String batchPrint(GymMemberA4[] members) {
        StringBuilder result = new StringBuilder();

        for (GymMemberA4 member : members) {
            member.displayInfo();

            if (member instanceof PremiumMemberA4) {
                PremiumMemberA4 premium =
                        (PremiumMemberA4) member;

                result.append("Premium | Trainer: ")
                        .append(premium.trainerName)
                        .append(" | Sessions: ")
                        .append(premium.sessionsAttended)
                        .append(" [Trainer via downcast: ")
                        .append(premium.trainerName)
                        .append("] | ");
            } else {
                result.append("Standard | Sessions: ")
                        .append(member.sessionsAttended)
                        .append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        GymMemberA4[] members = {
                new GymMemberA4("MEM6", 1000),
                new PremiumMemberA4("MEM7", 2000, "Coach Riya")
        };

        System.out.println(batchPrint(members));
    }
}