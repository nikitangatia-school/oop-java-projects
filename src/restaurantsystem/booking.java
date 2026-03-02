class Booking {
    private int bookingNumber;
    private String customerName;
    private String time;
    
    public Booking(int number, String customer, String time) {
        this.bookingNumber = number;
        this.customerName = customer;
        this.time = time;
    }
    
    public void confirm() {
        System.out.println("Booking #" + bookingNumber + " confirmed for " + customerName + " at " + time);
    }
    
    public void show() {
        System.out.println("Booking #" + bookingNumber + " | Customer: " + customerName + " | Time: " + time);
    }
}
