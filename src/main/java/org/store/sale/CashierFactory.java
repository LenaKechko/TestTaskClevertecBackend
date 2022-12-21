package org.store.sale;

import org.store.customer.DiscountCard;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class CashierFactory {
    /*работа с обычным списком*/
//    private static List<Cashier> cashierList = Arrays.asList(
//            new Cashier(421, "Natalia Ivanova", "Sovetskaya, 4"),
//            new Cashier(357, "Svetlana Petrova", "Kirova, 1"),
//            new Cashier(946, "Elena Fedotova", "Mazurova, 17"));

    /*данные из файла*/
    private static List<Cashier> cashierList = new ArrayList<>();

    static {
        File file = new File("Employee.txt");
        try (FileReader input = new FileReader(file)) {
            BufferedReader reader = new BufferedReader(input);
            String line = "";
            while ((line = reader.readLine()) != null) {
                String [] data = line.split("\\|");
                cashierList.add(new Cashier(Integer.parseInt(data[0]), data[1], data[2]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Cashier getCashier() {
        return cashierList.get((int) (Math.random() * cashierList.size()));
    }
}