package com.gmail.merikbest2015.JavaPRO.lec05.JpaHibernate.homework.hw02.tables;

import javax.persistence.*;

@Entity//сущность из базы данных
@Table(name="Courses") //в какой таблице хранятся обьекты класса (если не указано = название класса )
public class Course {

    @Id //первичный ключ
    @GeneratedValue(strategy = GenerationType.AUTO) //статегия генерации ключей
    @Column(nullable = false) //поле связано с колонкой
    private Long id;

    //валюты
    @Column(nullable = false, unique = true)
    private String currency;

    //валюты
    @Column(nullable = false)
    private Double usd;
    @Column(nullable = false)
    private Double eur;
    @Column(nullable = false)
    private Double uan;

    public Course() {
    }

    public Course(String currency, Double usd, Double eur, Double uan) {
        this.currency = currency;
        this.usd = usd;
        this.eur = eur;
        this.uan = uan;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", currency='" + currency + '\'' +
                ", usd=" + usd +
                ", eur=" + eur +
                ", uan=" + uan +
                '}';
    }

    public Double getUsd() {
        return usd;
    }

    public Double getEur() {
        return eur;
    }

    public Double getUan() {
        return uan;
    }
}
