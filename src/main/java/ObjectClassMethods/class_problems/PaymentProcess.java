package ObjectClassMethods.class_problems;

interface PaymentOption {
    boolean makePayment(double amount);
}

class CardPayment implements PaymentOption {
    public boolean makePayment(double amount) {
        return true;
    }
}

class OnlinePayment implements PaymentOption {
    public boolean makePayment(double amount) {
        return false;
    }
}

class Item {
    String name;
    double price;
    int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotal() {
        return price * quantity;
    }
}

class Buyer {
    String name;

    public Buyer(String name) {
        this.name = name;
    }
}

class ShoppingOrder {
    Buyer buyer;
    Item[] items;
    int count;
    String status;

    public ShoppingOrder(Buyer buyer) {
        this.buyer = buyer;
        items = new Item[10];
        count = 0;
        status = "Pending";
    }

    public void addItem(Item item) {
        items[count] = item;
        count++;
    }

    public double getTotal() {
        double total = 0;

        for (int i = 0; i < count; i++) {
            total += items[i].getTotal();
        }

        return total;
    }

    public void pay(PaymentOption payment, String method) {

        if (count == 0) {
            System.out.println("Cannot process payment for an empty order.");
            return;
        }

        System.out.println("Payment method: " + method);
        System.out.println("Total amount: $" + getTotal());

        if (payment.makePayment(getTotal())) {
            status = "Paid";
            System.out.println("Payment successful.");
        } else {
            System.out.println("Payment failed.");
        }

        System.out.println("Order status: " + status);
    }
}

public class PaymentProcess {
    public static void main(String[] args) {

        Buyer buyer1 = new Buyer("Buyer X");

        ShoppingOrder order1 = new ShoppingOrder(buyer1);

        order1.addItem(new Item("Item A", 100, 2));
        order1.addItem(new Item("Item B", 200, 1));

        order1.pay(new CardPayment(), "Credit Card");

        System.out.println();

        Buyer buyer2 = new Buyer("Buyer Y");

        ShoppingOrder order2 = new ShoppingOrder(buyer2);

        order2.pay(new CardPayment(), "Credit Card");

        System.out.println();

        Buyer buyer3 = new Buyer("Buyer Z");

        ShoppingOrder order3 = new ShoppingOrder(buyer3);

        order3.addItem(new Item("Item C", 300, 1));

        order3.pay(new OnlinePayment(), "PayPal");
    }
}