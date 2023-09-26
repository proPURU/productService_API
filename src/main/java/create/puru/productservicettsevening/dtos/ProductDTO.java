package create.puru.productservicettsevening.dtos;

import jakarta.websocket.server.ServerEndpoint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class ProductDTO {
        private  Long Id;
        private String title;
        private double price;
        private String description;
        private String image;
        private String category;
    }
