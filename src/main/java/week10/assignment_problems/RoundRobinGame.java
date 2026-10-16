
package week10.assignment_problems;

import java.util.Scanner;

class PlayerNode {
    String name;
    PlayerNode next;

    PlayerNode(String name) {
        this.name = name;
    }
}

class RoundRobinList {
    PlayerNode tail;

    void addLast(String name) {
        PlayerNode newNode = new PlayerNode(name);

        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    void printTurns(int turns) {
        if (tail == null) {
            return;
        }

        PlayerNode current = tail.next;

        for (int i = 0; i < turns; i++) {
            System.out.print(current.name);

            if (i < turns - 1) {
                System.out.print(" ");
            }

            current = current.next;
        }

        System.out.println();
    }
}

public class RoundRobinGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoundRobinList list = new RoundRobinList();

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            list.addLast(sc.nextLine());
        }

        int turns = sc.nextInt();
        list.printTurns(turns);

        sc.close();
    }
}
