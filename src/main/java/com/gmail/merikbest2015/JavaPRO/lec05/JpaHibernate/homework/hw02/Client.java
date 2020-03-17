package com.gmail.merikbest2015.JavaPRO.lec05.JpaHibernate.homework.hw02;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "client")
    private Set<BankAccount> bankAccountSet = new HashSet<>();

    public Client() {
    }

    public Client(String firstName, String lastName, Set<BankAccount> bankAccountSet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bankAccountSet = bankAccountSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<BankAccount> getBankAccountSet() {
        return bankAccountSet;
    }

    public void setBankAccountSet(Set<BankAccount> bankAccountSet) {
        this.bankAccountSet = bankAccountSet;
    }
}
