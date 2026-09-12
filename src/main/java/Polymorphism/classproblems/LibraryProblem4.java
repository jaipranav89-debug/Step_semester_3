package Polymorphism.classproblems;

class LibraryMemberP4 {
    int booksBorrowed = 0;

    LibraryMemberP4(String memberId, int borrowLimit) {
    }

    void displayInfo() {
        System.out.print("General | Books: " + booksBorrowed + " | ");
    }
}

class StudentMemberP4 extends LibraryMemberP4 {
    String course;

    StudentMemberP4(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    void displayInfo() {
        System.out.print("Student | Course: " + course +
                " | Books: " + booksBorrowed + " | ");
    }
}

public class LibraryProblem4 {

    static String batchPrint(LibraryMemberP4[] members) {
        StringBuilder result = new StringBuilder();

        for (LibraryMemberP4 member : members) {
            member.displayInfo();

            if (member instanceof StudentMemberP4) {
                StudentMemberP4 student = (StudentMemberP4) member;

                result.append("Student | Course: ")
                        .append(student.course)
                        .append(" | Books: ")
                        .append(student.booksBorrowed)
                        .append(" [Course via downcast: ")
                        .append(student.course)
                        .append("] | ");
            } else {
                result.append("General | Books: ")
                        .append(member.booksBorrowed)
                        .append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        LibraryMemberP4[] members = {
                new LibraryMemberP4("LB5", 3),
                new StudentMemberP4("STU6", 3, "ECE")
        };

        System.out.println(batchPrint(members));
    }
}