import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> cartMap = new HashMap<>();

    public Map<Product, Integer> add(Product product, int quantityAdded){

        if(product.getExpireDate().isBefore(LocalDate.now())){ throw new RuntimeException("Product is Expired!");}

        int quantityAvailable = product.getQuantity();
        String productName = product.getName();

        if(quantityAvailable == 0){ throw new RuntimeException( "Sorry " + productName + " is Out of Stock"); }
        if (quantityAdded > quantityAvailable){ throw new RuntimeException(" Sorry " + " Quantity (" + quantityAdded + ") out of Stock! There is only " + quantityAvailable + " " + productName); }
        if(cartMap.containsKey(product)) { cartMap.put(product, cartMap.get(product) + quantityAdded);}
        else { cartMap.put(product,quantityAdded);}

        product.setQuantity(quantityAvailable - quantityAdded);
        System.out.println(quantityAdded + " of " + productName + " is added");
        return cartMap;
    }

    public Map<Product, Integer> getCartMap() {
        return cartMap;
    }

    public void setCartMap(Map<Product, Integer> cartMap) {
        this.cartMap = cartMap;
    }


}
