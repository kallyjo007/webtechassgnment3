package auca.ac.rw.restfullApiAssignment.service;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auca.ac.rw.restfullApiAssignment.modal.ecommerce.Product;
import auca.ac.rw.restfullApiAssignment.repository.ProductRepository;

@Service
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public Product addNewProduct(Product product) {
    Optional<Product> existProduct = productRepository.findByName(product.getName());
    if (existProduct.isPresent()) {
      throw new RuntimeException("Product with name " + product.getName() + " already exists");
    }
    return productRepository.save(product);
  }

  public java.util.List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public Product getProductById(Long id) {
    return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
  }

  public Product updateProduct(Long id, Product product) {
    Product existingProduct = getProductById(id);
    existingProduct.setName(product.getName());
    existingProduct.setDescription(product.getDescription());
    existingProduct.setPrice(product.getPrice());
    existingProduct.setCategory(product.getCategory());
    existingProduct.setStockQuantity(product.getStockQuantity());
    existingProduct.setBrand(product.getBrand());
    return productRepository.save(existingProduct);
  }

  public void deleteProduct(Long id) {
    Product existingProduct = getProductById(id);
    productRepository.delete(existingProduct);
  }


  public List<Product> searchByCategory(String category){

    List<Product> products = productRepository.findByCategory(category);

    if(products != null && !products.isEmpty()){
      return products;
    }else{
      return null;
    }
  }




  public List<Product> searchByPriceAndBrand(Double price, String brand){
    List<Product> products = productRepository.findByPriceAndBrand(price, brand);

    if(products != null && !products.isEmpty()){
      return products;
    }else{
      return null;
    }
  }








  
}
