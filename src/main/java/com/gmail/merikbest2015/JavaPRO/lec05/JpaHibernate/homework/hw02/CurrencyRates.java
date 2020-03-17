package com.gmail.merikbest2015.JavaPRO.lec05.JpaHibernate.homework.hw02;


import javax.persistence.*;

@Entity
@Table(name = "currency_rate")
public class CurrencyRates {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double usdRate;
    private double eurRate;

    @ManyToOne
    @JoinColumn(name = "bankAccount_id")
    private BankAccount bankAccount;

    public CurrencyRates() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getUsdRate() {
        return usdRate;
    }

    public void setUsdRate(double usdRate) {
        this.usdRate = usdRate;
    }

    public double getEurRate() {
        return eurRate;
    }

    public void setEurRate(double eurRate) {
        this.eurRate = eurRate;
    }
}
