import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ComplaintManager manager = new ComplaintManager();
        int choice;

        do {
            System.out.println("\n===== Police Complaint Management System =====");
            System.out.println("1. Add Complaint");
            System.out.println("2. View Complaints");
            System.out.println("3. Delete Complaint");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();
                    System.out.print("Enter Complaint: ");
                    String complaintText = sc.nextLine();

                    Complaint complaint = new Complaint(name, email, phone, address, complaintText);
                    manager.addComplaint(complaint);
                }
                case 2 -> {
                    List<Complaint> complaints = manager.getAllComplaints();
                    System.out.println("\n--- All Complaints ---");
                    for (Complaint c : complaints) {
                        System.out.println("---------------------------");
                        System.out.println(c);
                    }
                }
                case 3 -> {
                    System.out.print("Enter Complaint ID to delete: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    manager.deleteComplaint(id);
                }
                case 4 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("❌ Invalid Choice");
            }

        } while (choice != 4);

        sc.close();
    }
}
