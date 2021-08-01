package com.rdm.jpa.jpademo.controller;

import com.rdm.jpa.jpademo.entity.Product;
import com.rdm.jpa.jpademo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController

public class ProductController {

    @Autowired
    ProductService productService ;
    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/addproduct")
    public Product addProduct(@RequestBody Product product){
       return productService.save(product);
    }

    @GetMapping("/getproduct")
  //  @Cacheable(value="ProductList")
    public List<Product> getProduct(){
        List<Product>products = productService.getProduct();
       /* HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String response = restTemplate.exchange("http://localhost:8017/empstatus/1",HttpMethod.GET,entity,String.class).getBody();
        products.get(0).setName(response);*/
        return products;
    }

    @RequestMapping("/deleteproduct/{id}")
    public String deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
        return "successfully deleted";
    }

    @PutMapping("/updateproduct/{id}")
    @CachePut(cacheNames="Product", key="#id")
    public Product updateProduct(@RequestBody Product product , @PathVariable Integer id){
         product =  productService.updateProduct(product , id);
        return product;
    }

    @RequestMapping("/findproduct/{id}")
    @Cacheable(cacheNames="Product" , key="#id")
    public Product findProduct(@PathVariable Integer id){
        Product product = productService.findProduct(id);
        System.out.println("In Controller" + product.getName());
        return product ;
    }
}
