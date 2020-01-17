package be.ucm.controllers;

import be.ucm.DAL.ProductDAO;
import be.ucm.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    ProductDAO productDAO = ProductDAO.getInstance();

    @GetMapping("")
    public String index(Model model){
        List<Product> products = productDAO.read();
        model.addAttribute("products", products);
        return "product/index";
    }

    @GetMapping("/new")
    public String create(Model model){
        model.addAttribute("newProduct",new Product());
        return "product/add";
    }

    @PostMapping("/new")
    public ModelAndView create(@ModelAttribute(value = "newProduct") Product product){
        // faire un nouveau produit
        // ajouter à la "DB"
        productDAO.create(product);
        // rediriger vers la liste des produits
        return new ModelAndView("redirect:/product");
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Integer id, Model model){
        Product product = productDAO.read(id);
        // si l'id est null ou que aucun produit n'a cette id, on renvoie vers la vue qui affiche tous les produits
        if(product == null){
            return "redirect:/product";
        }
        model.addAttribute("product", product);
        return "product/details";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Integer id, Model model){
        if (id == null){
            return "redirect:/product";
        }
        Product product = productDAO.read(id);
        model.addAttribute("product", product);
        return "product/update";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute Product product, @PathVariable Integer id){
        // on vérifie qu'on a bien modifié le bon objet
        if (id.equals(product.getId())){
            productDAO.update(product);
        }
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        productDAO.delete(id);
        return "redirect:/product";
    }
}
