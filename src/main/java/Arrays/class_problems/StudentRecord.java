package Arrays.class_problems;

import java.util.Scanner;

class StudentRecord {
    static void parseStudentRecord(String csvLine) {
        String[] data = csvLine.split(",");

        if (data.length != 3) {
            System.out.println("Invalid Record");
        } else {
            System.out.println("Name: " + data[0]);
            System.out.println("Roll No: " + data[1]);
            System.out.println("Dept: " + data[2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student record: ");
        String csvLine = sc.nextLine();

        parseStudentRecord(csvLine);
    }
}