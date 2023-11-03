package create.puru.productservicettsevening.services;

import create.puru.productservicettsevening.dtos.ProductDTO;
import create.puru.productservicettsevening.models.Product;
import org.springframework.http.HttpStatusCode;

import java.util.List;
import java.util.Optional;
import java.util.Spliterator;

public interface ProductsService {

    List<Product> GetAllProducts();
    Product addNewProduct(
            ProductDTO product
            );
    Optional<Product> getSingleProduct(Long productId);
    Product updateProducts( Long productId,Product product);
    String deleteProducts(Long productId);
}
