package com.adminPanel.app.controller;

import com.adminPanel.app.entity.Product;
import com.adminPanel.app.entity.ProductDetails;
import com.adminPanel.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid ;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService  productService ;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService ;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    @GetMapping
    public String listProducts(Model model){
        model.addAttribute("products" , productService.getProducts());
        return "product-list";
    }

    @GetMapping("/{id}")
    public String viewProduct(@PathVariable int id,Model model){
        model.addAttribute("product",productService.getProduct(id));
        return "product-view";
    }

    @GetMapping("/add")
    public String addProduct(Model model){
        Product product = new Product() ;
        product.setProductDetails(new ProductDetails());
        model.addAttribute("product" , product);
        return "product-form";
    }

    @PostMapping
    public String saveProduct(@Valid @ModelAttribute("product") Product product , BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "product-form";
        }

        productService.saveOrUpdate(product);

        return "redirect:/products";
    }


    @GetMapping("/edit/{id}")
    public String updateProduct(@PathVariable int id , Model model){
        Product product = productService.getProduct(id);
        if(product == null){
            return "redirect:/products";
        }
        model.addAttribute("product",product);
        return "product-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){

        productService.deleteProduct(id);

        return "redirect:/products";
    }
}