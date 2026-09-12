package Polymorphism.classproblems;

class LibraryMemberP2 {
    String memberId;
    int borrowLimit;
    int booksBorrowed;

    LibraryMemberP2(String memberId, int borrowLimit) {
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

    void displayInfo() {
        System.out.println("General Member | Books Borrowed: " + booksBorrowed);
    }
}

class StudentMemberP2 extends LibraryMemberP2 {
    String course;

    StudentMemberP2(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    void displayInfo() {
        System.out.println("Student Member | Course: " + course +
                " | Books Borrowed: " + booksBorrowed);
    }
}

class HonorsStudentMemberP2 extends StudentMemberP2 {
    int bonusLimit;

    HonorsStudentMemberP2(String memberId, int borrowLimit, String course, int bonusLimit) {
        super(memberId, borrowLimit, course);
        this.bonusLimit = bonusLimit;
    }

    void displayInfo() {
        System.out.println("Honors Student Member | Course: " + course +
                " | Bonus Limit: " + bonusLimit +
                " | Books Borrowed: " + booksBorrowed);
    }
}

class FacultyMemberP2 extends LibraryMemberP2 {
    String department;

    FacultyMemberP2(String memberId, int borrowLimit, String department) {
        super(memberId, borrowLimit);
        this.department = department;
    }

    void displayInfo() {
        System.out.println("Faculty Member | Department: " + department +
                " | Books Borrowed: " + booksBorrowed);
    }
}

public class LibraryProblem2 {

    static String classifyGeneration(LibraryMemberP2 member) {
        if (member instanceof HonorsStudentMemberP2)
            return "Multilevel descendant (3 generations deep)";

        if (member instanceof FacultyMemberP2)
            return "Hierarchical sibling (independent branch)";

        return "Other member";
    }

    static int getTotalBooksBorrowed(LibraryMemberP2[] members) {
        int total = 0;

        for (LibraryMemberP2 member : members)
            total += member.getBooksBorrowed();

        return total;
    }

    public static void main(String[] args) {
        LibraryMemberP2 general =
                new LibraryMemberP2("STU1", 3);

        StudentMemberP2 student =
                new StudentMemberP2("STU2", 3, "CSE");

        HonorsStudentMemberP2 honors =
                new HonorsStudentMemberP2("STU3", 3, "ECE", 2);

        FacultyMemberP2 faculty =
                new FacultyMemberP2("STU4", 5, "Physics");

        general.displayInfo();
        student.displayInfo();
        honors.displayInfo();
        faculty.displayInfo();

        System.out.println(classifyGeneration(honors));
        System.out.println(classifyGeneration(faculty));

        student.borrowBook();
        student.borrowBook();

        honors.borrowBook();

        faculty.borrowBook();
        faculty.borrowBook();
        faculty.borrowBook();

        LibraryMemberP2[] members = {student, honors, faculty};

        System.out.println(getTotalBooksBorrowed(members));
    }
}