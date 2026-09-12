package Polymorphism.classproblems;

class LibraryMemberP1 {
    String memberId;
    int borrowLimit;
    int booksBorrowed;

    LibraryMemberP1(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().length() < 4)
            throw new IllegalArgumentException();

        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
    }

    void borrowBook() {
        if (booksBorrowed < borrowLimit)
            booksBorrowed++;
    }

    int getBooksBorrowed() {
        return booksBorrowed;
    }

    static String enrollBatch(String[] memberIds, int borrowLimit) {
        int enrolled = 0;
        int rejected = 0;

        for (String id : memberIds) {
            try {
                new LibraryMemberP1(id, borrowLimit);
                enrolled++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Enrolled: " + enrolled + " | Rejected: " + rejected;
    }

    void displayInfo() {
        System.out.println("General Member | Books Borrowed: " + booksBorrowed);
    }
}

class StudentMemberP1 extends LibraryMemberP1 {
    String course;

    StudentMemberP1(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    void displayInfo() {
        System.out.println("Student Member | Course: " + course +
                " | Books Borrowed: " + booksBorrowed);
    }
}

public class LibraryProblem1 {
    public static void main(String[] args) {
        StudentMemberP1 s = new StudentMemberP1("STU10", 3, "CSE");

        s.borrowBook();
        s.borrowBook();

        System.out.println(s.getBooksBorrowed());

        String[] ids = {"STU1", "LB1", "STU2", " ", "STU3"};

        System.out.println(LibraryMemberP1.enrollBatch(ids, 3));
    }
}