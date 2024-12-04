public class Employee {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private int empNo;

    public Employee(String firstName, String lastName, String email, String address, int empNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.empNo = empNo;
    }

    @Override
    public String toString() {
        return "Employee Number: " + empNo + ", Full Name: " + firstName + " " + lastName + ", Email: " + email + ", Address: " + address;
    }
}

