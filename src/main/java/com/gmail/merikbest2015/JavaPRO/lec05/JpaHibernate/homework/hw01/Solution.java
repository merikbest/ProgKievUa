package com.gmail.merikbest2015.JavaPRO.lec05.JpaHibernate.homework.hw01;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static EntityManagerFactory emf;
    static EntityManager em;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            emf = Persistence.createEntityManagerFactory("JPATest");
            em = emf.createEntityManager();
            try {
                while (true) {
                    System.out.println("1: Добавить блюдо в меню");
                    System.out.println("2: Выбрать блюдо по стоимости");
                    System.out.println("3: Выбрать все блюда со скидкой");
                    System.out.print("-> ");

                    String s = sc.nextLine();
                    switch (s) {
                        case "1":
                            addDish(sc);
                            break;
                        case "2":
                            getDishByPrice(sc);
                            break;
                        case "3":
                            getDishWithDiscount();
                            break;
                        default:
                            return;
                    }
                }
            } finally {
                sc.close();
                em.close();
                emf.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }

    private static void addDish(Scanner scanner) {
        System.out.print("Введите через пробел: ");
        System.out.println("имя блюда, цену блюда, вес блюда(в граммах), скида(да/нет)");
        String line = scanner.nextLine();
        String[] menu = line.split(" ");
        em.getTransaction().begin();
        try {
            RestaurantMenu restaurantMenu = new RestaurantMenu(menu[0], Integer.parseInt(menu[1]), Integer.parseInt(menu[2]), menu[3]);
            em.persist(restaurantMenu);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    private static void getDishByPrice(Scanner scanner) {
        System.out.print("Введите стоимость от: ");
        int fromPrice = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите стоимость до: ");
        int toPrice = Integer.parseInt(scanner.nextLine());
        try {
            Query query = em.createQuery("SELECT rm FROM RestaurantMenu rm WHERE rm.dishPrice >= :fromPrice AND rm.dishPrice <= :toPrice", RestaurantMenu.class);
            query.setParameter("fromPrice", fromPrice);
            query.setParameter("toPrice", toPrice);
            List<RestaurantMenu> menuList = query.getResultList();
            for (RestaurantMenu menu : menuList) {
                System.out.println(menu);
            }
        } catch (NoResultException ex) {
            System.out.println("Dish not found!");
            return;
        } catch (NonUniqueResultException ex) {
            System.out.println("Non unique result!");
            return;
        }
    }

    private static void getDishWithDiscount() {
        Query query = em.createQuery("SELECT rm FROM RestaurantMenu rm WHERE rm.discount = 'да'", RestaurantMenu.class);
        List<RestaurantMenu> discountDishList = query.getResultList();
        for (RestaurantMenu discountDish : discountDishList) {
            System.out.println(discountDish);
        }
    }
}