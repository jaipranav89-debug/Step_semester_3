
package week11.pratice_problems;

import java.util.Scanner;

class DNode10 {
    int data;
    DNode10 prev, next;

    DNode10(int data) {
        this.data = data;
    }
}

public class DoublyDeleteLast {
    static DNode10 deleteLastNodeDoubly(DNode10 head) {
        if (head == null || head.next == null) {
            return null;
        }

        DNode10 temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.prev.next = null;
        temp.prev = null;

        return head;
    }

    static void display(DNode10 head) {
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

        DNode10 head = null, tail = null;

        for (int i = 0; i < n; i++) {
            DNode10 newNode = new DNode10(sc.nextInt());

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }

        head = deleteLastNodeDoubly(head);
        display(head);

        sc.close();
    }
}


