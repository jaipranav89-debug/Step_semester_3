
package week11.pratice_problems;

import java.util.Scanner;

class Node7 {
    int data;
    Node7 next;

    Node7(int data) {
        this.data = data;
    }
}

public class CountLinkedList {
    static int countNodes(Node7 head) {
        int count = 0;

        while (head != null) {
            count++;
            head = head.next;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        Node7 head = null, tail = null;

        for (int i = 0; i < n; i++) {
            Node7 newNode = new Node7(sc.nextInt());

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        System.out.println("Number of nodes: " + countNodes(head));

        sc.close();
    }
}

