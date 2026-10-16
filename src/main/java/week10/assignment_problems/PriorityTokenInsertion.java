package week10.assignment_problems;

import java.util.Scanner;

class TokenNode {
    int data;
    TokenNode next;

    TokenNode(int data) {
        this.data = data;
    }
}

public class PriorityTokenInsertion {
    TokenNode head;

    void addFirst(int token) {
        TokenNode node = new TokenNode(token);
        node.next = head;
        head = node;
    }

    void addLast(int token) {
        TokenNode node = new TokenNode(token);

        if (head == null) {
            head = node;
            return;
        }

        TokenNode curr = head;
        while (curr.next != null)
            curr = curr.next;

        curr.next = node;
    }

    void insertAt(int index, int token) {
        if (index == 0) {
            addFirst(token);
            return;
        }

        TokenNode curr = head;

        for (int i = 0; i < index - 1; i++)
            curr = curr.next;

        TokenNode node = new TokenNode(token);
        node.next = curr.next;
        curr.next = node;
    }

    void display() {
        TokenNode curr = head;

        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityTokenInsertion list = new PriorityTokenInsertion();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++)
            list.addLast(sc.nextInt());

        int operations = sc.nextInt();

        for (int i = 0; i < operations; i++) {
            String op = sc.next();

            if (op.equals("addFirst"))
                list.addFirst(sc.nextInt());
            else if (op.equals("addLast"))
                list.addLast(sc.nextInt());
            else if (op.equals("insertAt")) {
                int index = sc.nextInt();
                int token = sc.nextInt();
                list.insertAt(index, token);
            }
        }

        list.display();
        sc.close();
    }
}