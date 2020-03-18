package com.gmail.merikbest2015.JavaPRO.lec05.JpaHibernate.homework.hw02;

import com.gmail.merikbest2015.JavaPRO.lec05.JpaHibernate.homework.hw02.tables.Account;
import com.gmail.merikbest2015.JavaPRO.lec05.JpaHibernate.homework.hw02.tables.Client;
import com.gmail.merikbest2015.JavaPRO.lec05.JpaHibernate.homework.hw02.tables.Course;
import com.gmail.merikbest2015.JavaPRO.lec05.JpaHibernate.homework.hw02.tables.Transaction;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class MyBank implements Bank {

    private EntityManagerFactory emf; //фабрика
    private EntityManager em; //менеджер
    private Scanner sc;

    public void open() {
        emf = Persistence.createEntityManagerFactory("lec05hw02"); //из persistence.XML
        em = emf.createEntityManager();
        sc = new Scanner(System.in);
    }

    public void close() {
        em.close();
        emf.close();
        sc.close();
    }

    public void addClient() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter phone: ");
        String sPhone = sc.nextLine();
        int phone = Integer.parseInt(sPhone);
        System.out.print("Enter company: ");
        String company = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        em.getTransaction().begin(); // начинаем транзакцию
        try {
            Client client = new Client(name, phone, company, email);
            em.persist(client); //сохранить
            em.getTransaction().commit();//фиксировать
        } catch (Exception ex) {
            em.getTransaction().rollback();//откат
        }
    }

    public void removeClient() {
        System.out.print("Enter client id: ");
        String sId = sc.nextLine();
        long id = Long.parseLong(sId);
        Client client = em.find(Client.class, id); //ищем и парсим клиента, если не нашли вернется null
        if (client == null) {
            System.out.println("Client not found!");
            return;
        }
        if (client.getAccounts().size() > 0) {
            System.out.println("This client has one or more accounts!");
            System.out.println("You must remove all accounts before!");
            return;
        }
        em.getTransaction().begin(); //если нашли
        try {
            em.remove(client); //удаляем клиента
            em.getTransaction().commit(); //фиксируем
        } catch (Exception ex) {
            em.getTransaction().rollback();//откат
        }
    }

    public void addAccount() {
        System.out.print("Enter client id: ");
        String sId = sc.nextLine();
        long id = Long.parseLong(sId);
        Client client = em.find(Client.class, id); //ищем и парсим клиента, если не нашли вернется null
        if (client == null) {
            System.out.println("Client not found!");
            return;
        }
        System.out.println("Enter currency: ");
        System.out.println("1 - uan");
        System.out.println("2 - usd");
        System.out.println("3 - eur");
        String currency = sc.nextLine();
        switch (currency) {
            case "1":
                currency = "uan";
                break;
            case "2":
                currency = "usd";
                break;
            case "3":
                currency = "eur";
                break;
            default:
                System.out.println("Invalid currency!");
                return;
        }
        em.getTransaction().begin(); //у менеджера, начинаем транзакцию
        try {
            Account account = new Account(currency); //создае счет
            client.addAccount(account); //закрепляем счет за клиентом
            em.persist(account); //сохраняем изменения
            em.getTransaction().commit();//фиксировать
        } catch (Exception ex) {
            em.getTransaction().rollback();//откат
        }
    }

    public void removeAccount() {
        System.out.print("Enter account id: ");
        String sId = sc.nextLine();
        long id = Long.parseLong(sId);
        Account account = em.find(Account.class, id); //ищем и парсим счет, если не нашли вернется null
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        if (account.getAmount() != 0) {
            System.out.println("This account contain money, can not remove it!");
            return;
        }
        if (account.getTransactionsGet().size() > 0 || account.getTransactionsPut().size() > 0) {
            System.out.println("Some transactions use his account, can not remove it!");
            return;
        }
        em.getTransaction().begin(); //если нашли
        Client client = account.getClient();
        try {
            client.removeAccount(account); //удаляем счет из списка четов его владельца
            em.remove(account); //удаляем счет
            em.getTransaction().commit(); //фиксируем
        } catch (Exception ex) { //если что-то пошло не так
            System.out.println("error");
            client.addAccount(account); //возвращаем счет в список счетов его владельца
            em.getTransaction().rollback();//откат
        }
    }

    public void createTransaction() {
        // 1. Ввести id клиента запрашивающего транзакцию
        System.out.print("Enter client id: ");
        String clientIdS = sc.nextLine();
        long clientId = Long.parseLong(clientIdS);
        Client client = em.find(Client.class, clientId); //ищем и парсим клиента, если не нашли вернется null
        if (client == null) { //если клиента не существует
            System.out.println("Client not found!");
            return;
        }
        System.out.println("1 - put money too account");
        System.out.println("2 - get money from account");
        System.out.println("3 - transfer money account-account");
        String answer = sc.nextLine();
        switch (answer) {
            case "1":
                putAngGetTransaction(client, "put");
                break;
            case "2":
                putAngGetTransaction(client, "get");
                break;
            case "3":
                transferTransaction(client);
                break;
        }
    }

    //добавление/снятие денег
    private void putAngGetTransaction(Client client, String putOrGet) {
        //ввести номер счета на который нужно положить\cнять деньги
        System.out.print("Enter account id: ");
        String accountIdS = sc.nextLine();
        if (accountIdS.isEmpty()) { //если ввод пустой
            System.out.println("Empty enter!");
            return;
        }
        long accountId = Long.parseLong(accountIdS);
        Account account = em.find(Account.class, accountId); //ищем и парсим счет, если не нашли вернется null
        //проверка существования счета
        if (account == null) {
            System.out.println("Account not found!");
            return;
        }
        //определяем валюту в которой хранятся деньги на счету
        String currency = account.getCurrency();
        //ввод суммы
        System.out.println("Enter transaction amount in " + currency);
        String amountS = sc.nextLine();
        Double amount = Double.parseDouble(amountS);
        //проверка что введенная сумма больше 0
        if (amount < 0) {
            System.out.println("amount must be > 0");
            return;
        }
        //проверка что на чсету хрнится нужная сумма
        if (putOrGet.equals("get") && amount > account.getAmount()) {
            System.out.println("Account is not contain this amount");
            return;
        }
        //проводим операцию перевода средств в базе и занесение записи о новой транзакции
        em.getTransaction().begin(); //начинаем транзакцию
        try {
            Transaction transaction = null;
            if (putOrGet.equals("put")) {
                account.setAmount(account.getAmount() + amount); //добавляем деньги на счет
                transaction = new Transaction(client, null, account, currency, amount, currency, amount); //создаем транзакцию
                account.addTransactionPut(transaction); //добавляем ссылку на транзакцию в счет
            }
            if (putOrGet.equals("get")) {
                account.setAmount(account.getAmount() - amount); //снимаем деньги со счета
                transaction = new Transaction(client, account, null, currency, amount, currency, amount); //создаем транзакцию
                account.addTransactionGet(transaction); //добавляем ссылку на транзакцию в счет
            }
            client.addTransaction(transaction); //добавляем ссылку на транзакцию клиенту
            em.persist(account); //сохранить
            em.persist(transaction);  //сохранить
            em.getTransaction().commit();//фиксировать
        } catch (Exception ex) {
            em.getTransaction().rollback();//откат
        }
    }

    //перевод денег со счета на счет + конвертация по курсу
    private void transferTransaction(Client client) {
        //ввести номер счета с которого нужно снять деньги
        System.out.print("Enter account id from : ");
        String accountIdFromS = sc.nextLine();
        if (accountIdFromS.isEmpty()) { //если ввод пустой
            System.out.println("Empty enter!");
            return;
        }
        long accountIdFrom = Long.parseLong(accountIdFromS);
        Account accountFrom = em.find(Account.class, accountIdFrom); //ищем и парсим счет, если не нашли вернется null
        //проверка существования счета
        if (accountFrom == null) {
            System.out.println("Account not found!");
            return;
        }
        //проверяем, является ли клиент запрашивающий снятие средств со счета владельцем этого счсета
        if (!client.getAccounts().contains(accountFrom)) {
            System.out.println("Client is not account holder!");
            return;
        }
        //ввести номер счета на который нужно положить деньги
        System.out.print("Enter account id too: ");
        String accountIdTooS = sc.nextLine();
        if (accountIdTooS.isEmpty()) { //если ввод пустой
            System.out.println("Empty enter!");
            return;
        }
        long accountIdToo = Long.parseLong(accountIdTooS);
        Account accountToo = em.find(Account.class, accountIdToo); //ищем и парсим счет, если не нашли вернется null
        //проверка существования счета
        if (accountToo == null) {
            System.out.println("Account not found!");
            return;
        }
        //определяем валюту в которой хранятся деньги на счету для снятия
        String currencyFrom = accountFrom.getCurrency();
        //ввод суммы для перевода в валюте счета для снятия
        System.out.println("Enter transaction amount in " + currencyFrom);
        String amountS = sc.nextLine();
        Double amount = Double.parseDouble(amountS);
        //проверка что введенная сумма больше 0
        if (amount < 0) {
            System.out.println("amount must be > 0");
            return;
        }
        //проверка что на счету имеется такая сумма денег
        double accountFromAmount = accountFrom.getAmount();
        if (accountFromAmount < amount) {
            System.out.println("Account is not contain this amount");
            return;
        }
        //данные о конвертации, если она необходима
        Double rate = 1.0; //курс для конвертации
        Double amountAfterConvert = amount; //сумма после конвертации
        //определяем валюту в которой хранятся деньги на счету для для зачисления
        String currencyToo = accountToo.getCurrency();
        if (!currencyFrom.equals(currencyToo)) { //если счета в разных валютах
            rate = findRate(currencyFrom, currencyToo);
            if (rate == 0.0) {
                return;
            }
            System.out.println("Money will be convert from " + currencyFrom + " to " + currencyToo + ". Current rate is " + rate);
            System.out.println("Do you want continue? (y/n)");
            String answer = sc.nextLine();
            if (!answer.equals("y")) {
                return;
            }
            amountAfterConvert = amount * rate;
        }
        //проводим операцию перевода средств в базе и занесение записи о новой транзакции
        em.getTransaction().begin(); //начинаем транзакцию
        try {
            accountFrom.setAmount(accountFrom.getAmount() - amount);
            accountToo.setAmount(accountToo.getAmount() + amountAfterConvert);
            Transaction transaction = new Transaction(client, accountFrom, accountToo, currencyFrom, amount, currencyToo, amountAfterConvert);
            accountFrom.addTransactionGet(transaction); //добавляем ссылку на транзакцию в счет
            accountToo.addTransactionPut(transaction); //добавляем ссылку на транзакцию в счет
            client.addTransaction(transaction); //добавляем ссылку на транзакцию клиенту
            em.persist(accountFrom); //сохранить
            em.persist(accountToo); //сохранить
            em.persist(transaction);  //сохранить
            em.getTransaction().commit();//фиксировать
        } catch (Exception ex) {
            em.getTransaction().rollback();//откат
        }
    }

    public void showAllAmountOfClient() {
        System.out.print("Enter client id: ");
        String clientIdS = sc.nextLine();
        long clientId = Long.parseLong(clientIdS);
        Client client = em.find(Client.class, clientId); //ищем и парсим клиента, если не нашли вернется null
        if (client == null) { //если клиента не существует
            System.out.println("Client not found!");
            return;
        }
        System.out.println("Show all amount in: ");
        System.out.println("1 - uan: ");
        System.out.println("2 - usd: ");
        System.out.println("3 - eur: ");
        String convertTo = sc.nextLine();
        switch (convertTo) {
            case "1":
                convertTo = "uan";
                break;
            case "2":
                convertTo = "usd";
                break;
            case "3":
                convertTo = "eur";
                break;
        }
        Double allAmount = 0.0;
        List<Account> accounts = client.getAccounts();
        for (Account account : accounts) {
            double accountAmount = account.getAmount();
            if (!account.getCurrency().equals(convertTo)) {
                accountAmount = accountAmount * findRate(account.getCurrency(), convertTo);
            }
            allAmount = allAmount + accountAmount;
        }
        System.out.println("All amount in " + convertTo + " is: " + allAmount);
    }

    private double findRate(String Currency1, String Currency2) {
        //определяем курс валют для конвертации
        Course course = null;
        try {
            Query query = em.createQuery("SELECT c FROM Course c WHERE c.currency = :currency", Course.class);
            query.setParameter("currency", Currency1); //передать параметр "name"
            course = (Course) query.getSingleResult(); //получить результат (ожидаем один результат)
        } catch (NoResultException ex) { //если результата нет
            System.out.println("Course not found!");
            return 0.0;
        } catch (NonUniqueResultException ex) { //если результат не один
            System.out.println("Non unique result!");
            return 0.0;
        }
        switch (Currency2) {
            case "usd":
                return course.getUsd();
            case "eur":
                return course.getEur();
            case "uan":
                return course.getUan();
            default:
                return 0.0;
        }
    }

    //установить курс валют
    public void setCurrencyCourse() {
        em.getTransaction().begin(); //начинаем транзакцию
        try {///////////////////////       usd    eur     uan
            Course usd = new Course("usd", 1.0, 0.8888, 26.5555);
            Course eur = new Course("eur", 1.1251, 1.0, 29.8776);
            Course uan = new Course("uan", 0.0377, 0.0335, 1.0);
            em.persist(usd); //сохранить
            em.persist(eur); //сохранить
            em.persist(uan); //сохранить
            em.getTransaction().commit();//фиксировать
        } catch (Exception ex) {
            em.getTransaction().rollback();//откат
        }
    }
}
