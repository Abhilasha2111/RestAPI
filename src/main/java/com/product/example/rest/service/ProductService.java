package com.product.example.rest.service;

import java.util.List;
import com.product.example.rest.exception.RecordNotFoundException;
import com.product.example.rest.model.Product;
public interface ProductService {
  public Product saveProduct(Product p);
  
  public List<Product> getAllProducts();
  
  public Product findProductById(long id) throws RecordNotFoundException;
  
  public Product updateProduct(Product p,long id) throws RecordNotFoundException;
  
  public void deleteProduct(long id);
}
