package StackAndQueue.assignment_problems;

import java.util.Scanner;

public class ClassTopperFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] marks = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                marks[i][j] = sc.nextInt();
            }
        }

        int maxTotal = -1;
        int topper = 0;

        for (int i = 0; i < m; i++) {
            int total = 0;

            for (int j = 0; j < n; j++) {
                total += marks[i][j];
            }

            if (total > maxTotal) {
                maxTotal = total;
                topper = i;
            }
        }

        System.out.println("(" + topper + ", " + maxTotal + ")");
    }
}