package ru.netology.domain;

import java.util.Objects;

public class Product {
    private int id;
    private String name;
    public int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) { //переопределяем поведение метода класса object
        if (this == o) return true; //ссылки совпадают - тру
        if (o == null || getClass() != o.getClass()) return false; // сравниваем класс
        Product product = (Product) o; //кастуем в продукт
        return id == product.id && price == product.price && Objects.equals(name, product.name); //попарное сравнение полей
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
