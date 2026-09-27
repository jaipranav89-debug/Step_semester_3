package ObjectClassMethods.class_problems;

abstract class HotelRoom {
    protected String roomNumber;
    protected boolean available;

    public HotelRoom(String roomNumber) {
        this.roomNumber = roomNumber;
        available = true;
    }

    public abstract double calculatePrice(int days);

    public boolean isAvailable() {
        return available;
    }

    public void book() {
        available = false;
    }

    public void cancel() {
        available = true;
    }
}

class StandardHotelRoom extends HotelRoom {
    public StandardHotelRoom(String roomNumber) {
        super(roomNumber);
    }

    public double calculatePrice(int days) {
        return days * 100;
    }
}

class DeluxeHotelRoom extends HotelRoom {
    public DeluxeHotelRoom(String roomNumber) {
        super(roomNumber);
    }

    public double calculatePrice(int days) {
        return days * 150;
    }
}

class Guest {
    String name;

    public Guest(String name) {
        this.name = name;
    }
}

class HotelReservation {
    Guest guest;
    HotelRoom room;
    int days;

    public HotelReservation(Guest guest, HotelRoom room, int days) {
        this.guest = guest;
        this.room = room;
        this.days = days;
    }

    public void display() {
        System.out.println("Reservation confirmed for " + guest.name);
        System.out.println("Room: " + room.roomNumber);
        System.out.println("Price: $" + room.calculatePrice(days));
    }
}

public class HotelBooking {
    public static void main(String[] args) {

        HotelRoom standard = new StandardHotelRoom("101");
        HotelRoom deluxe = new DeluxeHotelRoom("201");

        Guest guest1 = new Guest("Guest A");
        Guest guest2 = new Guest("Guest B");
        Guest guest3 = new Guest("Guest C");

        if (standard.isAvailable()) {
            System.out.println("Standard Room 101 is available.");

            standard.book();

            HotelReservation r1 =
                    new HotelReservation(guest1, standard, 4);

            r1.display();
        }

        if (!standard.isAvailable()) {
            System.out.println("Standard Room 101 is not available.");
        }

        standard.cancel();
        System.out.println("Reservation cancelled.");

        if (deluxe.isAvailable()) {
            deluxe.book();

            HotelReservation r2 =
                    new HotelReservation(guest3, deluxe, 2);

            r2.display();
        }
    }
}