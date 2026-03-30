package restaurantsystem;

import java.util.*;
import java.io.*;

interface ShowInfo {
    void display();
}

interface Workable {
    void doWork();
}

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

class Staff extends Person implements ShowInfo, Workable {
    private int id;
    private String job;
    
    public Staff(String name, String phone, int id, String job) {
        super(name, phone);
        this.id = id;
        this.job = job;
    }
    
    public int getId() { return id; }
    public String getJob() { return job; }
    
    public void introduce() {
        System.out.println("Hi, I'm " + getName() + " and I work as the " + job);
    }
    
    public void display() {
        System.out.println("Staff: " + getName() + " | Phone: " + getPhone() + " | ID: " + id + " | Job: " + job);
    }
    
    public void doWork() {
        System.out.println(getName() + " is working as the " + job);
    }
    
    public String toString() {
        return "Staff: " + getName() + " | Phone: " + getPhone() + " | ID: " + id + " | Job: " + job;
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

public class RestaurantSystem {
    private static final String STAFF_FILE = "staff.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Staff> staffList = new ArrayList<>();

        loadStaffData(staffList);

        System.out.println("--- RESTAURANT SYSTEM ---");

        try {
            System.out.print("Enter Staff name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Staff phone: ");
            String phone = scanner.nextLine();

            System.out.print("Enter Staff ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Staff job: ");
            String job = scanner.nextLine();

            Staff newStaff = new Staff(name, phone, id, job);
            staffList.add(newStaff);

            saveStaffData(staffList);

            System.out.println("\nCurrent Staff:");
            for (Staff s : staffList) {
                s.display();
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid ID format.");
        }

        scanner.close();
    }

    private static void saveStaffData(List<Staff> list) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(STAFF_FILE))) {
            for (Staff s : list) {
                writer.println(s.getName() + "," + s.getPhone() + "," + s.getId() + "," + s.getJob());
            }
        } catch (IOException e) {
            System.out.println("Error saving: " + e.getMessage());
        }
    }

    private static void loadStaffData(List<Staff> list) {
        File file = new File(STAFF_FILE);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    list.add(new Staff(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading: " + e.getMessage());
        }
    }
}
