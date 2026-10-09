package StackAndQueue.assignment_problems;

import java.util.Scanner;

public class HotWeatherAlerts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] readings = new int[n];

        for (int i = 0; i < n; i++) {
            readings[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        int threshold = sc.nextInt();

        int sum = 0;
        int count = 0;

        for (int i = 0; i < k; i++) {
            sum += readings[i];
        }

        if (sum >= k * threshold) {
            count++;
        }

        for (int i = k; i < n; i++) {
            sum += readings[i] - readings[i - k];

            if (sum >= k * threshold) {
                count++;
            }
        }

        System.out.println(count);
    }
}
