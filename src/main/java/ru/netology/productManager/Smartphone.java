package ru.netology.productManager;

public class Smartphone extends Product{
    private String fabricator;

    public Smartphone(String name, int price, int id, String fabricator)
    {
        super(name, price, id);
        this.fabricator = fabricator;
    }

    public void setFabricator(String fabricator)
    {
        this.fabricator = fabricator;
    }

    public String getFabricator(){
        return fabricator;
    }

    @Override
    public boolean matches(Product product, String search) {
        if (name.contains(search)) {
            return true;
        }
        if (fabricator.contains(search)) {
            return true;
        }
        return false;
    }
}
