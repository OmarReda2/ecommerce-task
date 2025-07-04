import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // add products
        Product cheese = new Product("cheese", 100.00, 11,
                                        LocalDate.of(2027,7,7), true, 500.00);

        Product biscuits = new Product("biscuits", 150.00, 10,
                                        LocalDate.of(2026,6,6), true, 200.00);


        // customer no. 1
        Customer customer1 = new Customer("Omar", 300.99);
        Cart cart1 = new Cart();

        cart1.add(cheese,2);
        cart1.add(biscuits, 1);

        Checkout.checkout(customer1, cart1);


        System.out.println("\ncustomer Balance: " + customer1.getBalance());





    }
}