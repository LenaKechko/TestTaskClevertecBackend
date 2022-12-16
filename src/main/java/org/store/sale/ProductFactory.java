package org.store.sale;

import java.util.Arrays;
import java.util.List;

public abstract class ProductFactory {
    private static List<Product> productList = Arrays.asList(new Product(1, "milk", 1.26),
            new Product(2, "bread", 1.01),
            new Product(3, "butter", 2.5, true),
            new Product(4, "salt", 0.9),
            new Product(5, "meat", 5.7, true),
            new Product(6, "sugar", 2.3, true),
            new Product(7, "sausage", 4.38),
            new Product(8, "egg", 2.89));
    /*позже здесь будет формироваться лист из бд*/
    public static Product getProduct(int id) {
        try {
            return productList.stream()
                    .filter(product -> product.getId() == id)
                    .findFirst()
                    .get();
        } catch (NullPointerException exception){
            return null;
        }
    }



}
