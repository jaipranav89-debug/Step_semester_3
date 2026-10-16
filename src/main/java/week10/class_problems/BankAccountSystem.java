package week10.class_problems;

import java.util.*;

class Account {
    String id;
    int balance;

    Account(String id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    boolean withdraw(int amount) {
        return false;
    }
}

class Savings extends Account {
    Savings(String id, int balance) {
        super(id, balance);
    }

    boolean withdraw(int amount) {
        if (balance - amount < 1000)
            return false;
        balance -= amount;
        return true;
    }
}

class Current extends Account {
    Current(String id, int balance) {
        super(id, balance);
    }

    boolean withdraw(int amount) {
        if (balance - amount < -5000)
            return false;
        balance -= amount;
        return true;
    }
}

public class BankAccountSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Account> map = new HashMap<>();

        while (sc.hasNext()) {
            String op = sc.next();

            if (op.equals("Savings") || op.equals("Current")) {
                String id = sc.next();
                int balance = sc.nextInt();

                if (op.equals("Savings"))
                    map.put(id, new Savings(id, balance));
                else
                    map.put(id, new Current(id, balance));

            } else if (op.equals("WITHDRAW")) {
                String id = sc.next();
                int amount = sc.nextInt();
                Account a = map.get(id);

                if (a == null)
                    System.out.println("Account not found");
                else if (!a.withdraw(amount)) {
                    if (a instanceof Savings)
                        System.out.println(id + " rejected: minimum balance 1000");
                    else
                        System.out.println(id + " rejected: overdraft limit 5000");
                } else {
                    System.out.println(id + " balance " + a.balance);
                }
            }
        }
        sc.close();
    }
}