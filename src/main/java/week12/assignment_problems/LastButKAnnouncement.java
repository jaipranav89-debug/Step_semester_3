
package main.java.week12.assignment_problems;

import java.util.Scanner;

class AnnouncementNode {
    int data;
    AnnouncementNode next;

    AnnouncementNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LastButKAnnouncement {

    static String kthFromEnd(AnnouncementNode head, int k) {
        AnnouncementNode fast = head;
        AnnouncementNode slow = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return "Invalid k";
            }
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return String.valueOf(slow.data);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        AnnouncementNode head = null, tail = null;

        for (int i = 0; i < n; i++) {
            AnnouncementNode newNode =
                    new AnnouncementNode(sc.nextInt());

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        int k = sc.nextInt();

        System.out.println(k + " from the end: " +
                kthFromEnd(head, k));
    }
}
