import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        // test insert
        Customer.insert(new Customer(1, "Ion_x", "Glanetasu", "Ion", "074444444", "Str Independ",
                "Bucuresti", "625400", "Romania"));
        Customer.insert(new Customer(2, "Olex", "Popescu", "Alex", "074444444", "Str Muncii",
                "Bucuresti", "625400", "Romania"));
        Customer.insert(new Customer(3, "kiki", "Ionescu", "Kiki", "074444411", "Str Libertatii",
                "Bucuresti", "625430", "Romania"));

        // test getById
        Customer customer = Customer.getById(1);
        System.out.println(customer + "\n");

        // test getAll
        List<Customer> customers = Customer.getAll();
        for (Customer currentCustomer: customers) {
            System.out.println(currentCustomer);
        }
        System.out.println();

        // test update
        Customer.update(new Customer(1, "Ionel", "Glanetasu", "Ion", "0722222222", "Str Jaja",
                "Iasi", "621400", "Romania"));
        customer = Customer.getById(1);
        System.out.println(customer + "\n");

        // test delete
        Customer.delete(2);
        customers = Customer.getAll();
        for (Customer currentCustomer: customers) {
            System.out.println(currentCustomer);
        }
        System.out.println();

        // test insert order
        Order.insert(new Order(1, new Date(1), new Date(2), "PENDING", "", customers.get(0).getID()));
        Order.insert(new Order(2, new Date(3), new Date(4), "PENDING", "", customers.get(1).getID()));
        Order.insert(new Order(3, new Date(123131), new Date(213561246), "PENDING", "", customers.get(0).getID()));

        // test get orders of a customer
        List<Order> orders = Order.getAllByCustomer(customer);
        for (Order order: orders) {
            System.out.println(order);
        }
        System.out.println();

        // test update status & comments
        Order.updateStatus(orders.get(0).getId(), "FINISHED");
        Order.updateComments(orders.get(1).getId(), "bla bla bla");
        orders = Order.getAllByCustomer(customer);
        for (Order order: orders) {
            System.out.println(order);
        }
        System.out.println();

        // insert orderDetails
        Product.insert(new Product("abc", "Lapte", "Zuzu", 10, 9.8));
        Product.insert(new Product("bsb", "Miere", "de albine", 3, 7.8));

        // add orderDetails
        OrderDetails.insert(new OrderDetails(1, "abc", 3, 19.6, 1));
        OrderDetails.insert(new OrderDetails(2, "abc", 3, 19.6, 1));

        // place order
        Order.placeOrder(1);
    }
}
