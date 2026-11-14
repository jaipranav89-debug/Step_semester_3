
package week12.practice_problems;

import java.util.Scanner;

class ParticipantEntry {
    String name;
    int score;

    ParticipantEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class LeaderBoardRanking {
    static void sortParticipants(ParticipantEntry[] entries) {
        for (int i = 1; i < entries.length; i++) {
            ParticipantEntry key = entries[i];
            int j = i - 1;

            while (j >= 0 && entries[j].score < key.score) {
                entries[j + 1] = entries[j];
                j--;
            }

            entries[j + 1] = key;
        }
    }

    static void printRanks(ParticipantEntry[] entries) {
        int rank = 1;

        for (int i = 0; i < entries.length; i++) {
            if (i > 0 && entries[i].score != entries[i - 1].score) {
                rank = i + 1;
            }

            System.out.println(rank + " " +
                    entries[i].name + " " + entries[i].score);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of participants: ");
        int n = sc.nextInt();

        ParticipantEntry[] entries = new ParticipantEntry[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name: ");
            String name = sc.next();

            System.out.print("Enter score: ");
            int score = sc.nextInt();

            entries[i] = new ParticipantEntry(name, score);
        }

        sortParticipants(entries);

        System.out.println("Leaderboard:");
        printRanks(entries);

        sc.close();
    }
}

