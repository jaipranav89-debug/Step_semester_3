
package week11.pratice_problems;

import java.util.Scanner;

class Node6 {
    int data;
    Node6 next;

    Node6(int data) {
        this.data = data;
    }
}

public class ReverseFirstK {
    static Node6 reverseFirstKNodes(Node6 head, int k) {
        Node6 prev = null;
        Node6 current = head;
        Node6 next = null;

        for (int i = 0; i < k; i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head.next = current;
        return prev;
    }

    static void display(Node6 head) {
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

        Node6 head = null, tail = null;

        for (int i = 0; i < n; i++) {
            Node6 newNode = new Node6(sc.nextInt());

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        head = reverseFirstKNodes(head, k);
        display(head);

        sc.close();
    }
}
