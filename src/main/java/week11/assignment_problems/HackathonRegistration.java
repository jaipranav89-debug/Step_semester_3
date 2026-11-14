
package week11.assignment_problems;

import java.util.Scanner;

class TeamEntry {
    String name;
    int size;

    TeamEntry(String name, int size) {
        this.name = name;
        this.size = size;
    }
}

public class HackathonRegistration {
    static void sortTeams(TeamEntry[] teams) {
        for (int i = 1; i < teams.length; i++) {
            TeamEntry key = teams[i];
            int j = i - 1;

            while (j >= 0 && teams[j].size > key.size) {
                teams[j + 1] = teams[j];
                j--;
            }

            teams[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of teams: ");
        int n = sc.nextInt();

        TeamEntry[] teams = new TeamEntry[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter team name: ");
            String name = sc.next();

            System.out.print("Enter team size: ");
            int size = sc.nextInt();

            teams[i] = new TeamEntry(name, size);
        }

        sortTeams(teams);

        System.out.println("Teams in sorted order:");

        for (TeamEntry team : teams) {
            System.out.println(team.name + "(" + team.size + ")");
        }

        sc.close();
    }
}
