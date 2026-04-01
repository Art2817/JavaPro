package dz26;

public class Address {
    private String city;
    private String street;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public String getFullAddress() {
        return city + ", " + street;
    }
}