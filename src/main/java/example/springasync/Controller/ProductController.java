package example.springasync.Controller;


import example.springasync.Entity.Product;
import example.springasync.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class ProductController {

    @Autowired
    ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping("products")
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping("products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("products/{productId}")
    public Product getProductById(@PathVariable long productId){
        return productService.getProductById(productId);
    }

    @GetMapping("products/sorted")
    public List<Product> getSortedProducts(){
        return productService.getSortedProducts();
    }

    @GetMapping("products/filter")
    public List<Product> filterProductsByPriceRange(@RequestParam long min, @RequestParam long max){
        return productService.filterProductsByPriceRange(min,max);
    }

    @GetMapping("products/count")
    public long getProductCount(){
        return productService.getProductCount();
    }

    @GetMapping("products/search")
    public List<Product> searchProductsByName(@RequestParam String name){
        return productService.searchProductsByName(name);
    }
}
