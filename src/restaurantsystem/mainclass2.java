import java.util.Scanner;

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    try {
        System.out.println("RESTAURANT SYSTEM\n");
  
        System.out.print("Staff name: ");
        String staffName = scanner.nextLine();
        
        System.out.print("Staff phone: ");
        String staffPhone = scanner.nextLine();
        
        System.out.print("Staff ID: ");
        int staffId = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Staff job: ");
        String staffJob = scanner.nextLine();
        
        Staff worker = new Staff(staffName, staffPhone, staffId, staffJob);
        
        System.out.print("Customer name: ");
        String customerName = scanner.nextLine();
        
        System.out.print("Customer phone: ");
        String customerPhone = scanner.nextLine();
        
        System.out.print("Customer email: ");
        String customerEmail = scanner.nextLine();
        
        Customer buyer = new Customer(customerName, customerPhone, customerEmail);
        
        System.out.print("Food name: ");
        String foodName = scanner.nextLine();
        
        System.out.print("Food price: ");
        double foodPrice = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Ingredients: ");
        String foodIngredients = scanner.nextLine();
        
        MenuFood meal = new MenuFood(foodName, foodPrice, foodIngredients);
        
        System.out.print("Booking number: ");
        int bookingNumber = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Booking customer: ");
        String bookingCustomer = scanner.nextLine();
        
        System.out.print("Booking time: ");
        String bookingTime = scanner.nextLine();
        
        Booking reservation = new Booking(bookingNumber, bookingCustomer, bookingTime);
      
        System.out.println("\nSTAFF");
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
        
    } catch (Exception e) {
        System.out.println("Input error! " + e.getMessage());
    } finally {
        scanner.close();
    }
}
