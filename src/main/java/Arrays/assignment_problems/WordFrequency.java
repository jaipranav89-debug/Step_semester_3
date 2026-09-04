package Arrays.assignment_problems;

import java.util.Scanner;

class WordFrequency {
    static void printFilteredWordFrequency(String feedback) {
        feedback = feedback.toLowerCase();
        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        String[] words = feedback.split("\\s+");

        String[] unique = new String[words.length];
        int[] count = new int[words.length];
        int size = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("the") ||
                    words[i].equals("was") ||
                    words[i].equals("and") ||
                    words[i].equals("a") ||
                    words[i].equals("is") ||
                    words[i].equals("of") ||
                    words[i].equals("in")) {
                continue;
            }

            int position = -1;

            for (int j = 0; j < size; j++) {
                if (unique[j].equals(words[i])) {
                    position = j;
                    break;
                }
            }

            if (position == -1) {
                unique[size] = words[i];
                count[size] = 1;
                size++;
            } else {
                count[position]++;
            }
        }

        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (count[i] < count[j]) {
                    int tempCount = count[i];
                    count[i] = count[j];
                    count[j] = tempCount;

                    String tempWord = unique[i];
                    unique[i] = unique[j];
                    unique[j] = tempWord;
                }
            }
        }

        for (int i = 0; i < size; i++)
            System.out.println(unique[i] + ": " + count[i]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter feedback: ");
        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);
    }
}