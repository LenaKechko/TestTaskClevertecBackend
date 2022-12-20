package org.store.sale;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Cashier {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address_store")
    private String addressStore;

    public Cashier() {

    }

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
