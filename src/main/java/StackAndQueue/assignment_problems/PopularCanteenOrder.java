package StackAndQueue.assignment_problems;

import java.util.Scanner;
import java.util.HashMap;

public class PopularCanteenOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] orders = new String[n];
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            orders[i] = sc.next();
            map.put(orders[i], map.getOrDefault(orders[i], 0) + 1);
        }

        String item = orders[0];
        int max = 0;

        for (int i = 0; i < n; i++) {
            int count = map.get(orders[i]);

            if (count > max) {
                max = count;
                item = orders[i];
            }
        }

        System.out.println("(\"" + item + "\", " + max + ")");
    }
}