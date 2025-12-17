public class Complaint {
    private int id;
    private String name;       // Person's name
    private String email;
    private String phone;
    private String address;
    private String complaintText;

    // Constructor for adding new complaint
    public Complaint(String name, String email, String phone, String address, String complaintText) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.complaintText = complaintText;
    }

    // Constructor for reading from database (with id)
    public Complaint(int id, String name, String email, String phone, String address, String complaintText) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.complaintText = complaintText;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
    public String getComplaintText() { return complaintText; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Email: " + email + ", Phone: " + phone +
                ", Address: " + address + ", Complaint: " + complaintText;
    }
}
