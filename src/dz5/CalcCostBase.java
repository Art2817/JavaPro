package dz5;

// Клас розрахунку базової вартості товару
public class CalcCostBase {

    // Базовий розрахунок вартості товару

    // use getters getQuota() and getPrice() from Product
    public double calcCost(Product product) {
        return product.getQuota() * product.getPrice();
    }
}