
package week11.pratice_problems;

import java.util.Scanner;

class Node4 {
    int data;
    Node4 next;

    Node4(int data) {
        this.data = data;
    }
}

public class DeleteNthNode {
    static Node4 deleteNthNode(Node4 head, int n) {
        if (n == 1) {
            return head.next;
        }

        Node4 temp = head;

        for (int i = 1; i < n - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }

    static void display(Node4 head) {
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

        Node4 head = null, tail = null;

        for (int i = 0; i < n; i++) {
            Node4 newNode = new Node4(sc.nextInt());

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        System.out.print("Enter position to delete: ");
        int position = sc.nextInt();

        head = deleteNthNode(head, position);
        display(head);

        sc.close();
    }
}
