
package main.java.week12.assignment_problems;

import java.util.Scanner;

public class BrowserTapStrip {

    static class Node {
        String data;
        Node prev, next;

        Node(String data) {
            this.data = data;
        }
    }

    static Node current;
    static Node head;
    static Node tail;

    static void open(String name) {
        Node newNode = new Node(name);

        if (current == null) {
            head = tail = current = newNode;
        } else {
            newNode.prev = current;
            newNode.next = current.next;

            if (current.next != null) {
                current.next.prev = newNode;
            } else {
                tail = newNode;
            }

            current.next = newNode;
            current = newNode;
        }
    }

    static void close() {
        if (current == null) {
            return;
        }

        Node temp = current;

        if (temp.next != null) {
            current = temp.next;
        } else {
            current = temp.prev;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        } else {
            tail = temp.prev;
        }

        if (head == null) {
            current = null;
        }
    }

    static void back() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    static void forward() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    static void printTabs() {
        Node temp = head;

        while (temp != null) {
            if (temp == current) {
                System.out.print("[" + temp.data + "]");
            } else {
                System.out.print(temp.data);
            }

            if (temp.next != null) {
                System.out.print(" <-> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }

    static void printBackward() {
        Node temp = tail;

        while (temp != null) {
            System.out.print(temp.data);

            if (temp.prev != null) {
                System.out.print(" <-> ");
            }

            temp = temp.prev;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String command = sc.next();

            switch (command) {
                case "OPEN":
                    String name = sc.next();
                    open(name);
                    System.out.print("OPEN " + name + ": ");
                    break;

                case "CLOSE":
                    String closed = current == null ? "" : current.data;
                    close();
                    System.out.print("CLOSE " + closed + ": ");
                    break;

                case "BACK":
                    if (current != null && current.prev == null) {
                        System.out.println("BACK: already at first tab");
                        continue;
                    }
                    back();
                    System.out.print("BACK: ");
                    break;

                case "FORWARD":
                    forward();
                    System.out.print("FORWARD: ");
                    break;

                case "PRINT":
                    sc.next();
                    System.out.print("Backward: ");
                    printBackward();
                    continue;
            }

            printTabs();
        }
    }
}

