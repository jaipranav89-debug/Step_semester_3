package AccessModifiers.class_problems;

class BookingReceipt {
    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {
        this.bookingId = bookingId;
        this.seatNumbers = seatNumbers.clone();
    }

    String[] getSeatNumbers() {
        return seatNumbers.clone();
    }

    BookingReceipt withUpdatedSeat(int index, String newSeat) {
        String[] seats = seatNumbers.clone();
        seats[index] = newSeat;
        return new BookingReceipt(bookingId, seats);
    }
}

class GroupBookingReceipt extends BookingReceipt {
    private int groupSize;

    public GroupBookingReceipt(String bookingId, String[] seatNumbers, int groupSize) {
        super(bookingId, seatNumbers);
        this.groupSize = groupSize;
    }
}

class BookingReceiptTest {
    static String processNightlySettlement(BookingReceipt[] receipts) {
        int processed = 0;
        int skipped = 0;
        int group = 0;
        int individual = 0;

        for (int i = 0; i < receipts.length; i++) {
            if (receipts[i] == null) {
                skipped++;
            } else {
                processed++;

                if (receipts[i] instanceof GroupBookingReceipt)
                    group++;
                else
                    individual++;
            }
        }

        return processed + " processed | " + skipped + " null skipped | "
                + group + " group | " + individual + " individual";
    }

    public static void main(String[] args) {
        BookingReceipt[] receipts = {
                new GroupBookingReceipt("CH-2002", new String[]{"B1", "B2"}, 2),
                null,
                new BookingReceipt("CH-3003", new String[]{"C1"})
        };

        System.out.println(processNightlySettlement(receipts));
    }
}