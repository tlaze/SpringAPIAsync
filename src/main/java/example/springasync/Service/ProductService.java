package example.springasync.Service;

import example.springasync.Entity.Product;
import example.springasync.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(long id){
        Product product = productRepository.findById(id).get();
        return product;
    }

    public List<Product> getSortedProducts(){
        return productRepository.findAll(Sort.by("price"));

    }

    public List<Product> filterProductsByPriceRange(long min, long max){
        List<Product> filteredProducts = productRepository.findByPriceBetween(min,max);
        return filteredProducts;
    }

    public long getProductCount(){
        return productRepository.count();
    }

    public List<Product>searchProductsByName(String name){
        return productRepository.findByName(name);
    }
}
