package Polymorphism.assignmentproblems;

class GymMemberA5 {
    static int count = 2000;

    final String membershipNumber;
    int monthlyFee;
    int feesPaid;

    GymMemberA5(int monthlyFee) {
        count++;
        membershipNumber = "GYM-" + count;
        this.monthlyFee = monthlyFee;
    }

    void payFee(int amount) {
        feesPaid += amount;
    }

    void payFee(int amount, String mode) {
        payFee(amount);
    }

    int getFeesPaid() {
        return feesPaid;
    }

    static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4)
            return false;

        return code.charAt(0) == 'G'
                && Character.isDigit(code.charAt(1))
                && Character.isDigit(code.charAt(2))
                && Character.isUpperCase(code.charAt(3));
    }

    static int getMembersEnrolled() {
        return count - 2000;
    }
}

class GroupClassMemberA5 extends GymMemberA5 {
    String className;

    GroupClassMemberA5(int monthlyFee, String className) {
        super(monthlyFee);
        this.className = className;
    }
}

public class GymProblem5 {

    static String processWeeklyCheckIn(GymMemberA5[] members) {
        int processed = 0;
        int skipped = 0;
        int group = 0;
        int individual = 0;

        for (GymMemberA5 member : members) {
            if (member == null) {
                skipped++;
            } else {
                processed++;

                if (member instanceof GroupClassMemberA5)
                    group++;
                else
                    individual++;
            }
        }

        return processed + " processed | " +
                skipped + " null skipped | " +
                group + " group | " +
                individual + " individual";
    }

    public static void main(String[] args) {
        GymMemberA5 m1 = new GymMemberA5(1000);

        System.out.println(m1.membershipNumber);
        System.out.println(GymMemberA5.getMembersEnrolled());

        System.out.println(GymMemberA5.isValidReferralCode("G45B"));
        System.out.println(GymMemberA5.isValidReferralCode("G4B"));
        System.out.println(GymMemberA5.isValidReferralCode("X45B"));

        m1.payFee(500);
        m1.payFee(500, "UPI");

        System.out.println(m1.getFeesPaid());

        GymMemberA5[] members = {
                new GroupClassMemberA5(1500, "Zumba"),
                null,
                new GymMemberA5(1000)
        };

        System.out.println(processWeeklyCheckIn(members));
    }
}