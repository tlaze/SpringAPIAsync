package example.springasync.Entity;


import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private int price;

    @Column
    private String description;




}
