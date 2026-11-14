
package week12.practice_problems;

import java.util.Scanner;

class EditorStack {
    String[] words;
    int top;

    EditorStack(int capacity) {
        words = new String[capacity];
        top = -1;
    }

    void type(String word) {
        if (top == words.length - 1) {
            System.out.println("rejected: history full");
            return;
        }

        words[++top] = word;
        display();
    }

    void undo() {
        if (top == -1) {
            System.out.println("rejected: nothing to undo");
            return;
        }

        top--;
        display();
    }

    void display() {
        if (top == -1) {
            System.out.println("(empty)");
            return;
        }

        for (int i = 0; i <= top; i++) {
            System.out.print(words[i]);

            if (i < top) {
                System.out.print(" ");
            }
        }

        System.out.println();
    }
}

public class EditorUndoHistory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter capacity: ");
        int n = sc.nextInt();

        EditorStack editor = new EditorStack(n);

        System.out.print("Enter number of commands: ");
        int commands = sc.nextInt();

        for (int i = 0; i < commands; i++) {
            String operation = sc.next();

            if (operation.equalsIgnoreCase("TYPE")) {
                String word = sc.next();
                editor.type(word);
            } else if (operation.equalsIgnoreCase("UNDO")) {
                editor.undo();
            }
        }

        sc.close();
    }
}
