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
