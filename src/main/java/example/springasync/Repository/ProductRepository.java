package example.springasync.Repository;

import example.springasync.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByPriceBetween(long min, long max);

    long count();

    List<Product> findByName(String name);
}
