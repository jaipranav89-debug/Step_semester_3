package ObjectClassMethods.assignment_problems;

abstract class AssignmentType {
    String title;
    int maxMarks;

    public AssignmentType(String title, int maxMarks) {
        this.title = title;
        this.maxMarks = maxMarks;
    }

    public abstract double applyPenalty(double marks, int lateDays);
}

class CodingWork extends AssignmentType {
    public CodingWork(String title, int maxMarks) {
        super(title, maxMarks);
    }

    public double applyPenalty(double marks, int lateDays) {
        return marks - (marks * 0.10 * lateDays);
    }
}

class WrittenWork extends AssignmentType {
    public WrittenWork(String title, int maxMarks) {
        super(title, maxMarks);
    }

    public double applyPenalty(double marks, int lateDays) {
        return marks - (marks * 0.20 * lateDays);
    }
}

class CollegeStudent {
    String name;

    public CollegeStudent(String name) {
        this.name = name;
    }
}

class WorkSubmission {
    CollegeStudent student;
    AssignmentType assignment;
    String date;
    String status;

    public WorkSubmission(CollegeStudent student,
                          AssignmentType assignment,
                          String date,
                          int lateDays) {
        this.student = student;
        this.assignment = assignment;
        this.date = date;
        status = "Submitted";

        System.out.println(student.name + "'s submission for '"
                + assignment.title + "' received.");

        if (lateDays == 0)
            System.out.println("Status: Submitted.");
        else
            System.out.println("Status: Submitted (" + lateDays
                    + " days late).");
    }

    public void grade(double marks, int lateDays) {
        if (status.equals("Graded")) {
            System.out.println("Already graded.");
            return;
        }

        double finalMarks =
                assignment.applyPenalty(marks, lateDays);

        status = "Graded";

        System.out.printf("%s graded: %.0f/%d.%n",
                student.name, finalMarks, assignment.maxMarks);

        System.out.println("Status: Graded.");
    }

    public void resubmit() {
        if (status.equals("Graded")) {
            System.out.println("Cannot resubmit: '"
                    + assignment.title + "' has already been graded.");
        }
    }
}

public class SubmissionPortal {
    public static void main(String[] args) {

        CollegeStudent asha = new CollegeStudent("Asha");
        CollegeStudent ravi = new CollegeStudent("Ravi");

        AssignmentType coding =
                new CodingWork("Linked List Lab", 50);

        AssignmentType written =
                new WrittenWork("Design Essay", 50);

        WorkSubmission s1 =
                new WorkSubmission(asha, coding, "Mar 10", 0);

        WorkSubmission s2 =
                new WorkSubmission(ravi, written, "Mar 14", 2);

        s1.grade(45, 0);
        s2.grade(40, 2);

        s1.resubmit();
    }
}