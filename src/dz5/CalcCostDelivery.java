package dz5;

// Клас розрахунку вартості товару, враховуючи вартість доставки
// Клас успадковує клас CalcCostBase

// use Inheritance (extends)
public class CalcCostDelivery extends CalcCostBase {

    //Delivery is taken as constant
    private final static double DELIVERY_PRICE = 7.0;

    // Розрахунок вартості товару, з урахуванням вартості доставки
    @Override
    public double calcCost(Product product) {

        //use getters getQuota() and getPrice() from Product and constant
        return product.getQuota() * product.getPrice() + DELIVERY_PRICE;

        // we can also use superclass
        // return super.calcCost(product) + DELIVERY_PRICE;
    }
}