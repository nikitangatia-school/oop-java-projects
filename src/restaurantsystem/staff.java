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
