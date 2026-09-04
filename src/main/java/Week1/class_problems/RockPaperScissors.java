package Week1.class_problems;

import java.util.Scanner;

class RockPaperScissors {
    static String playRound(String player, String computer) {
        if (player.equals(computer))
            return "Draw";

        if (player.equals("Rock") && computer.equals("Scissors"))
            return "Player Wins";
        else if (player.equals("Paper") && computer.equals("Rock"))
            return "Player Wins";
        else if (player.equals("Scissors") && computer.equals("Paper"))
            return "Player Wins";
        else
            return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int wins = 0, losses = 0, draws = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter Player Move: ");
            String player = sc.next();

            System.out.print("Enter Computer Move: ");
            String computer = sc.next();

            String result = playRound(player, computer);

            System.out.println("Round " + i + ": " + result);

            if (result.equals("Player Wins"))
                wins++;
            else if (result.equals("Computer Wins"))
                losses++;
            else
                draws++;
        }

        double percentage = wins / 5.0 * 100;

        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win Percentage: " + percentage + "%");
    }
}