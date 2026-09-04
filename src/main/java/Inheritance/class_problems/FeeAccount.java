package Inheritance.class_problems;

class FeeAccount{
    void pay(double amount) {
        System.out.println("Paid in one go (day-scholar account)");
    }
}

class HostelFeeAccount extends FeeAccount {
    void pay(double amount) {
        System.out.println("Paid in two installments (hostel account)");
    }
}

class AccountBatch {
    static int hostelCount = 0;
    static int dayScholarCount = 0;

    static void processPayment(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            HostelFeeAccount hostel = (HostelFeeAccount) account;
            hostel.pay(amount);
            hostelCount++;
        } else {
            account.pay(amount);
            dayScholarCount++;
        }
    }

    public static void main(String[] args) {
        FeeAccount[] accounts = {
                new HostelFeeAccount(),
                new HostelFeeAccount(),
                new FeeAccount(),
                new FeeAccount()
        };

        for (int i = 0; i < accounts.length; i++) {
            processPayment(accounts[i], 60000);
        }

        System.out.println("Hostel accounts processed: " + hostelCount);
        System.out.println("Day-scholar accounts processed: " + dayScholarCount);
    }
}