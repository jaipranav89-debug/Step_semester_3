
package week12.practice_problems;

import java.util.Scanner;

public class ScoreBandCounter {
    static int lowerBound(int[] scores, int x) {
        int low = 0;
        int high = scores.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (scores[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    static int upperBound(int[] scores, int x) {
        int low = 0;
        int high = scores.length;

        while (low < high) {
            int mid = (low + high) / 2;

            if (scores[mid] <= x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of scores: ");
        int n = sc.nextInt();

        int[] scores = new int[n];

        System.out.println("Enter scores in sorted order:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        System.out.print("Enter number of queries: ");
        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            System.out.print("Enter query: ");
            int x = sc.nextInt();

            int below = lowerBound(scores, x);
            int exactly = upperBound(scores, x) - below;

            System.out.println(x + ": exactly " + exactly +
                    ", below " + below);
        }

        sc.close();
    }
}
