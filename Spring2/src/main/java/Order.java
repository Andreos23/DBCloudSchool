import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private Date orderDate;
    private Date shippedDate;
    private String status;
    private String comments;
    private int customerId;

    public Order(int id, Date orderDate, Date shippedDate, String status, String comments, int customerId) {
        this.id = id;
        this.orderDate = orderDate;
        this.shippedDate = shippedDate;
        this.status = status;
        this.comments = comments;
        this.customerId = customerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public static void insert(Order order) throws SQLException {
        Connection connection = Connect.connectToDatabase();
//        PreparedStatement psw = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
//        psw.execute();

        PreparedStatement psw = connection.prepareStatement("INSERT INTO `orders` (`id`, `order_date`, `shipped_date`, `status`, `comments`, `customer_id`) VALUES (?, ?, ?, ?, ?, ?);");
        psw.setInt(1, order.getId());
        psw.setDate(2, new java.sql.Date(order.getOrderDate().getTime()));
        psw.setDate(3, new java.sql.Date(order.getShippedDate().getTime()));
        psw.setString(4, order.getStatus());
        psw.setString(5, order.getComments());
        psw.setInt(6, order.getCustomerId());
        psw.execute();
    }

    public static List<Order> getAllByCustomer(Customer customer) throws SQLException {
        Connection connection = Connect.connectToDatabase();
        Statement ps = connection.createStatement();

        ResultSet rs = ps.executeQuery("SELECT * FROM orders WHERE `customer_id` = " + customer.getID());

        List<Order> orders = new ArrayList<>();

        while (rs.next()) {
            orders.add(new Order(rs.getInt("id"),
                    rs.getDate("order_date"),
                    rs.getDate("shipped_date"),
                    rs.getString("status"),
                    rs.getString("comments"),
                    customer.getID()
            ));
        }

        return orders;
    }

    public static void updateStatus(int id, String newStatus) throws SQLException {
        Connection connection = Connect.connectToDatabase();

        PreparedStatement psw = connection.prepareStatement("UPDATE `orders` SET `status` = ? WHERE `id` = ?;");
        psw.setString(1,newStatus);
        psw.setInt(2, id);
        psw.execute();
    }

    public static void updateComments(int id, String newComments) throws SQLException {
        Connection connection = Connect.connectToDatabase();

        PreparedStatement psw = connection.prepareStatement("UPDATE `orders` SET `status` = ? WHERE `id` = ?;");
        psw.setString(1,newComments);
        psw.setInt(2, id);
        psw.execute();
    }

    public static void placeOrder(int id) {
        // aici ar trebui sa scad quantity din products
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", order_date=" + orderDate +
                ", shipped_date=" + shippedDate +
                ", status='" + status + '\'' +
                ", comments='" + comments + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
