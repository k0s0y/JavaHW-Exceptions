package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product {
    private String manufacture;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String manufacture) {
        super(id, name, price);
        this.manufacture = manufacture;
    }

    public Smartphone(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return Objects.equals(manufacture, that.manufacture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), manufacture);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "price=" + price +
                ", manufacture='" + manufacture + '\'' +
                '}';
    }
}
