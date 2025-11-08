import java.sql.*;

public class BankApp {
    public static void main(String[] args) {
        try {
            // 1️ Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2️ Connect to MySQL (update your password here)
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bankdb", "root", "Suraj@sql1");

            // 3️ Insert a new record
            String insertQuery = "INSERT INTO customers (name, balance) VALUES ('Suraj', 5000)";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(insertQuery);
            System.out.println(" Record Inserted!");

            // 4️ Display all customers
            ResultSet rs = stmt.executeQuery("SELECT * FROM customers");

           while (rs.next()) {
                int acc_no = rs.getInt("acc_no");
                String name = rs.getString("name");
                double balance = rs.getDouble("balance");
                 System.out.println(acc_no + " | " + name + " | Rs." + balance);
            }


            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

