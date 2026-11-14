
package week11.pratice_problems;

import java.util.Scanner;

class Node5 {
    int data;
    Node5 next;

    Node5(int data) {
        this.data = data;
    }
}

public class SplitLinkedList {
    static Node5 splitListInHalf(Node5 head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node5 slow = head;
        Node5 fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node5 second = slow.next;
        slow.next = null;

        return second;
    }

    static void display(Node5 head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        Node5 head = null, tail = null;

        for (int i = 0; i < n; i++) {
            Node5 newNode = new Node5(sc.nextInt());

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node5 second = splitListInHalf(head);

        System.out.print("First half: ");
        display(head);

        System.out.print("Second half: ");
        display(second);

        sc.close();
    }
}
