package com.product.example.rest.service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.product.example.rest.exception.RecordNotFoundException;
import com.product.example.rest.model.Product;
import com.product.example.rest.repository.ProductRepositoryInt;
@Service
public class ProductServiceImpl implements ProductService {
  private ProductRepositoryInt repo;
  
  
  public ProductServiceImpl(ProductRepositoryInt repo) {
    super();
    this.repo = repo;
  }
  @Override
  public Product saveProduct(Product p) {
    return repo.save(p);
  }
  @Override
  public List<Product> getAllProducts() {
    return repo.findAll();
  }
  @Override
  public Product findProductById(long id) throws RecordNotFoundException {
    Optional<Product> prod = repo.findById(id);
    if(prod.isPresent()) {
      return prod.get();
    }else
    {
      throw new RecordNotFoundException("Not found");
    }
  }
  @Override
  public Product updateProduct(Product p, long id) throws RecordNotFoundException {
    
    Product prod = repo.findById(id).get();
    if(prod.getId()!=0) {
      prod.setProductDescription(p.getProductDescription());
      prod.setProductName(p.getProductName());
      prod.setProductPrice(p.getProductPrice());
    }
    else
    {
      throw new RecordNotFoundException("Not found");
    }
    repo.save(prod);
    return prod;
    
    
  }
  @Override
  public void deleteProduct(long id) {
    repo.deleteById(id); 
  }
}