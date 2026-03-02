public class restaurant {
    public static void main(String[] args) {
        System.out.println(" RESTAURANT SYSTEM \n");
        
        Staff worker = new Staff("Jake Chege", "0702345678", 101, "Waiter");
        Customer buyer = new Customer("Jane Wanjiru", "0703132415", "jane@email.com");
        MenuFood meal = new MenuFood("Chicken Rice", 500, "Chicken, Rice, Vegetables");
        Booking reservation = new Booking(1, "Jane Wanjiru", "10:00 PM");
        
        System.out.println("STAFF");
        worker.introduce();
        worker.doWork();
        worker.display();
        
        System.out.println("\nCUSTOMER");
        buyer.introduce();
        buyer.orderFood();
        buyer.display();
        
        System.out.println("\nMENU");
        meal.make();
        meal.display();
        
        System.out.println("\nBOOKING");
        reservation.confirm();
        reservation.show();
    
        System.out.println("\n DONE ");
    }
}
