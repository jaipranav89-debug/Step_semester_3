
package week11.assignment_problems;

import java.util.Scanner;

class ContestEntry {
    String name;
    int marks;

    ContestEntry(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class ContestLeaderboard {
    static ContestEntry[] leaderboard(ContestEntry[] entries) {
        int[] count = new int[101];

        for (ContestEntry entry : entries) {
            count[100 - entry.marks]++;
        }

        for (int i = 1; i < 101; i++) {
            count[i] += count[i - 1];
        }

        ContestEntry[] result = new ContestEntry[entries.length];

        for (int i = entries.length - 1; i >= 0; i--) {
            int key = 100 - entries[i].marks;
            result[--count[key]] = entries[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        ContestEntry[] entries = new ContestEntry[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.next();

            System.out.print("Enter marks: ");
            int marks = sc.nextInt();

            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks");
                sc.close();
                return;
            }

            entries[i] = new ContestEntry(name, marks);
        }

        ContestEntry[] result = leaderboard(entries);

        System.out.println("Contest Leaderboard:");

        for (ContestEntry entry : result) {
            System.out.println(entry.name + " " + entry.marks);
        }

        sc.close();
    }
}

