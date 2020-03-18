package com.gmail.merikbest2015.JavaPRO.lec05.JpaHibernate.homework.hw02.tables;

import com.gmail.merikbest2015.JavaPRO.lec05.JpaHibernate.homework.hw02.tables.Account;
import com.gmail.merikbest2015.JavaPRO.lec05.JpaHibernate.homework.hw02.tables.Client;

import javax.persistence.*;

@Entity
@Table(name="Transactions")
public class Transaction {

    @Id //первичный ключ
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    //клиент кторый запросил транзакцию
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Client_id")
    private Client client; //у тарнзакции может быть только один клиент - заказчик

    //счет с которго снимаются деньги
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Accout_from_id")
    private Account from; //у тарнзакции может быть только один счет истоник

    //счет на который кладутся деньги
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Accout_too_id")
    private Account too; //у транзакции может быть только один счет приемник

    //валюта в которой происходит транзакция
    private String currency;

    //сумма транзакции
    private Double amount;

    //конвертация в валюту(если нет конвертации то null)
    private String convertationToo;

    //сумма после конвертации
    private Double amountAfterConvert;

    public Transaction() {
    }

    public Transaction(Client client, Account from, Account too, String currency, Double amount,
                       String convertationToo, Double amountAfterConvert) {
        this.client = client;
        this.from = from;
        this.too = too;
        this.currency = currency;
        this.amount = amount;
        this.convertationToo = convertationToo;
        this.amountAfterConvert = amountAfterConvert;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setFrom(Account from) {
        this.from = from;
    }

    public void setToo(Account too) {
        this.too = too;
    }

    public Long getId() {
        return id;
    }
}
