package model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class Fruits
{
    @Size(min=1,max=10,message = "{fruits.name.length.error}")
    private String name;
    private double price;
    @NotEmpty(message = "{fruits.producing_area.isEmpty}")
    private String producing_area;
    private int id;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProducing_area() {
        return producing_area;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProducing_area(String producing_area) {
        this.producing_area = producing_area;
    }
}
