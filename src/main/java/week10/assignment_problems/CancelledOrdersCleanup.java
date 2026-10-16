package week10.assignment_problems;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class CancelledOrdersCleanup {
    static Node removeAll(Node head, int code) {
        while (head != null && head.data == code)
            head = head.next;

        Node curr = head;

        while (curr != null && curr.next != null) {
            if (curr.next.data == code)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null, tail = null;

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            Node node = new Node(sc.nextInt());

            if (head == null)
                head = tail = node;
            else {
                tail.next = node;
                tail = node;
            }
        }

        int code = sc.nextInt();
        head = removeAll(head, code);

        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }

        System.out.println("null");
        sc.close();
    }
}