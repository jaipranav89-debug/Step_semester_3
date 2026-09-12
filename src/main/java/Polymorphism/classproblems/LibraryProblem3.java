package Polymorphism.classproblems;

class LibraryMemberP3 {
    String memberId;
    int borrowLimit;

    private int[] fineHistory = new int[10];
    private int fineCount = 0;

    LibraryMemberP3(String memberId, int borrowLimit) {
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
    }

    protected void chargeFine(int amount) {
        fineHistory[fineCount] = amount;
        fineCount++;
    }

    int[] getFineHistory() {
        int[] result = new int[fineCount];

        for (int i = 0; i < fineCount; i++)
            result[i] = fineHistory[i];

        return result;
    }

    int getTotalFine() {
        int total = 0;

        for (int i = 0; i < fineCount; i++)
            total += fineHistory[i];

        return total;
    }
}

class StudentMemberP3 extends LibraryMemberP3 {

    StudentMemberP3(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
    }

    @Override
    protected void chargeFine(int amount) {
        super.chargeFine(amount / 2);
    }
}

public class LibraryProblem3 {
    public static void main(String[] args) {
        StudentMemberP3 s =
                new StudentMemberP3("STU5", 3, "CSE");

        s.chargeFine(100);

        System.out.println(s.getTotalFine());

        int[] history = s.getFineHistory();

        history[0] = 999;

        int[] result = s.getFineHistory();

        System.out.println(result[0]);
    }
}