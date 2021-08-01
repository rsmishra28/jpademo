package com.rdm.jpa.jpademo.service;

import com.rdm.jpa.jpademo.entity.Product;
import com.rdm.jpa.jpademo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository ;

    public Product save(Product product){
        return repository.save(product);
    }

    public Product findProduct(Integer id){
        System.out.println("Inside service");
        return repository.getById(id);
    }

    public void deleteProduct(Integer id){
        repository.deleteById(id);
    }

    public Product updateProduct(Product product , Integer id){
        Product existingProduct = repository.getById(id);
        existingProduct.setName(product.getName());
        repository.save(existingProduct);
        return product;
    }

    public List<Product> getProduct(){
        return repository.findAll();
    }
}
