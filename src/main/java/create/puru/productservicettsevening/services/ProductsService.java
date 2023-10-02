package create.puru.productservicettsevening.services;

import create.puru.productservicettsevening.dtos.ProductDTO;
import create.puru.productservicettsevening.models.Category;
import create.puru.productservicettsevening.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.util.List;
import java.util.PrimitiveIterator;

public interface ProductsService {

    List<Product> GetAllProducts();
    Product addNewProduct(
            ProductDTO product
            );
    Product getSingleProduct(Long productId);
    Product updateProducts( Long productId,Product product);
    HttpStatusCode deleteProducts(Long productId);
}
