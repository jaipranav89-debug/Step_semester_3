
package week11.pratice_problems;

import java.util.Scanner;

class Node9 {
    int data;
    Node9 next;

    Node9(int data) {
        this.data = data;
    }
}

public class CircularInsertEnd {
    static Node9 insertAtEndCircular(Node9 head, int value) {
        Node9 newNode = new Node9(value);

        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node9 temp = head;

        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;

        return head;
    }

    static void display(Node9 head) {
        if (head == null) {
            System.out.println();
            return;
        }

        Node9 temp = head;

        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        Node9 head = null;

        for (int i = 0; i < n; i++) {
            head = insertAtEndCircular(head, sc.nextInt());
        }

        System.out.print("Enter value to insert: ");
        int value = sc.nextInt();

        head = insertAtEndCircular(head, value);
        display(head);

        sc.close();
    }
}
