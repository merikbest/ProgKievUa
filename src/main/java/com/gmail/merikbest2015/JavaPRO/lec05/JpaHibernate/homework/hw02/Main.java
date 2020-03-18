package com.gmail.merikbest2015.JavaPRO.lec05.JpaHibernate.homework.hw02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Bank bank = new MyBank();
        Scanner scanner = new Scanner(System.in);
        try {
            bank.open();
            bank.setCurrencyCourse();
            while (true) {
                System.out.println("1 - addClient");
                System.out.println("2 - addAccount");
                System.out.println("3 - removeClient");
                System.out.println("4 - removeAccount");
                System.out.println("5 - createTransaction");
                System.out.println("6 - show all amount of client");
                System.out.println("7 - EXIT");
                String answer = scanner.nextLine();
                switch (answer){
                    case "1":
                        bank.addClient();
                        break;
                    case "2":
                        bank.addAccount();
                        break;
                    case "3":
                        bank.removeClient();
                        break;
                    case "4":
                        bank.removeAccount();
                        break;
                    case "5":
                        bank.createTransaction();
                        break;
                    case "6":
                        bank.showAllAmountOfClient();
                        break;
                    case "7":
                        return;
                }
            }
        }
        finally {
            bank.close();
            scanner.close();
        }
    }
}
