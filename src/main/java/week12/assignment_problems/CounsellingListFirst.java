
package main.java.week12.assignment_problems;

import java.util.Scanner;

public class CounsellingListFirst {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node partition(Node head, int passMark) {
        Node lowHead = null, lowTail = null;
        Node highHead = null, highTail = null;

        while (head != null) {
            Node nextNode = head.next;
            head.next = null;

            if (head.data < passMark) {
                if (lowHead == null) {
                    lowHead = lowTail = head;
                } else {
                    lowTail.next = head;
                    lowTail = head;
                }
            } else {
                if (highHead == null) {
                    highHead = highTail = head;
                } else {
                    highTail.next = head;
                    highTail = head;
                }
            }

            head = nextNode;
        }

        if (lowHead == null) {
            return highHead;
        }

        lowTail.next = highHead;

        return lowHead;
    }

    static void display(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node head = null, tail = null;

        for (int i = 0; i < n; i++) {
            Node newNode = new Node(sc.nextInt());

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        int passMark = sc.nextInt();

        head = partition(head, passMark);

        display(head);
    }
}

