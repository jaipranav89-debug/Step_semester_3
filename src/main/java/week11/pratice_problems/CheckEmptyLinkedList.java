
package week11.pratice_problems;

import java.util.Scanner;

class Node8 {
    int data;
    Node8 next;

    Node8(int data) {
        this.data = data;
    }
}

public class CheckEmptyLinkedList {
    static boolean checkIfEmpty(Node8 head) {
        return head == null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        Node8 head = null, tail = null;

        for (int i = 0; i < n; i++) {
            Node8 newNode = new Node8(sc.nextInt());

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        System.out.println(checkIfEmpty(head));

        sc.close();
    }
}

