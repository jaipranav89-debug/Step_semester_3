package week10.class_problems;

import java.util.*;

public class ClassMarksAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        List<int[]> marks = new ArrayList<>();
        int[] sum = new int[3];

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();

            if (line.isEmpty())
                continue;

            String[] parts = line.split("\\s+", 2);
            String name = parts[0];
            String[] values = parts[1].replaceAll("[\\[\\]]", "").split("\\s*,\\s*");

            int[] m = new int[3];

            for (int i = 0; i < 3; i++) {
                m[i] = Integer.parseInt(values[i]);
                sum[i] += m[i];
            }

            names.add(name);
            marks.add(m);
        }

        int topper = 0;
        int max = -1;

        System.out.print("Totals ");

        for (int i = 0; i < names.size(); i++) {
            int total = marks.get(i)[0] + marks.get(i)[1] + marks.get(i)[2];

            System.out.print(names.get(i) + " " + total);

            if (i < names.size() - 1)
                System.out.print(", ");

            if (total > max) {
                max = total;
                topper = i;
            }
        }

        System.out.printf("%naverages %.2f, %.2f, %.2f%n",
                (double) sum[0] / names.size(),
                (double) sum[1] / names.size(),
                (double) sum[2] / names.size());

        System.out.println("topper " + names.get(topper) + " (" + max + ")");
        sc.close();
    }
}