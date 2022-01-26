package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repositiry.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    Product first = new Book(1, "Fight Club", 500, "Chuck Palahniuk");
    Product second = new Book(2, "1984", 550, "George Orwell");
    Product third = new Smartphone(3, "3310", 3000, "Nokia");
    Product fourth = new Smartphone(4, "Galaxy S22", 80000, "Samsung");
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }

    @Test
    public void shouldAddNewItem() {
        manager.add(first);
        Product[] expected = new Product[]{first};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfIncludeNameInBook() {
        setUp();
        Product[] expected = new Product[]{first};
        Product[] actual = manager.searchBy("Fight Club");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfIncludeNameInSmartphone() {
        setUp();
        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("3310");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfIncludeAuthorInBook() {
        setUp();
        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("George Orwell");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfIncludeNotFullAuthorNameInBook() {
        setUp();
        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Orwell");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfIncludeManufactureInSmartphone() {
        setUp();
        Product[] expected = new Product[]{fourth};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }


}