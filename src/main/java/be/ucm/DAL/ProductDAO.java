package be.ucm.DAL;

import be.ucm.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private static int idAutoInc = 1;
    private ProductDAO (){
        products.add(new Product(idAutoInc++,"burger giant", 4.20, "délicieux burger avec 2 viandes et une super sauce. Miam !", "http://www.club-sandwich.net/images/photobreves/quick-giant.jpg"));
        products.add(new Product(idAutoInc++,"sushi saumon", 2.10, "délicieuse tranche de saumon sur son lit de riz", "https://www.nautiljon.com/images/recettes/00/51/sushi_saumon_shake_15.jpg?1558085352"));
        products.add(new Product(idAutoInc++,"pizza kiwi", 11.80, "pizza avec des tranches de kiwi dessus", "https://www.sudinfo.be/sites/default/files/dpistyles_v2/ena_sp_16_9_illustration_principale/2020/01/16/node_161836/42097802/public/2020/01/16/B9722244354Z.1_20200116100806_000+GE7FAB8HG.1-0.jpg?itok=lr0MAqcA1579165693"));
    }
    private static ProductDAO instance;
    public static ProductDAO getInstance(){
        if (instance == null){
            instance = new ProductDAO();
        }
        return instance;
    }

    // CECI VA SERVIR A SIMULER LA DB
    private List<Product> products = new ArrayList<>();

    public Product create(Product product){
        product.setId(idAutoInc++);
        products.add(product);
        return product;
    }

    public List<Product> read(){
        return products;
    }

    public Product read(Integer id){
        if (id == null){
            return null;
        }
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public Product update(Product product){
        Product p = read(product.getId());
        if (p != null){
            int index = products.indexOf(p);
            products.set(index, product); // OUI ?
            return product;
        }
        return null;
    }
    public boolean delete(Integer id){
        /*if (id == null){
            return false;
        }*/
        return products.removeIf(p -> p.getId().equals(id));
    }
}
