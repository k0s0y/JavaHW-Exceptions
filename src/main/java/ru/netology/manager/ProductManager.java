package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.repositiry.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public Product[] getAll() {
        return repository.getAll();
        }


    public void add(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.getAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) { // если в параметре product лежит объект класса Book
            Book book = (Book) product; // положем его в переменную типа Book чтобы пользоваться методами класса Book
            if (book.getName().contains(search)) { // проверим есть ли поисковое слово в данных об названии
                return true;
            }
            if (book.getAuthor().contains(search)) { // проверим есть ли поисковое слово в данных об авторе
                return true;
            }
            return false;
        }
        if (product instanceof Smartphone) { // если в параметре product лежит объект класса Smartphone
            Smartphone smartphone = (Smartphone) product; // положем его в переменную типа Book чтобы пользоваться методами класса Smartphone
            if (smartphone.getName().contains(search)) { // проверим есть ли поисковое слово в названии
                return true;
            }
            if (smartphone.getManufacture().contains(search)) { // проверим есть ли поисковое слово в данных о марке
                return true;
            }

        }
        return false;
    }
}
