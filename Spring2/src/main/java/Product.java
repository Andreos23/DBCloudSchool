import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Product {
    private String code;
    private String name;
    private String description;
    private int stock;
    private double price;

    public Product(String code, String name, String description, int stock, double price) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static void insert(Product product) throws SQLException {
        Connection connection = Connect.connectToDatabase();
//        PreparedStatement psw = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
//        psw.execute();

        PreparedStatement psw = connection.prepareStatement("INSERT INTO `products` (`code`, `name`, `description`, `stock`, `price`) VALUES (?, ?, ?, ?, ?);");
        psw.setString(1, product.getCode());
        psw.setString(2, product.getName());
        psw.setString(3, product.getDescription());
        psw.setInt(4, product.getStock());
        psw.setDouble(5, product.getPrice());
        psw.execute();
    }
}
