package org.store.sale;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class ProductFactory {
    /*Без подключения бд имелся следующий список продуктов*/
//    private static List<Product> productList = Arrays.asList(new Product(1, "milk", 1.26),
//            new Product(2, "bread", 1.01),
//            new Product(3, "butter", 2.5, true),
//            new Product(4, "salt", 0.9),
//            new Product(5, "meat", 5.7, true),
//            new Product(6, "sugar", 2.3, true),
//            new Product(7, "sausage", 4.38),
//            new Product(8, "egg", 2.89));

    /*работа с файлом*/
    private static List<Product> productList = new ArrayList<>();

    static {
        File file = new File("Product.txt");
        try (FileReader input = new FileReader(file)) {
            BufferedReader reader = new BufferedReader(input);
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length > 3) {
                    productList.add(new Product(Integer.parseInt(data[0]), data[1],
                            Double.parseDouble(data[2]), Boolean.parseBoolean(data[3])));
                } else {
                    productList.add(new Product(Integer.parseInt(data[0]), data[1],
                            Double.parseDouble(data[2])));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static Product getProduct(int id) {
        try {
            return productList.stream()
                    .filter(product -> product.getId() == id)
                    .findFirst()
                    .get();
        } catch (NullPointerException | NoSuchElementException e) {
            return null;
        }
    }
}
