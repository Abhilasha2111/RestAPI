package com.product.example.rest.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.product.example.rest.exception.RecordNotFoundException;
import com.product.example.rest.model.Product;
import com.product.example.rest.service.ProductService;
@RestController
@RequestMapping("/restapi/products")
public class ProductCtl {
  
  private ProductService service; 
  public ProductCtl(ProductService service) {
    super();
    this.service = service;
  }
  //1. Create REST API
  @PostMapping
  public ResponseEntity<Product> saveProduct(@RequestBody Product p){
    return new ResponseEntity<Product>(service.saveProduct(p),HttpStatus.CREATED);
  }
  //2. Get REST API
  @GetMapping
  public List<Product> getAllProducts(){
    return service.getAllProducts();
  }
  //3. Get REST API by Id
  @GetMapping("{id}")
  public ResponseEntity<Product> getProductById(@PathVariable("id") long productId) throws RecordNotFoundException{
    return new ResponseEntity<Product>(service.findProductById(productId),HttpStatus.OK);
  }
  
  //4. Update REST API
  @PutMapping("{id}")
  public ResponseEntity<Product> updateProduct(@RequestBody Product p,@PathVariable("id") long productId) throws RecordNotFoundException{
    return new ResponseEntity<Product>(service.updateProduct(p, productId), HttpStatus.OK);
    
  }
  //4 Delete REST API
  @DeleteMapping("{id}")
  public ResponseEntity<String> deleteProduct(@PathVariable("id") long productId){
    service.deleteProduct(productId);
    return new ResponseEntity<String>("Deleted",HttpStatus.OK);
  }
}
