package dz26;

public class User {
    private String name;
    private Address address;

    public User(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void printAddress() {
        if (address != null) {
            System.out.println(name + " lives at: " + address.getFullAddress());
        } else {
            System.out.println(name + " didn't enter address");
        }
    }
}