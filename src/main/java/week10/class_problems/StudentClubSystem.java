package week10.class_problems;

import java.util.*;

class Student {
    String roll, name;

    Student(String roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Student))
            return false;
        return roll.equals(((Student) o).roll);
    }

    public int hashCode() {
        return roll.hashCode();
    }
}

public class StudentClubSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Student> students = new HashSet<>();
        List<String> results = new ArrayList<>();
        List<String> checks = new ArrayList<>();

        while (sc.hasNext()) {
            String op = sc.next();
            String roll = sc.next();
            String name = sc.next();
            Student s = new Student(roll, name);

            if (op.equals("ADD")) {
                if (students.add(s))
                    results.add("Added");
                else
                    results.add("duplicate rejected");
            } else if (op.equals("CONTAINS")) {
                checks.add("contains: " + students.contains(s));
            }
        }

        for (String s : results)
            System.out.println(s);

        System.out.println("member count " + students.size());

        for (String s : checks)
            System.out.println(s);

        sc.close();
    }
}