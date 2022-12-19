package org.store.sale;

import java.util.Arrays;
import java.util.List;

public abstract class CashierFactory {
    private static List<Cashier> cashierList = Arrays.asList(
            new Cashier(421, "Natalia Ivanova", "Sovetskaya, 4"),
            new Cashier(357, "Svetlana Petrova", "Kirova, 1"),
            new Cashier(946, "Elena Fedotova", "Mazurova, 17"));

    public static Cashier getCashier() {
        return cashierList.get((int) (Math.random() * cashierList.size()));
    }
}