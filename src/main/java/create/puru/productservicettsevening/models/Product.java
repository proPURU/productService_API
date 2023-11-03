package create.puru.productservicettsevening.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends BaseModel {
    private  String title;
    private double price;
    private String description;
    @ManyToOne()
    private Category category;
    private  String imageUrl;

    }

