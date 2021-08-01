package com.rdm.jpa.jpademo.controller;


import com.rdm.jpa.jpademo.entity.Product;
import com.rdm.jpa.jpademo.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockReset;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

    @Mock
    ProductService productService ;
    @Mock
    RestTemplate restTemplate;
    @InjectMocks
    ProductController productController ;

    @Test
    public void getProductTest(){
        System.out.println("Start");
        Product product = new Product();
        product.setName("rdm");
        product.setId(1);
        product.setPrice(400);
        product.setQuantiy(100);
        List<Product> productLst = Arrays.asList(product);
        ResponseEntity<String> responseEntity = new ResponseEntity<String>("B", HttpStatus.ACCEPTED);
        when(productService.getProduct()).thenReturn(productLst);
        when(restTemplate.exchange(
                ArgumentMatchers.anyString(),
                ArgumentMatchers.any(HttpMethod.class),
                ArgumentMatchers.any(),
                ArgumentMatchers.<Class<String>>any()))
                .thenReturn(responseEntity);

        List<Product> products = productController.getProduct();
        Assert.assertEquals(1,products.size());

    }
}
