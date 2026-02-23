package dz17;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.0),
                new Product("Coffee Maker", "Appliances", 80.0),
                new Product("Headphones", "Electronics", 150.0),
                new Product("Blender", "Appliances", 50.0)
        );

        Map<String, Double> result = products.stream()
                .collect(Collectors.groupingBy
                        (Product::getCategory, Collectors.averagingDouble(Product::getPrice))
                );

        System.out.println("Average price by category: " + result);

        String maxCategory = null;
        double maxAverage = Double.MIN_VALUE;

        for (Map.Entry<String, Double> entry : result.entrySet()) {
            if (entry.getValue() > maxAverage) {
                maxAverage = entry.getValue();
                maxCategory = entry.getKey();
            }
        }

        System.out.println("Category with highest average price: " + maxCategory + " (" + maxAverage + ")");
    }
}
