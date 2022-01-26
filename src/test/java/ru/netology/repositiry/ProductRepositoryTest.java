package ru.netology.repositiry;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NegativeIdException;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    Product first = new Book(1, "Fight Club", 500, "Chuck Palahniuk");
    Product second = new Book(2, "1984", 550, "George Orwell");
    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book();

    @Test
    public void shouldSaveOneItem() {
        repository.save(coreJava);
        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGiveExceptionIfDoseNotRemoveById() {
        repository.save(first);
        repository.save(second);
        assertThrows(NotFoundException.class,()->repository.removeById(3));
    }

    @Test
    public void shouldFindById() {
        repository.save(first);
        repository.save(second);
        Product[] expected = new Product[]{first};
        Product[] actual = new Product[]{repository.findById(1)};
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldGiveExceptionIfDoseNotFindById() {
        repository.save(first);
        repository.save(second);
        assertThrows(NotFoundException.class, ()->{repository.findById(3);});
    }

    @Test
    public void shouldGiveExceptionIfNegativeValueInSearch() {
        repository.save(first);
        repository.save(second);
        assertThrows(NegativeIdException.class, ()->{repository.removeById(-1);});
    }

    @Test
    public void shouldRemoveById() {
        repository.save(first);
        repository.save(second);
        repository.removeById(1);
        Product[] expected = new Product[]{second};
        Product[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRepositoryTest that = (ProductRepositoryTest) o;
        return Objects.equals(first, that.first) && Objects.equals(second, that.second) && Objects.equals(repository, that.repository) && Objects.equals(coreJava, that.coreJava);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, repository, coreJava);
    }

    @Override
    public String toString() {
        return "ProductRepositoryTest{" +
                "first=" + first +
                ", second=" + second +
                ", repository=" + repository +
                ", coreJava=" + coreJava +
                '}';
    }
}