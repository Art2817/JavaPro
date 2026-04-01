package dz26;

public class Main {
    public static void main(String[] args) {
        User user = new User("Artem");
        Address address = new Address("Dnipro", "Wall street");
        user.setAddress(address);
        user.printAddress();
    }
}