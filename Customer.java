public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private int custNo;

    public Customer(String firstName, String lastName, String email, String address, int custNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.custNo = custNo;
    }

    @Override
    public String toString() {
        return "Customer Number: " + custNo + ", Full Name: " + firstName + " " + lastName + ", Email: " + email + ", Address: " + address;
    }
}
