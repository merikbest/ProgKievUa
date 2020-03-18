package com.gmail.merikbest2015.JavaPRO.lec05.JpaHibernate.homework.hw02;

public interface Bank {
    public void open();
    public void close();
    public void addClient();
    public void removeClient();
    public void addAccount();
    public void removeAccount();
    public void createTransaction();
    public void showAllAmountOfClient();
    public void setCurrencyCourse();
}