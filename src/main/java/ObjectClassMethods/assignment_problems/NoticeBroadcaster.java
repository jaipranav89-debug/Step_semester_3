package ObjectClassMethods.assignment_problems;

interface MessageChannel {
    void send(String student, String notice);
}

class EmailChannel implements MessageChannel {
    public void send(String student, String notice) {
        System.out.println("[Email → " + student + "] " + notice);
    }
}

class SmsChannel implements MessageChannel {
    public void send(String student, String notice) {
        System.out.println("[SMS → " + student + "] " + notice);
    }
}

class AppChannel implements MessageChannel {
    public void send(String student, String notice) {
        System.out.println("[App → " + student + "] " + notice);
    }
}

class CampusStudent {
    String name;
    String department;
    MessageChannel[] channels;
    int count;

    public CampusStudent(String name, String department) {
        this.name = name;
        this.department = department;
        channels = new MessageChannel[5];
        count = 0;
    }

    public void addChannel(MessageChannel channel) {
        channels[count] = channel;
        count++;
    }

    public void receive(String notice) {
        for (int i = 0; i < count; i++) {
            channels[i].send(name, notice);
        }
    }
}

class CampusNotice {
    String title;
    String[] departments;
    int count;

    public CampusNotice(String title) {
        this.title = title;
        departments = new String[5];
        count = 0;
    }

    public void addDepartment(String department) {
        departments[count] = department;
        count++;
    }

    public boolean isValid() {
        return title != null && !title.isEmpty() && count > 0;
    }

    public boolean targets(String department) {
        for (int i = 0; i < count; i++) {
            if (departments[i].equals(department))
                return true;
        }

        return false;
    }
}

class NoticeBoard {
    CampusStudent[] students;
    int count;

    public NoticeBoard() {
        students = new CampusStudent[20];
        count = 0;
    }

    public void addStudent(CampusStudent student) {
        students[count] = student;
        count++;
    }

    public void post(CampusNotice notice) {

        if (!notice.isValid()) {
            System.out.println(
                    "Cannot post notice: At least one target department is required.");
            return;
        }

        System.out.print("Notice '" + notice.title
                + "' posted to ");

        for (int i = 0; i < notice.count; i++) {
            System.out.print(notice.departments[i]);

            if (i < notice.count - 1)
                System.out.print(", ");
        }

        System.out.println(".");

        for (int i = 0; i < count; i++) {
            if (notice.targets(students[i].department)) {
                students[i].receive(notice.title);
            }
        }
    }
}

public class NoticeBroadcaster {
    public static void main(String[] args) {

        CampusStudent asha =
                new CampusStudent("Asha", "CSE");

        asha.addChannel(new EmailChannel());
        asha.addChannel(new AppChannel());

        CampusStudent ravi =
                new CampusStudent("Ravi", "ECE");

        ravi.addChannel(new SmsChannel());

        NoticeBoard board = new NoticeBoard();

        board.addStudent(asha);
        board.addStudent(ravi);

        CampusNotice n1 =
                new CampusNotice("Lab Closed Tomorrow");

        n1.addDepartment("CSE");

        board.post(n1);

        System.out.println();

        CampusNotice n2 =
                new CampusNotice("Fee Deadline Extended");

        n2.addDepartment("CSE");
        n2.addDepartment("ECE");

        board.post(n2);

        System.out.println();

        CampusNotice n3 =
                new CampusNotice("Sports Day");

        board.post(n3);
    }
}
