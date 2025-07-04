import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private LocalDate expireDate;
    private Boolean isShippable;
    private Double weight;

    public Product(String name, double price, int quantity,
                   LocalDate expireDate, Boolean isShippable, Double weight) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expireDate = expireDate;
        this.isShippable = isShippable;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public Boolean getShippable() {
        return isShippable;
    }

    public void setShippable(Boolean shippable) {
        isShippable = shippable;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }


}
