package ObjectClassMethods.class_problems;

interface PaymentMethod {
    boolean processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod {
    public boolean processPayment(double amount) {
        return true;
    }
}

class PayPalPayment implements PaymentMethod {
    public boolean processPayment(double amount) {
        return false;
    }
}

class Product {
    String name;
    double price;
    int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotal() {
        return price * quantity;
    }
}

class Customer {
    String name;

    public Customer(String name) {
        this.name = name;
    }
}

class Order {
    Customer customer;
    Product[] products;
    int count;
    String status;

    public Order(Customer customer) {
        this.customer = customer;
        products = new Product[10];
        count = 0;
        status = "Pending";
    }

    public void addProduct(Product product) {
        products[count] = product;
        count++;
    }

    public double getTotal() {
        double total = 0;

        for (int i = 0; i < count; i++) {
            total += products[i].getTotal();
        }

        return total;
    }

    public void pay(PaymentMethod method, String methodName) {

        if (count == 0) {
            System.out.println("Cannot process payment for an empty order.");
            return;
        }

        System.out.println("Payment initiated via " + methodName
                + " for Order " + customer.name);

        if (method.processPayment(getTotal())) {
            status = "Paid";
            System.out.println("Payment for Order " + customer.name + " successful.");
        } else {
            System.out.println("Payment for Order " + customer.name + " failed.");
        }

        System.out.println("Order status: " + status);
    }
}

public class ShoppingPayment {
    public static void main(String[] args) {

        Customer x = new Customer("X");

        Order order1 = new Order(x);
        order1.addProduct(new Product("Product A", 100, 2));
        order1.addProduct(new Product("Product B", 200, 1));

        System.out.println("Order created for Customer X.");
        order1.pay(new CreditCardPayment(), "Credit Card");

        System.out.println();

        Customer y = new Customer("Y");
        Order order2 = new Order(y);

        order2.pay(new CreditCardPayment(), "Credit Card");

        System.out.println();

        Customer z = new Customer("Z");
        Order order3 = new Order(z);
        order3.addProduct(new Product("Product C", 300, 1));

        System.out.println("Order created for Customer Z.");
        order3.pay(new PayPalPayment(), "PayPal");
    }
}
