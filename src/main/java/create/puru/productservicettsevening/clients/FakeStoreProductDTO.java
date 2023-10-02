package create.puru.productservicettsevening.clients;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class FakeStoreProductDTO {
        private  Long Id;
        private String title;
        private double price;
        private String description;
        private String image;
        private String category;
    }
