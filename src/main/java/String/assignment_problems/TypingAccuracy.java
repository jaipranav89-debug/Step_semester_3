package Week1.assignment_problems;

import java.util.Scanner;

class TypingAccuracy {
    static void checkTypingAccuracy(String original, String typed) {
        int count = 0;
        int firstMismatch = -1;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                count++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy = (count * 100.0) / original.length();

        System.out.println("Matched: " + count + "/" + original.length());
        System.out.printf("Accuracy: %.2f%%%n", accuracy);

        if (firstMismatch == -1)
            System.out.println("No Mismatches");
        else
            System.out.println("First Mismatch at position " + (firstMismatch + 1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter original text: ");
        String original = sc.nextLine();

        System.out.print("Enter typed text: ");
        String typed = sc.nextLine();

        checkTypingAccuracy(original, typed);
    }
}