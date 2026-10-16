package week10.assignment_problems;

import java.util.Scanner;

class QueueNode {
    int data;
    QueueNode next;

    QueueNode(int data) {
        this.data = data;
    }
}

public class ReverseQueue {
    static QueueNode reverse(QueueNode head) {
        QueueNode prev = null;
        QueueNode curr = head;

        while (curr != null) {
            QueueNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueNode head = null, tail = null;

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            QueueNode node = new QueueNode(sc.nextInt());

            if (head == null)
                head = tail = node;
            else {
                tail.next = node;
                tail = node;
            }
        }

        head = reverse(head);
        QueueNode curr = head;

        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }

        System.out.println("null");
        sc.close();
    }
}