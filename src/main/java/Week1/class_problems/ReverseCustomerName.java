package Week1.class_problems;

import java.util.Scanner;

class ReverseCustomerName {
    static String reverseCustomerName(String customerName) {
        String reverse = "";

        for (int i = customerName.length() - 1; i >= 0; i--) {
            reverse = reverse + customerName.charAt(i);
        }

        return reverse;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        String reversed = reverseCustomerName(customerName);

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversed);
    }
}