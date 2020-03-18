package com.gmail.merikbest2015.JavaPRO.lec05.JpaHibernate.homework.hw02.tables;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Clients")
public class Client{

    @Id //первичный ключ
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer phone;

    private String company;

    private String email;

    //обратная связь с Account
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL) //связано с полем client в классе Account
    private List<Account> accounts = new ArrayList<>(); //у клиента может быть много счетов

    //обратная связь с Transaction
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL) //связано с полем client в классе Transaction
    private List<Transaction> transactions = new ArrayList<>(); //у клиента может быть много транзакций

    public Client() {
    }

    public Client(String name, Integer phone) {
        this.name = name;
        this.phone = phone;
    }

    public void addAccount(Account account){
        account.setClient(this);
        accounts.add(account);
    }

    public void removeAccount(Account account){
        for (int i = 0; i < accounts.size(); i++){
            Account ac = accounts.get(i);
            if(ac.getId()==account.getId()){
                accounts.remove(i);
                return;
            }
        }
    }

    public void addTransaction(Transaction transaction){
        transaction.setClient(this);
        transactions.add(transaction);
    }

    public Client(String name, Integer phone, String company, String email) {
        this.name = name;
        this.phone = phone;
        this.company = company;
        this.email = email;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", company='" + company + '\'' +
                ", email='" + email + '\'' +
                ", accounts=" + accounts +
                ", transactions=" + transactions +
                '}';
    }
}
