package Polymorphism.assignmentproblems;

class GymMemberA3 {
    private int[] lateFeeHistory = new int[10];
    private int feeCount = 0;

    GymMemberA3(String memberId, int monthlyFee) {
    }

    protected void chargeLateFee(int amount) {
        lateFeeHistory[feeCount] = amount;
        feeCount++;
    }

    int[] getLateFeeHistory() {
        int[] result = new int[feeCount];

        for (int i = 0; i < feeCount; i++)
            result[i] = lateFeeHistory[i];

        return result;
    }

    int getTotalLateFees() {
        int total = 0;

        for (int i = 0; i < feeCount; i++)
            total += lateFeeHistory[i];

        return total;
    }
}

class PremiumMemberA3 extends GymMemberA3 {

    PremiumMemberA3(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
    }

    @Override
    protected void chargeLateFee(int amount) {
        super.chargeLateFee(amount / 2);
    }
}

public class GymProblem3 {
    public static void main(String[] args) {
        PremiumMemberA3 p =
                new PremiumMemberA3("MEM5", 2000, "Coach Riya");

        p.chargeLateFee(200);

        System.out.println(p.getTotalLateFees());

        int[] history = p.getLateFeeHistory();

        history[0] = 999;

        System.out.println(p.getLateFeeHistory()[0]);
    }
}