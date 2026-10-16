package week10.assignment_problems;

import java.util.Scanner;

class CoachNode {
    String name;
    CoachNode prev, next;

    CoachNode(String name) {
        this.name = name;
    }
}

class TrainList {
    CoachNode head, tail;

    void addLast(String name) {
        CoachNode newNode = new CoachNode(name);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void remove(String name) {
        CoachNode current = head;

        while (current != null) {
            if (current.name.equals(name)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                return;
            }

            current = current.next;
        }
    }

    void printForward() {
        System.out.print("Forward: ");
        CoachNode current = head;

        while (current != null) {
            System.out.print(current.name);
            if (current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }

        System.out.println();
    }

    void printBackward() {
        System.out.print("Backward: ");
        CoachNode current = tail;

        while (current != null) {
            System.out.print(current.name);
            if (current.prev != null) {
                System.out.print(" <-> ");
            }
            current = current.prev;
        }

        System.out.println();
    }
}

public class TrainCoaches {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TrainList train = new TrainList();

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            train.addLast(sc.nextLine());
        }

        String removeName = sc.nextLine();

        train.remove(removeName);
        train.printForward();
        train.printBackward();

        sc.close();
    }
}