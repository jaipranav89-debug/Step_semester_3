package Polymorphism.classproblems;

class LibraryMemberP5 {
    static int count = 100;

    final String memberNumber;
    int borrowLimit;
    int booksBorrowed;

    LibraryMemberP5(int borrowLimit) {
        count++;
        memberNumber = "LIB-" + count;
        this.borrowLimit = borrowLimit;
    }

    void borrowBook() {
        if (booksBorrowed < borrowLimit)
            booksBorrowed++;
    }

    void borrowBook(String genre) {
        borrowBook();
    }

    static boolean isValidRenewalCode(String code) {
        if (code == null || code.length() != 4)
            return false;

        return code.charAt(0) == 'R'
                && Character.isDigit(code.charAt(1))
                && Character.isDigit(code.charAt(2))
                && Character.isUpperCase(code.charAt(3));
    }

    int getBooksBorrowed() {
        return booksBorrowed;
    }

    static int getMembersEnrolled() {
        return count - 100;
    }
}

class FacultyMemberP5 extends LibraryMemberP5 {
    String department;

    FacultyMemberP5(int borrowLimit, String department) {
        super(borrowLimit);
        this.department = department;
    }
}

public class LibraryProblem5 {

    static String processNightlyAudit(LibraryMemberP5[] members) {
        int processed = 0;
        int skipped = 0;
        int faculty = 0;
        int regular = 0;

        for (LibraryMemberP5 member : members) {
            if (member == null) {
                skipped++;
            } else {
                processed++;

                if (member instanceof FacultyMemberP5)
                    faculty++;
                else
                    regular++;
            }
        }

        return processed + " processed | " +
                skipped + " null skipped | " +
                faculty + " faculty | " +
                regular + " regular";
    }

    public static void main(String[] args) {
        LibraryMemberP5 m1 = new LibraryMemberP5(3);

        System.out.println(m1.memberNumber);
        System.out.println(LibraryMemberP5.getMembersEnrolled());

        System.out.println(LibraryMemberP5.isValidRenewalCode("R12A"));
        System.out.println(LibraryMemberP5.isValidRenewalCode("R1A"));
        System.out.println(LibraryMemberP5.isValidRenewalCode("X12A"));

        m1.borrowBook();
        m1.borrowBook("Fiction");

        System.out.println(m1.getBooksBorrowed());

        LibraryMemberP5[] members = {
                new FacultyMemberP5(5, "Physics"),
                null,
                new LibraryMemberP5(3)
        };

        System.out.println(processNightlyAudit(members));
    }
}
