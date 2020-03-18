package com.gmail.merikbest2015.JavaPRO.lec05.JpaHibernate.homework.hw02.tables;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Accounts")
public class Account {

    @Id //первичный ключ
    @GeneratedValue(strategy = GenerationType.AUTO) //статегия генерации ключей
    @Column(nullable = false)
    private Long id;

    //владелец счета
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="client_id")
    private Client client;

    //валюта счета EUR USD UAN
    private String currency;

    //количество денег на счете
    private Double amount = 0.0;

    //обратная связь c Transaction, ссылки на транзакции кторые снимали деньги со счета
    @OneToMany(mappedBy = "from", cascade = CascadeType.ALL) //связано с полем from в классе transaction
    private List<Transaction> transactionsGet = new ArrayList<>(); //cо счета можно много раз снимать

    //обратная связь c Transaction, ссылки на транзакции кторые добавляли деньги на счет
    @OneToMany(mappedBy = "too", cascade = CascadeType.ALL) //связано с полем too в too transaction
    private List<Transaction> transactionsPut = new ArrayList<>(); //на счет можно много раз ложить

    public Account() {
    }

    public Account(String currency) {
        this.currency = currency;
    }


    public void addTransactionPut(Transaction transaction){
        transaction.setToo(this);
        transactionsPut.add(transaction);
    }

    public void addTransactionGet(Transaction transaction){
        transaction.setFrom(this);
        transactionsGet.add(transaction);
    }

    public Client getClient() {
        return client;
    }

    public String getCurrency() {
        return currency;
    }

    public Long getId() {
        return id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public List<Transaction> getTransactionsGet() {
        return transactionsGet;
    }

    public List<Transaction> getTransactionsPut() {
        return transactionsPut;
    }
}
