package ObjectClassMethods.assignment_problems;

abstract class CinemaSeat {
    String seatNumber;
    boolean booked;

    public CinemaSeat(String seatNumber) {
        this.seatNumber = seatNumber;
        booked = false;
    }

    public abstract double getPrice();

    public boolean isAvailable() {
        return !booked;
    }

    public void book() {
        booked = true;
    }

    public void release() {
        booked = false;
    }
}

class RegularSeat extends CinemaSeat {
    public RegularSeat(String seatNumber) {
        super(seatNumber);
    }

    public double getPrice() {
        return 150;
    }
}

class PremiumSeat extends CinemaSeat {
    public PremiumSeat(String seatNumber) {
        super(seatNumber);
    }

    public double getPrice() {
        return 250;
    }
}

class ReclinerSeat extends CinemaSeat {
    public ReclinerSeat(String seatNumber) {
        super(seatNumber);
    }

    public double getPrice() {
        return 400;
    }
}

class MovieCustomer {
    String name;

    public MovieCustomer(String name) {
        this.name = name;
    }
}

class MovieShow {
    String time;

    public MovieShow(String time) {
        this.time = time;
    }
}

class SeatBooking {
    MovieCustomer customer;
    MovieShow show;
    CinemaSeat[] seats;
    int count;
    boolean cancelled;

    public SeatBooking(MovieCustomer customer, MovieShow show) {
        this.customer = customer;
        this.show = show;
        seats = new CinemaSeat[6];
        count = 0;
        cancelled = false;
    }

    public void addSeat(CinemaSeat seat) {
        if (count == 6) {
            System.out.println("Maximum 6 seats allowed.");
            return;
        }

        if (!seat.isAvailable()) {
            System.out.println("Seat " + seat.seatNumber
                    + " is already booked for this show.");
            return;
        }

        seats[count] = seat;
        count++;
        seat.book();
    }

    public void confirm() {
        if (count == 0) {
            System.out.println("No seats selected.");
            return;
        }

        System.out.print("Booking confirmed for "
                + customer.name + ": ");

        double total = 0;

        for (int i = 0; i < count; i++) {
            System.out.print(seats[i].seatNumber);

            if (i < count - 1)
                System.out.print(", ");

            total += seats[i].getPrice();
        }

        System.out.printf(". Total: ₹%.2f%n", total);
    }

    public void cancel() {
        if (!cancelled) {
            for (int i = 0; i < count; i++) {
                seats[i].release();
            }

            cancelled = true;

            System.out.println(customer.name
                    + "'s booking cancelled.");
        }
    }
}

public class TicketCounter {
    public static void main(String[] args) {

        MovieShow show = new MovieShow("7 PM");

        MovieCustomer asha = new MovieCustomer("Asha");
        MovieCustomer ravi = new MovieCustomer("Ravi");
        MovieCustomer neha = new MovieCustomer("Neha");

        CinemaSeat a1 = new RegularSeat("A1");
        CinemaSeat a2 = new RegularSeat("A2");
        CinemaSeat f5 = new PremiumSeat("F5");
        CinemaSeat r1 = new ReclinerSeat("R1");

        SeatBooking booking1 =
                new SeatBooking(asha, show);

        booking1.addSeat(a1);
        booking1.addSeat(a2);
        booking1.addSeat(f5);
        booking1.confirm();

        SeatBooking booking2 =
                new SeatBooking(ravi, show);

        booking2.addSeat(a2);
        booking2.addSeat(r1);
        booking2.confirm();

        booking1.cancel();

        SeatBooking booking3 =
                new SeatBooking(neha, show);

        booking3.addSeat(a2);
        booking3.confirm();
    }
}