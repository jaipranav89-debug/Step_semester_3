
package week11.pratice_problems;

import java.util.Scanner;

class Node3 {
    int data;
    Node3 next;

    Node3(int data) {
        this.data = data;
    }
}

public class RemoveFirstK {
    static Node3 removeFirstKNodes(Node3 head, int k) {
        for (int i = 0; i < k && head != null; i++) {
            head = head.next;
        }
        return head;
    }

    static void display(Node3 head) {
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

        Node3 head = null, tail = null;

        for (int i = 0; i < n; i++) {
            Node3 newNode = new Node3(sc.nextInt());

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        head = removeFirstKNodes(head, k);
        display(head);

        sc.close();
    }
}

