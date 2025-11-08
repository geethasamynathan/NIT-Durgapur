
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDDemo1 {

    // ====== 1) Update these to match your local setup ======
    private static final String URL
            = "jdbc:mysql://localhost:3306/demo_db?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

    private static final String USER = "devuser"; // use the no-password user
    private static final String PASS = "";

    // Option B: devuser with blank password
    // private static final String USER = "devuser";
    // private static final String PASS = ""; // blank
    // ========================================================
    // Simple Employee POJO
    static class Employee {

        Integer id;
        String name;
        String dept;
        double salary;

        Employee(Integer id, String name, String dept, double salary) {
            this.id = id;
            this.name = name;
            this.dept = dept;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return String.format("Employee{id=%s, name='%s', dept='%s', salary=%.2f}", id, name, dept, salary);
        }
    }

    // ---- CRUD helpers ----
    // Create
    static int createEmployee(String name, String dept, double salary) throws SQLException {
        String sql = "INSERT INTO employees (name, dept, salary) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS); PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, name);
            ps.setString(2, dept);
            ps.setDouble(3, salary);
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1;
    }

    // Read (by id)
    static Employee getEmployee(int id) throws SQLException {
        String sql = "SELECT * FROM employees WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Employee(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("dept"),
                            rs.getDouble("salary"));
                }
            }
        }
        return null;
    }

    // Read (all)
    static List<Employee> listEmployees() throws SQLException {
        String sql = "SELECT id, name, dept, salary FROM employees ORDER BY id";
        List<Employee> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("dept"),
                        rs.getDouble("salary")));
            }
        }
        return list;
    }

    // Update (salary)
    static boolean updateSalary(int id, double newSalary) throws SQLException {
        String sql = "UPDATE employees SET salary = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, newSalary);
            ps.setInt(2, id);
            return ps.executeUpdate() == 1;
        }
    }

    // Delete
    static boolean deleteEmployee(int id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        }
    }

    // ---- Demo flow ----
    public static void main(String[] args) {
        // With modern JDBC, you don't need Class.forName for the MySQL driver if it's on the classpath.
        try {
            System.out.println("== CREATE ==");
            int id1 = createEmployee("Ananya", "Engineering", 75000.00);
            int id2 = createEmployee("Rohit", "Finance", 52000.00);
            int id3 = createEmployee("Meera", "HR", 48000.00);
            System.out.printf("Inserted IDs: %d, %d, %d%n%n", id1, id2, id3);

            System.out.println("== READ (one) ==");
            System.out.println(getEmployee(id2));
            System.out.println();

            System.out.println("== READ (all) ==");
            listEmployees().forEach(System.out::println);
            System.out.println();

            System.out.println("== UPDATE (salary) ==");
            boolean updated = updateSalary(id1, 80000.00);
            System.out.println("Updated? " + updated);
            System.out.println(getEmployee(id1));
            System.out.println();

            System.out.println("== DELETE ==");
            boolean deleted = deleteEmployee(id3);
            System.out.println("Deleted? " + deleted);
            System.out.println();

            System.out.println("== FINAL LIST ==");
            listEmployees().forEach(System.out::println);

        } catch (SQLException e) {
            System.err.println("DB error: " + e.getMessage());
        }
    }
}
