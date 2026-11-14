
package week11.pratice_problems;

import java.util.Scanner;

class Node1 {
    int data;
    Node1 next;

    Node1(int data) {
        this.data = data;
    }
}

public class CircularPrintList {
    static void printCircular(Node1 head) {
        if (head == null) {
            System.out.println();
            return;
        }

        Node1 temp = head;

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

        Node1 head = null, tail = null;

        for (int i = 0; i < n; i++) {
            Node1 newNode = new Node1(sc.nextInt());

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        if (tail != null) {
            tail.next = head;
        }

        printCircular(head);
        sc.close();
    }
}
