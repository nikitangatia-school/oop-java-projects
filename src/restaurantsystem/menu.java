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
