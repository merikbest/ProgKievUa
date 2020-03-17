package com.gmail.merikbest2015.JavaPRO.lec05.JpaHibernate.homework.hw02;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bank_account")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int usdQuantity;
    private int eurQuantity;
    private int uahQuantity;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "bankAccount")
    private Set<CurrencyRates> currencyRates = new HashSet<>();

    public BankAccount() {
    }

    public BankAccount(int usdQuantity, int eurQuantity, int uahQuantity, Client client) {
        this.usdQuantity = usdQuantity;
        this.eurQuantity = eurQuantity;
        this.uahQuantity = uahQuantity;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsdQuantity() {
        return usdQuantity;
    }

    public void setUsdQuantity(int usdQuantity) {
        this.usdQuantity = usdQuantity;
    }

    public int getEurQuantity() {
        return eurQuantity;
    }

    public void setEurQuantity(int eurQuantity) {
        this.eurQuantity = eurQuantity;
    }

    public int getUahQuantity() {
        return uahQuantity;
    }

    public void setUahQuantity(int uahQuantity) {
        this.uahQuantity = uahQuantity;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
