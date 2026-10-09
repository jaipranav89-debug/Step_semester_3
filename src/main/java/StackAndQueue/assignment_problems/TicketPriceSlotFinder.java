package StackAndQueue.assignment_problems;

import java.util.Scanner;

public class TicketPriceSlotFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int newPrice = sc.nextInt();

        int low = 0;
        int high = n - 1;
        int result = n;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (prices[mid] == newPrice) {
                result = mid;
                break;
            } else if (prices[mid] < newPrice) {
                low = mid + 1;
            } else {
                result = mid;
                high = mid - 1;
            }
        }

        System.out.println(result);
    }
}