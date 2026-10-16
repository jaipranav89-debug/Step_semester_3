package week10.class_problems;

import java.util.*;

class Payslip {
    String name, type;
    int pay;

    Payslip(String name, String type, int pay) {
        this.name = name;
        this.type = type;
        this.pay = pay;
    }

    public String toString() {
        return "Payslip[name=" + name + ", type=" + type + ", pay=" + pay + "]";
    }
}

public class PayrollRegisterSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Payslip> list = new ArrayList<>();
        int total = 0;

        while (sc.hasNext()) {
            String type = sc.next();
            String name = sc.next();
            int pay;

            if (type.equals("FullTime")) {
                pay = sc.nextInt();
            } else if (type.equals("PartTime")) {
                int hours = sc.nextInt();
                int rate = sc.nextInt();
                pay = hours * rate;
            } else {
                pay = sc.nextInt();
            }

            list.add(new Payslip(name, type, pay));
            total += pay;
        }

        if (list.isEmpty()) {
            sc.close();
            return;
        }

        Payslip top = list.get(0);

        for (Payslip p : list) {
            System.out.println(p);

            if (p.pay > top.pay)
                top = p;
        }

        System.out.println("Total " + total);
        System.out.println("top earner " + top.name);

        sc.close();
    }
}