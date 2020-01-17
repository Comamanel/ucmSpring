package be.ucm.models;

public class Product {
    private Integer id;
    private String name;
    private double price;
    private String description;
    private String image;

    public Product(){
        //id = idAutoInc++;
    }
    //private static int idAutoInc = 1;
    public Product(String name, double price, String description, String image) {
        //this.id = idAutoInc++;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
    }
    // constructeur pour la récupération
    public Product(Integer id, String name, double price, String description, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
