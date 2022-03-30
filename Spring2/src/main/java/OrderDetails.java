import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDetails {
    private int id;
    private String productCode;
    private int quantity;
    private double priceEach;
    private int orderId;

    public OrderDetails(int id, String productCode, int quantity, double priceEach, int orderId) {
        this.id = id;
        this.productCode = productCode;
        this.quantity = quantity;
        this.priceEach = priceEach;
        this.orderId = orderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(double priceEach) {
        this.priceEach = priceEach;
    }

    public static void insert(OrderDetails orderDetails) throws SQLException {
        Connection connection = Connect.connectToDatabase();
        PreparedStatement psw = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
        psw.execute();

        psw = connection.prepareStatement("INSERT INTO `orderdetails` (`id`, `product_code`, `quantity`, `priceEach`, `order_id`) VALUES (?, ?, ?, ?, ?);");
        psw.setInt(1, orderDetails.getId());
        psw.setString(2, orderDetails.getProductCode());
        psw.setInt(3, orderDetails.getQuantity());
        psw.setDouble(4, orderDetails.getPriceEach());
        psw.setInt(5, orderDetails.getOrderId());
        psw.execute();
    }
}
