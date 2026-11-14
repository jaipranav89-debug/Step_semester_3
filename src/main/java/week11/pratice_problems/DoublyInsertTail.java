
package week11.pratice_problems;

import java.util.Scanner;

class DNode2 {
    int data;
    DNode2 prev, next;

    DNode2(int data) {
        this.data = data;
    }
}

public class DoublyInsertTail {
    static DNode2 insertAtTailDoubly(DNode2 head, int value) {
        DNode2 newNode = new DNode2(value);

        if (head == null) {
            return newNode;
        }

        DNode2 temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;

        return head;
    }

    static void display(DNode2 head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) {
                System.out.print(" <-> ");
            }
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        DNode2 head = null;

        for (int i = 0; i < n; i++) {
            head = insertAtTailDoubly(head, sc.nextInt());
        }

        System.out.print("Enter value to insert: ");
        int value = sc.nextInt();

        head = insertAtTailDoubly(head, value);

        display(head);
        sc.close();
    }
}

