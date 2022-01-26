package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {


    @Test
    public void shouldHaveMethodsFromSuper() {
        Smartphone smartphone = new Smartphone();
    }

    @Test
    public void shouldUseEquals() {
        Smartphone first = new Smartphone(1, "Nokia 3310", 10000, "Nokia");
        Smartphone second = new Smartphone(1, "Nokia 3310", 10000, "Nokia");
        assertEquals(first, second);
    }


    @Test
    public void shouldInstallManufacture() {
        Smartphone smartphone = new Smartphone(null);
        smartphone.setManufacture("Fabric");
        String expected = "Fabric";
        String actual = smartphone.getManufacture();
        assertEquals(expected, actual);
    }
}