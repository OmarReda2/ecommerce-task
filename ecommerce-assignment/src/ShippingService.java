import java.util.Map;
import java.util.stream.Collectors;

public class ShippingService{
    public static double calcShipmentReciept(Map<Product,Integer> productMap) {

        Map<Product, Integer> ShippingProductMap = productMap.entrySet().stream()
                            .filter(product -> product.getKey().getShippable())
                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


        double shippingPrice = 0.0;
        if(!ShippingProductMap.isEmpty()){
            shippingPrice = 30.0;
            System.out.println("\n** Shipment notice **");


            double allItemTotalWeight = 0.0;
            for (var item : ShippingProductMap.entrySet()){
                int itemCount = item.getValue();
                double itemWeight = item.getKey().getWeight();
                double itemTotalWeight = itemWeight * itemCount;
                String itemName = item.getKey().getName();

                allItemTotalWeight += itemTotalWeight;
                System.out.println(itemCount+ "x " + itemName + "        " + itemTotalWeight);
            }

            if(allItemTotalWeight > 1000) System.out.println("Total package weight " + allItemTotalWeight/1000 + "kg");
            else System.out.println("Total package weight " + allItemTotalWeight + "g");


        }

        return shippingPrice;
    }



}
