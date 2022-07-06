package ru.netology.productManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ProductManagerTest {

    Book bookFirst = new Book("Цвет иных миров", 1500, 476, "Говард Филлипс Лавкрафт");
    Book bookSecond = new Book("Скотный двор", 1200, 502, "Джордж Оруэлл");
    Book bookThird = new Book("Зеленая миля", 1350, 178, "Стивен кинг");

    Smartphone phoneFirst = new Smartphone("Galaxy", 23000, 105, "Samsung");
    Smartphone phoneSecond = new Smartphone("Xperia", 18000, 016, "Sony");
    Smartphone phoneThird = new Smartphone("Iphone", 72000, 351, "Apple");


    @Test
    public void findAllTest() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);

        manager.add(bookFirst);
        manager.add(bookSecond);
        manager.add(bookThird);
        manager.add(phoneFirst);
        manager.add(phoneSecond);
        manager.add(phoneThird);

        Product[] actual = manager.getAll();
        Product[] expected = {bookFirst, bookSecond, bookThird, phoneFirst, phoneSecond, phoneThird};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findRemoveByIdWithExistingIdTest() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);

        manager.add(bookFirst);
        manager.add(bookSecond);
        manager.add(bookThird);
        manager.add(phoneFirst);
        manager.add(phoneSecond);
        manager.add(phoneThird);

        manager.removeById(105);

        Product[] actual = manager.getAll();
        Product[] expected = {bookFirst, bookSecond, bookThird, phoneSecond, phoneThird};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findRemoveByIdWithNotExistingIdTest() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);

        manager.add(bookFirst);
        manager.add(bookSecond);
        manager.add(bookThird);
        manager.add(phoneFirst);
        manager.add(phoneSecond);
        manager.add(phoneThird);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(106);
        });
    }

    @Test
    public void findByEngTest() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);

        manager.add(bookFirst);
        manager.add(bookSecond);
        manager.add(bookThird);
        manager.add(phoneFirst);
        manager.add(phoneSecond);
        manager.add(phoneThird);

        Product[] actual = manager.searchBy("on");
        Product[] expected = {phoneSecond, phoneThird};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findByRusTest() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);

        manager.add(bookFirst);
        manager.add(bookSecond);
        manager.add(bookThird);
        manager.add(phoneFirst);
        manager.add(phoneSecond);
        manager.add(phoneThird);

        Product[] actual = manager.searchBy("ин");
        Product[] expected = {bookFirst, bookThird};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void productWithMatchesTest() {

        Product product = new Product("Цвет иных миров", 1500, 476);

        boolean actual = product.matches(product, "ин");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void productWithNotMatchesTest() {

        Product product = new Product("Цвет иных миров", 1500, 476);

        boolean actual = product.matches(product, "он");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void findByIdPositiveTest() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);

        manager.add(bookFirst);
        manager.add(bookSecond);
        manager.add(bookThird);

        Product actual = repo.findById(502);
        Product expected = bookSecond;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void findByIdNegativeTest() {
        Repository repo = new Repository();
        ProductManager manager = new ProductManager(repo);

        manager.add(bookFirst);
        manager.add(bookSecond);
        manager.add(bookThird);

        Product actual = repo.findById(501);
        Product expected = null;

        Assertions.assertEquals(expected, actual);

    }

}

