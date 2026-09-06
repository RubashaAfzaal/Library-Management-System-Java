public class Staff {
    private int id;
    private String name;
    private String address;
    private int phone;
    private double salary;
    private String role;

    // Constructor matching: (id, name, role, phone, salary)
    public Staff(int id, String name, String role, int phone, double salary) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.phone = phone;
        this.salary = salary;
        this.address = "";
    }

    // Constructor matching: (id, name, address, phone, salary, role)
    public Staff(int id, String name, String address, int phone, double salary, String role) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.salary = salary;
        this.role = role;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public int getPhone() { return phone; }
    public double getSalary() { return salary; }
    public String getRole() { return role; }
}
