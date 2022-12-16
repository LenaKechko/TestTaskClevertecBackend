package org.store.sale;

public class Cashier {
    private int id;
    private String name;

    private String addressStore;

    public Cashier(int id, String name, String addressStore) {
        this.id = id;
        this.name = name;
        this.addressStore = addressStore;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getAddressStore() {
        return addressStore;
    }
}
