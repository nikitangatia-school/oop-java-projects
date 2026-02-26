package restaurantsystem;

// INTERFACES

interface ShowInfo {
    void display();
}

interface Workable {
    void doWork();
}

// ABSTRACT CLASSES

abstract class Person {
    private String name;
    private String phone;
    
    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
    
    public String getName() { return name; }
    public String getPhone() { return phone; }
    
    public abstract void introduce();
}

abstract class Food {
    private String name;
    private double price;
    
    public Food(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() { return name; }
    public double getPrice() { return price; }
    
    public abstract void make();
}

// CONCRETE CLASSES

class Staff extends Person implements ShowInfo, Workable {
    private int id;
    private String job;
    
    public Staff(String name, String phone, int id, String job) {
        super(name, phone);
        this.id = id;
        this.job = job;
    }
    
    public void introduce() {
        System.out.println("Hi, I'm " + getName() + " and I work as the " + job);
    }
    
    public void display() {
        System.out.println("Staff: " + getName() + " | Phone: " + getPhone() + " | ID: " + id + " | Job: " + job);
    }
    
    public void doWork() {
        System.out.println(getName() + " is working as the " + job);
    }
}

class Customer extends Person implements ShowInfo {
    private String email;
    
    public Customer(String name, String phone, String email) {
        super(name, phone);
        this.email = email;
    }
    
    public void introduce() {
        System.out.println("Hello, I'm " + getName() + "!");
    }
    
    public void display() {
        System.out.println("Customer: " + getName() + " | Phone: " + getPhone() + " | Email: " + email);
    }
    
    public void orderFood() {
        System.out.println(getName() + " is ordering food");
    }
}

class MenuFood extends Food implements ShowInfo {
    private String ingredients;
    
    public MenuFood(String name, double price, String ingredients) {
        super(name, price);
        this.ingredients = ingredients;
    }
    
    public void make() {
        System.out.println("Kitchen is making: " + getName());
    }
    
    public void display() {
        System.out.println("Food: " + getName() + " | Price: KSh " + getPrice() + " | Contains: " + ingredients);
    }
}

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

// MAIN CLASS

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