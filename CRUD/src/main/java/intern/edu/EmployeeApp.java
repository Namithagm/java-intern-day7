package intern.edu;
import java.sql.*;
import java.util.Scanner;
public class EmployeeApp {
    // Database connection details
    static final String URL = "jdbc:postgresql://localhost:5432/employeedb";
    static final String USER = "postgres";
    static final String PASSWORD = "test"; 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Connected to PostgreSQL Database!");
            while (true) {
                System.out.println("\n========= Employee CRUD Menu =========");
                System.out.println("1. Add Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        addEmployee(con, sc);
                        break;
                    case 2:
                        viewEmployees(con);
                        break;
                    case 3:
                        updateEmployee(con, sc);
                        break;
                    case 4:
                        deleteEmployee(con, sc);
                        break;
                    case 5:
                        con.close();
                        System.out.println("🔒 Connection Closed!");
                        System.exit(0);
                    default:
                        System.out.println("❌ Invalid choice, try again!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void addEmployee(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Name: ");
        String name = sc.next();
        System.out.print("Enter Email: ");
        String email = sc.next();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        String query = "INSERT INTO employee (name, email, salary) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setDouble(3, salary);

        int rows = ps.executeUpdate();
        System.out.println(rows + " employee(s) added successfully!");
    }

    static void viewEmployees(Connection con) throws SQLException {
        String query = "SELECT * FROM employee";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        System.out.println("\nID\tNAME\tEMAIL\tSALARY");
        System.out.println("------------------------------------------");
        while (rs.next()) {
            System.out.printf("%d\t%s\t%s\t%.2f\n",
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getDouble("salary"));
        }
    }
    static void updateEmployee(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();
        System.out.print("Enter new Salary: ");
        double salary = sc.nextDouble();

        String query = "UPDATE employee SET salary = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setDouble(1, salary);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();
        if (rows > 0)
            System.out.println("✅ Employee updated successfully!");
        else
            System.out.println("❌ Employee not found!");
    }
    static void deleteEmployee(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();

        String query = "DELETE FROM employee WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);

        int rows = ps.executeUpdate();
        if (rows > 0)
            System.out.println("🗑 Employee deleted successfully!");
        else
            System.out.println("❌ Employee not found!");
    }
}
