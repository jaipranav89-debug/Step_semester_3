package Week1.class_problems;

import java.util.Scanner;

class PalindromeChecker {
    static boolean isPalindromeIterative(String text) {
        int i = 0;
        int j = text.length() - 1;

        while (i < j) {
            if (text.charAt(i) != text.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }

    static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1)
            return true;

        if (text.charAt(0) != text.charAt(text.length() - 1))
            return false;

        return isPalindromeRecursive(
                text.substring(1, text.length() - 1)
        );
    }

    static boolean isPalindromeArrayReversal(String text) {
        char[] arr = text.toCharArray();

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }

        String reverse = new String(arr);

        return text.equals(reverse);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        if (isPalindromeIterative(text))
            System.out.println("Iterative: Palindrome");
        else
            System.out.println("Iterative: Not Palindrome");

        if (isPalindromeRecursive(text))
            System.out.println("Recursive: Palindrome");
        else
            System.out.println("Recursive: Not Palindrome");

        if (isPalindromeArrayReversal(text))
            System.out.println("Array Reversal: Palindrome");
        else
            System.out.println("Array Reversal: Not Palindrome");
    }
}