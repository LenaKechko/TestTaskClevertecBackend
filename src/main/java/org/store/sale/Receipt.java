package org.store.sale;

import org.store.customer.Basket;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Receipt {
    private static Date date = new Date();
    private Basket basket = null;
    private Cashier cashier = null;
    private String bill = "              CASH RECEIPT\n";

    public Receipt(Basket basket) {
        this.basket = basket;
        cashier = CashierFactory.getCashier();
        bill += "              " + cashier.getAddressStore() + "\n              CASHIER:" + cashier.getId() + "\n";
    }

    public String getDate() {
        SimpleDateFormat formatterForDate = new SimpleDateFormat("dd/MM/yyyy");
        return formatterForDate.format(date);
    }

    public String getTime() {
        SimpleDateFormat formatterForTime = new SimpleDateFormat("HH:mm:ss");
        return formatterForTime.format(date);
    }

    public String construct() {
        bill += "   DATE: " + getDate() + "      TIME: " + getTime() + "\n\n";
        bill += String.format("%4s %-22s %7s %7s\n\n", "QTY", "DESCRIPTION", "PRICE", "TOTAL");
        basket.costBasket();
        bill += basket.printBill();
        for (int i = 0; i < 43; i++)
            bill += "-";
        bill += String.format("\n  Taxable: %32.2f\n", basket.getTotal());
        bill += String.format("  Tax:     %32.2f\n", basket.getTotalTax());
        bill += String.format("  TOTAL:   %32.2f", basket.getFinalTotal());
        return bill;
    }

    public static void printReceipt(String bill) {
        try (FileWriter output = new FileWriter("Result Bill.txt", false)) {
            output.write(bill);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
