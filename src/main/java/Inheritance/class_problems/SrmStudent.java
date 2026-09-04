package Inheritance.class_problems;

class SrmStudent {
    String name;

    static String collegeName;
    static String academicYear;

    static {
        collegeName = "SRM Institute of Science and Technology";
        academicYear = "2026-2027";
        System.out.println("College info loaded");
    }

    SrmStudent(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya", "Anitha"};

        for (int i = 0; i < names.length; i++) {
            SrmStudent student = new SrmStudent(names[i]);
            System.out.println("Student record created: " + student.name);
        }
    }
}