import java.util.Map;

public class Checkout {

    public static void checkout(Customer customer, Cart cart){

        if (cart.getCartMap().isEmpty()){ throw new RuntimeException("Cart is Empty! Add some items");}

        double shippingPrice = ShippingService.calcShipmentReciept(cart.getCartMap());

        System.out.println("");
        double allItemTotalPrice = calcRecipt(cart);
        allItemTotalPrice = allItemTotalPrice + shippingPrice;

        System.out.println("----------------------------------------");
        System.out.println("SubTotal                " + allItemTotalPrice);
        if (shippingPrice != 0)
            System.out.println("Shipping                " + shippingPrice);
        System.out.println("Amount                " + allItemTotalPrice);
        System.out.println("");


        checkCustomerBalance(customer, allItemTotalPrice);
        customer.setCart(cart);
    }


        private static void checkCustomerBalance(Customer customer, double allItemTotalPrice){
            double balance =  customer.getBalance();
            if (allItemTotalPrice > balance) throw new RuntimeException("Sorry, insufficient Balance " + " you have " + balance + " and total amount is " + allItemTotalPrice);

            balance = balance - allItemTotalPrice;
            customer.setBalance(balance);
        }

        private static double calcRecipt(Cart cart){

            Map<Product, Integer> cartMap = cart.getCartMap();
            double allItemTotalPrice = 0.0;

            System.out.println("\n** Checkout receipt ** ");
            for (var item : cartMap.entrySet()){
                int itemCount = item.getValue();
                double itemPrice = item.getKey().getPrice() ;
                double itemTotalPrice = itemPrice * itemCount;
                String itemName = item.getKey().getName();

                allItemTotalPrice += itemTotalPrice;
                System.out.println(itemCount+ "x " + itemName + "                " + itemTotalPrice);
            }

            return allItemTotalPrice;
        }


}
