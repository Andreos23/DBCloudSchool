import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int ID;
    private String username;
    private String last_name;
    private String first_name;
    private String phone;
    private String address;
    private String city;
    private String postalCode;
    private String country;

    public Customer(int ID, String username, String last_name, String first_name, String phone, String address, String city, String postalCode, String country) {
        this.ID = ID;
        this.username = username;
        this.last_name = last_name;
        this.first_name = first_name;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static Customer getById(int id) throws SQLException {
        Connection connection = Connect.connectToDatabase();
        Statement ps = connection.createStatement();

        ResultSet rs = ps.executeQuery("SELECT * FROM customers WHERE `id` = " + id);

        rs.next();
        return new Customer(rs.getInt("id"),
                rs.getString("username"),
                rs.getString("last_name"),
                rs.getString("first_name"),
                rs.getString("phone"),
                rs.getString("address"),
                rs.getString("city"),
                rs.getString("postalCode"),
                rs.getString("country")
        );
    }

    public static List<Customer> getAll() throws SQLException {
        Connection connection = Connect.connectToDatabase();
        Statement ps = connection.createStatement();

        ResultSet rs = ps.executeQuery("SELECT * FROM customers");

        List<Customer> customers = new ArrayList<>();

        while (rs.next()) {
            customers.add(new Customer(rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("last_name"),
                    rs.getString("first_name"),
                    rs.getString("phone"),
                    rs.getString("address"),
                    rs.getString("city"),
                    rs.getString("postalCode"),
                    rs.getString("country")
            ));
        }

        return customers;
    }

    public static void update(Customer customer) throws SQLException {
        Connection connection = Connect.connectToDatabase();

        PreparedStatement psw = connection.prepareStatement("UPDATE `customers` SET `username` = ?, `last_name` = ?, `first_name` = ?, `phone` = ?, `address` = ?, `city` = ?, `postalCode` = ?, `country` = ? WHERE `id` = ?;");
        psw.setString(1, customer.getUsername());
        psw.setString(2, customer.getLast_name());
        psw.setString(3, customer.getFirst_name());
        psw.setString(4, customer.getPhone());
        psw.setString(5, customer.getAddress());
        psw.setString(6, customer.getCity());
        psw.setString(7, customer.getPostalCode());
        psw.setString(8, customer.getCountry());
        psw.setInt(9, customer.getID());
        psw.execute();
    }

    public static void insert(Customer customer) throws SQLException {
        Connection connection = Connect.connectToDatabase();

        PreparedStatement psw = connection.prepareStatement("INSERT INTO `customers` (`id`, `username`, `last_name`, `first_name`, `phone`, `address`, `city`, `postalCode`, `country`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
        psw.setInt(1, customer.getID());
        psw.setString(2, customer.getUsername());
        psw.setString(3, customer.getLast_name());
        psw.setString(4, customer.getFirst_name());
        psw.setString(5, customer.getPhone());
        psw.setString(6, customer.getAddress());
        psw.setString(7, customer.getCity());
        psw.setString(8, customer.getPostalCode());
        psw.setString(9, customer.getCountry());
        psw.execute();
    }

    public static void delete(int id) throws SQLException {
        Connection connection = Connect.connectToDatabase();

        PreparedStatement psw = connection.prepareStatement("DELETE FROM `customers` WHERE `id` = ?;");
        psw.setInt(1, id);
        psw.execute();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    /*
    `id` int(11) NOT NULL AUTO_INCREMENT,
      `username` varchar(50) DEFAULT NULL,
      `last_name` varchar(50) DEFAULT NULL,
      `first_name` varchar(50) DEFAULT NULL,
      `phone` varchar(50) DEFAULT NULL,
      `address` varchar(50) DEFAULT NULL,
      `city` varchar(50) DEFAULT NULL,
      `postalCode` varchar(15) DEFAULT NULL,
      `country` varchar(50) DEFAULT NULL,
     */
}
