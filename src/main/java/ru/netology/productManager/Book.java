package ru.netology.productManager;

public class Book extends Product {
    private String author;

    public Book(String name, int price, int id, String author) {
        super(name, price, id);
        this.author = author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean matches(Product product, String search) {
        if (name.contains(search)) {
            return true;
        }
        if (author.contains(search)) {
            return true;
        }
        return false;
    }
}
