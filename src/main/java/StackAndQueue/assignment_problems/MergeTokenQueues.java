package StackAndQueue.assignment_problems;

import java.util.Scanner;

public class MergeTokenQueues {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int[] a = new int[m];

        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
        }

        int n = sc.nextInt();
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        int[] result = new int[m + n];
        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        while (i < m) {
            result[k++] = a[i++];
        }

        while (j < n) {
            result[k++] = b[j++];
        }

        System.out.print("[");
        for (int x = 0; x < result.length; x++) {
            System.out.print(result[x]);

            if (x < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}