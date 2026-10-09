package StackAndQueue.class_problems;

import java.util.Scanner;

public class LibraryCatalogLookup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[][] catalog = new String[n][2];

        for (int i = 0; i < n; i++) {
            catalog[i][0] = sc.next();
            catalog[i][1] = sc.next();
        }

        String targetIsbn = sc.next();
        int low = 0, high = n - 1;
        String result = "Not Found";

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = catalog[mid][0].compareTo(targetIsbn);

            if (cmp == 0) {
                result = catalog[mid][1];
                break;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);
    }
}